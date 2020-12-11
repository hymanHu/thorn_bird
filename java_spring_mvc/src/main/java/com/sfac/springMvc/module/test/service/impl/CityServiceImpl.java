package com.sfac.springMvc.module.test.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.SearchBean;
import com.sfac.springMvc.module.common.entity.ResultEntity.ResultStatus;
import com.sfac.springMvc.module.test.dao.CityDao;
import com.sfac.springMvc.module.test.dao.CityMapper;
import com.sfac.springMvc.module.test.entity.City;
import com.sfac.springMvc.module.test.service.CityService;

/**
 * Description: City Service Impl
 * @author HymanHu
 * @date 2020-12-09 14:42:51
 */
@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityMapper cityMapper;
	@Autowired
	private CityDao cityDao;

	@Override
	@Transactional
	public ResultEntity<City> insertCity(City city) {
		city.setDateCreated(new Date());
		/*
		 * -实现方式一：*Mapper.xml + *Mapper.java 接口
		 * -如果使用逆向工程生成的 Mapper.xml 文件，无法返回主键值，需要修改 Mapper.xml 中的 insert 方法；
		 * <insert id="insert" parameterType="com.sfac.springMvc.entity.City" useGeneratedKeys="true" keyProperty="cityId">
		 */
//		cityMapper.insert(city);
		/*
		 * -实现方式二：纯接口 + 注解开发
		 */
		cityDao.insertCity(city);
		return new ResultEntity<City>(ResultStatus.SUCCESS.status, "Insert city success.", city);
	}

	@Override
	@Transactional
	public ResultEntity<City> updateCity(City city) {
		city.setDateModified(new Date());
		cityDao.updateCity(city);
		return new ResultEntity<City>(ResultStatus.SUCCESS.status, "Update city success.", city);
	}

	@Override
	@Transactional
	public ResultEntity<Object> deleteCityByCityId(int cityId) {
		cityDao.deleteCityByCityId(cityId);
		return new ResultEntity<Object>(ResultStatus.SUCCESS.status, "Delete city success.");
	}

	@Override
	public City getCityByCityId(int cityId) {
		return cityDao.getCityByCityId(cityId);
	}

	@Override
	public PageInfo<City> getCitiesBySearchBean(SearchBean searchBean) {
		searchBean.initSearchBean();
		PageHelper.startPage(searchBean.getCurrentPage(), searchBean.getPageSize());
		return new PageInfo<City>(Optional.ofNullable(cityDao.getCitiesBySearchBean(searchBean))
				.orElse(Collections.emptyList()));
	}

}
