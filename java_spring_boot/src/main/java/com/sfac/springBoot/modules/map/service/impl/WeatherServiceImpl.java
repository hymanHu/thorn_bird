package com.sfac.springBoot.modules.map.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sfac.springBoot.modules.map.dao.WeatherDao;
import com.sfac.springBoot.modules.map.entity.AmapWeather;
import com.sfac.springBoot.modules.map.entity.Weather;
import com.sfac.springBoot.modules.map.service.WeatherService;

/**
 * Description: Weather Service Impl
 * @author HymanHu
 * @date 2021-06-29 10:14:36
 */
@Service
public class WeatherServiceImpl implements WeatherService {
	
	@Autowired
	private RestTemplate restTemplate;
	@Value(value = "${amap.web.server.key}")
	private String amapKey;
	@Autowired
	private WeatherDao weatherDao;

	@Override
	public List<Weather> getWeatherByAdCode(String adCode) {
		
		// 查询数据库是否有 10 分钟内的数据，有则直接返回
		List<Weather> weathers = Optional
				.ofNullable(weatherDao.getWeathersByAdCodeAndMinutes(adCode, 10))
				.orElse(Collections.emptyList());
		if (weathers.size() > 0) {
			return weathers;
		}
		
		// 数据库没有 10 分钟内数据则调用远程接口，并将最新数据写入数据库
		String urlParttern = "http://restapi.amap.com/v3/weather/weatherInfo?key=%s&city=%s";
		String url = String.format(urlParttern, amapKey, adCode);
		AmapWeather amapWeather = restTemplate.getForObject(url, AmapWeather.class);
		weathers = amapWeather.getLives();
		weathers.stream().forEach(item -> {
			Weather temp = weatherDao.getWeatherByAdCodeAndReportTime(item.getAdCode(), item.getReportTime());
			if (temp == null) {
				item.setCreateDate(LocalDateTime.now());
				weatherDao.insertWeather(item);
			}
		});
		
		// 查询最近的数据
		weathers = Optional
				.ofNullable(weatherDao.getWeathersByAdCode(adCode))
				.orElse(Collections.emptyList());
		return weathers.stream().limit(10).collect(Collectors.toList());
	}

}
