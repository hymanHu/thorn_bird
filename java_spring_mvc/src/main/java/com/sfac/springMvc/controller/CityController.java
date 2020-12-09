package com.sfac.springMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sfac.springMvc.entity.City;
import com.sfac.springMvc.service.CityService;
import com.sfac.springMvc.vo.ResultEntity;

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
	 * {"cityName":"dreamCity", "localCityName":"梦想城市", "countryId":522, "district":"sichuan", "population":1780000}
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
}
