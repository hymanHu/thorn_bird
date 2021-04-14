package com.sfac.scTest.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sfac.common.entity.common.ResultEntity;
import com.sfac.common.entity.common.SearchBean;
import com.sfac.common.entity.test.City;

/**
 * Description: City Service
 * @author HymanHu
 * @date 2020-12-09 14:39:48
 */
public interface CityService {

	ResultEntity<City> insertCity(City city);
	
	ResultEntity<City> updateCity(City city);
	
	ResultEntity<Object> deleteCityByCityId(int cityId);
	
	City getCityByCityId(int cityId);
	
	PageInfo<City> getCitiesBySearchBean(SearchBean searchBean);
	
	List<City> getCitiesByCountryId(int countryId);
}
