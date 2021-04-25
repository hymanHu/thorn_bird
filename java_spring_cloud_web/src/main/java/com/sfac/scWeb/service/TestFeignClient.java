package com.sfac.scWeb.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sfac.common.entity.test.City;
import com.sfac.common.entity.test.Country;

/**
 * Description: Test Feign Client， 指定生产者注册名
 * @author HymanHu
 * @date 2021-04-23 16:32:25
 */
@Component
@FeignClient(name = "client-test")
public interface TestFeignClient {

	/**
	 * 127.0.0.1/api/test/city/2261 ---- get
	 * - 此处整合了 Spring MVC 的用法
	 */
	@GetMapping("/api/test/city/{cityId}")
	public City getCityByCityId(@PathVariable int cityId);
	
	/**
	 * 127.0.0.1/api/test/country/522 ---- get
	 */
	@GetMapping("/api/test/country/{countryId}")
	public Country getCountryByCountryId(@PathVariable int countryId);
}
