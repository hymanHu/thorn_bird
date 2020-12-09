package com.sfac.springMvc.service;

import com.sfac.springMvc.entity.City;
import com.sfac.springMvc.vo.ResultEntity;

/**
 * Description: City Service
 * @author HymanHu
 * @date 2020-12-09 14:39:48
 */
public interface CityService {

	ResultEntity<City> insertCity(City city);
	
	ResultEntity<City> updateCity(City city);
}
