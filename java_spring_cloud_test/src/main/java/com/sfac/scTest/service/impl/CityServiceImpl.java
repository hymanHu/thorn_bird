package com.sfac.scTest.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.common.entity.common.ResultEntity;
import com.sfac.common.entity.common.ResultEntity.ResultStatus;
import com.sfac.common.entity.common.SearchBean;
import com.sfac.common.entity.test.City;
import com.sfac.scTest.dao.CityDao;
import com.sfac.scTest.service.CityService;

/**
 * Description: City Service Impl
 * @author HymanHu
 * @date 2020-12-09 14:42:51
 */
@Service
public class CityServiceImpl implements CityService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);
	@Autowired
	private CityDao cityDao;
	@Value("${server.port}")
	private int port;

	@Override
	@Transactional
	public ResultEntity<City> insertCity(City city) {
		city.setDateCreated(new Date());
		cityDao.insertCity(city);
		return new ResultEntity<City>(ResultStatus.SUCCESS.status, "Insert city success.", city);
	}

	@Override
	@Transactional
	public ResultEntity<City> updateCity(City city) {
		city.setDateModified(new Date());
		cityDao.updateCity(city);
//		int i = 1 / 0;
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
		LOGGER.debug(String.format("==== %d ====", port));
		return cityDao.getCityByCityId(cityId);
	}

	@Override
	public PageInfo<City> getCitiesBySearchBean(SearchBean searchBean) {
		searchBean.initSearchBean();
		PageHelper.startPage(searchBean.getCurrentPage(), searchBean.getPageSize());
		return new PageInfo<City>(Optional.ofNullable(cityDao.getCitiesBySearchBean(searchBean))
				.orElse(Collections.emptyList()));
	}

	@Override
	public List<City> getCitiesByCountryId(int countryId) {
		return Optional.ofNullable(cityDao.getCitiesByCountryId2(countryId)).orElse(Collections.emptyList());
	}

}
