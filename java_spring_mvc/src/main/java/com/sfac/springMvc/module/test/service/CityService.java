package com.sfac.springMvc.module.test.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.SearchBean;
import com.sfac.springMvc.module.test.entity.City;

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
