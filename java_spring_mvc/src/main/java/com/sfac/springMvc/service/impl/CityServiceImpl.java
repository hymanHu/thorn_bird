package com.sfac.springMvc.service.impl;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sfac.springMvc.dao.CityDao;
import com.sfac.springMvc.dao.CityMapper;
import com.sfac.springMvc.entity.City;
import com.sfac.springMvc.service.CityService;
import com.sfac.springMvc.vo.ResultEntity;
import com.sfac.springMvc.vo.ResultEntity.ResultStatus;

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

}
