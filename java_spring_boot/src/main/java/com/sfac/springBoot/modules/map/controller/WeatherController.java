package com.sfac.springBoot.modules.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sfac.springBoot.modules.map.entity.Weather;
import com.sfac.springBoot.modules.map.service.WeatherService;

/**
 * Description: Weather Controller
 * @author HymanHu
 * @date 2021-06-29 10:24:18
 */
@RestController
@RequestMapping("/api")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	/**
	 * 127.0.0.1/api/weather/510502 ---- get
	 */
	@GetMapping("/weather/{adCode}")
	public List<Weather> getWeatherByAdCode(@PathVariable String adCode) {
		return weatherService.getWeatherByAdCode(adCode);
	}
}
