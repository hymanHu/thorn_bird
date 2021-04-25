package com.sfac.scWeb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sfac.common.entity.test.City;
import com.sfac.common.entity.test.Country;
import com.sfac.scWeb.service.TestFeignClient;

/**
 * @Description: Test Controller
 * @author: HymanHu
 * @date: 2021年2月17日
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestFeignClient testFeignClient;
	
	/**
	 * 127.0.0.1/test/vueIndex ---- get
	 */
	@GetMapping("/vueIndex")
	public String vueIndexPage() {
		return "index";
	}
	
	/**
	 * 127.0.0.1/test/thymeleafIndex ---- get
	 */
	@GetMapping("/thymeleafIndex")
	public String thymeleafIndexPage(ModelMap modelMap) {
		int countryId = 522;
		Country country = testFeignClient.getCountryByCountryId(countryId);
		List<City> cities = country != null && country.getCities() != null ? country.getCities() : new ArrayList<City>();
		cities = cities.stream().limit(10).collect(Collectors.toList());
		
		modelMap.addAttribute("checked", true);
		modelMap.addAttribute("currentNumber", 99);
		modelMap.addAttribute("changeType", "checkbox");
		modelMap.addAttribute("baiduUrl", "/test/config");
//		modelMap.addAttribute("shopLogo", "http://cdn.duitang.com/uploads/item/201308/13/20130813115619_EJCWm.thumb.700_0.jpeg");
		modelMap.addAttribute("country", country);
		modelMap.addAttribute("cities", cities);
		modelMap.addAttribute("updateCityUri", "/api/city");
		modelMap.addAttribute("city", cities.get(0));
		modelMap.addAttribute("thymeleafTitle", "This is thymeleaf page.");
		
//		modelMap.addAttribute("template", "test/index");
		return "index";
	}

}
