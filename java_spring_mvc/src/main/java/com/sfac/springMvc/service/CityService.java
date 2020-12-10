package com.sfac.springMvc.service;

import com.github.pagehelper.PageInfo;
import com.sfac.springMvc.entity.City;
import com.sfac.springMvc.entity.ResultEntity;
import com.sfac.springMvc.entity.SearchBean;

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
}
