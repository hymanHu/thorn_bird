package com.sfac.springBoot.modules.map.service;

import java.util.List;

import com.sfac.springBoot.modules.map.entity.Weather;

/**
 * Description: Weather Service
 * @author HymanHu
 * @date 2021-06-29 10:10:13
 */
public interface WeatherService {
	
	List<Weather> getWeatherByAdCode(String adCode);

}
