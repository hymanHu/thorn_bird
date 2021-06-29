package com.sfac.springBoot.modules.map.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.sfac.springBoot.modules.map.dao.RegionDao;
import com.sfac.springBoot.modules.map.entity.AmapRegion;
import com.sfac.springBoot.modules.map.entity.Region;
import com.sfac.springBoot.modules.map.entity.RegionLevel;
import com.sfac.springBoot.modules.map.service.RegionService;

/**
 * Description: Region ServiceImpl
 * @author HymanHu
 * @date 2021-06-28 09:15:50
 */
@Service
public class RegionServiceImpl implements RegionService {
	
	
	private final static Logger LOGGER = LoggerFactory.getLogger(RegionServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;
	@Value(value = "${amap.web.server.key}")
	private String amapKey;
	@Autowired
	private RegionDao regionDao;
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	@Transactional
	public List<Region> initRegionByAmap() {
		List<Region> allRegions = new ArrayList<Region>();
		String amapUrlParttern = "http://restapi.amap.com/v3/config/district?key=%s&keywords=%s&subdistrict=%d&showbiz=false&extensions=base";
		
		// 从中国查询，得到省市区县街道数据
		String url = String.format(amapUrlParttern, amapKey, "", 4);
		AmapRegion amapRegion = restTemplate.getForObject(url, AmapRegion.class);
		amapRegion.getDistricts().stream().forEach(item -> {
			loadRegions(allRegions, item);
		});
		
		// 删除数据库所有老数据
		regionDao.deleteAllRegion();
		
		/*
		 * - 批量插入行政区域数据
		 * - 使用 foreach 拼接 sql 方式，数据量大于 200 不推荐
		 */
//		regionDao.batchInsertRegions(allRegions);
		
		/*
		 * - 批量插入行政区域数据
		 * - 使用 BATCH 方式插入，手动提交事务
		 */
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
			RegionDao regionDaoTemp = sqlSession.getMapper(RegionDao.class);
//			for (int i = 0; i < allRegions.size(); i ++) {
//				regionDaoTemp.insertRegion(allRegions.get(i));
//			}
			allRegions.stream().forEach(item -> {
				regionDaoTemp.insertRegion(item);
			});
			sqlSession.commit();
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			sqlSession.rollback();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return allRegions;
	}
	
	public void loadRegions(List<Region> allRegions, Region region) {
		region.setCreateDate(LocalDateTime.now());
		Object citycode = region.getCitycode();
		region.setCityCode(citycode instanceof String ? citycode.toString() : "");
		allRegions.add(region);
		
		if (null == region.getDistricts() || region.getDistricts().size() == 0) {
			return;
		}
		region.getDistricts().stream().forEach(item -> {
			loadRegions(allRegions, item);
		});
	}

	@Override
	public Region getRegionByKeyWord(String keyWord, int subdistric) {
		
		Region currentRegion = regionDao.getRegionByKeyWord(keyWord);
		RegionLevel currentRegionLevel = RegionLevel.getRegionLevel(currentRegion.getLevel());
		// 最多查询级数，比如查询区县，下面还有 2 级，我们最多迭代 2 级，无需按 subdistric 迭代
		int maxSeries = subdistric > (4 - currentRegionLevel.code) ? 4 - currentRegionLevel.code : subdistric;
		
		buildSubDistric(currentRegion, maxSeries);
		return currentRegion;
	}
	
	/**
	 * - 设置某行政区域子节点
	 * @param region		行政区域
	 * @param maxSeries		加载子节点最大级数
	 */
	public void buildSubDistric(Region region, int maxSeries) {
		if (region == null || maxSeries == 0) {
			return;
		}
		String adCode = region.getAdCode();
		RegionLevel currentRegionLevel = RegionLevel.getRegionLevel(region.getLevel());
		RegionLevel subRegionLevel = RegionLevel.getSubRegionLevel(currentRegionLevel.code);
		if (subRegionLevel == null) {
			return;
		}
		
		String parentCode = "";
		if (currentRegionLevel == RegionLevel.COUNTRY) {
			parentCode = "";
		} else if (currentRegionLevel == RegionLevel.PROVINCE) {
			parentCode = adCode.substring(0, 2);
		} else if (currentRegionLevel == RegionLevel.CITY) {
			parentCode = adCode.substring(0, 4);
		} else {
			parentCode = adCode;
		}
		// 设置当前 region 子节点
		List<Region> districts = regionDao.getRegionsByParentCodeAndLevel(parentCode, subRegionLevel.level);
		region.setDistricts(districts);
		
		// 循环子节点，递归调用
		districts.stream().forEach(item -> {
			buildSubDistric(item, maxSeries - 1);
		});
	}
	
}
