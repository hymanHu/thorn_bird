package com.sfac.springBoot.modules.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.test.entity.City;
import com.sfac.springBoot.modules.test.service.CityService;

/**
 * Description: City Controller
 * @author HymanHu
 * @date 2020-12-09 14:45:34
 */
@RestController
@RequestMapping("/api")
public class CityController {
	
	@Autowired
	private CityService cityService;

	/**
	 * 127.0.0.1/api/city ---- post
	 * {"cityName":"dreamCity", "localCityName":"梦想城市", "countryId":522, 
	 * "district":"sichuan", "population":1780000}
	 */
	@PostMapping(value = "/city", consumes = "application/json")
	public ResultEntity<City> insertCity(@RequestBody City city) {
		return cityService.insertCity(city);
	}
	
	/**
	 * 127.0.0.1/api/city ---- put
	 * cityId=2261,cityName=dreamCity,localCityName=梦想城市1,
	 * countryId=522,district=sichuan,population=1780001
	 */
	@PutMapping(value = "/city", consumes = "application/x-www-form-urlencoded")
	public ResultEntity<City> updateCity(@ModelAttribute City city) {
		return cityService.updateCity(city);
	}
	
	/**
	 * 127.0.0.1/api/city/2260 ---- delete
	 */
	@DeleteMapping("/city/{cityId}")
	public ResultEntity<Object> deleteCityByCityId(@PathVariable int cityId) {
		return cityService.deleteCityByCityId(cityId);
	}
	
	/**
	 * 127.0.0.1/api/city/2261 ---- get
	 */
	@GetMapping("/city/{cityId}")
	public City getCityByCityId(@PathVariable int cityId) {
		int i = 1 / 0;
		return cityService.getCityByCityId(cityId);
	}
	
	/**
	 * 127.0.0.1/api/cities ---- post
	 * {"currentPage":1, "pageSize":5, "keyWord":"china", "orderBy":"ci.city_id", "direction":"desc"}
	 */
	@PostMapping(value = "/cities", consumes = "application/json")
	public PageInfo<City> getCitiesBySearchBean(@RequestBody SearchBean searchBean) {
		return cityService.getCitiesBySearchBean(searchBean);
	}
}
