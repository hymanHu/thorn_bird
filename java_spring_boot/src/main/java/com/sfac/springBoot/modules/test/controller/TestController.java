package com.sfac.springBoot.modules.test.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sfac.springBoot.config.ApplicationTest;
import com.sfac.springBoot.modules.test.entity.City;
import com.sfac.springBoot.modules.test.entity.Country;
import com.sfac.springBoot.modules.test.service.CityService;
import com.sfac.springBoot.modules.test.service.CountryService;

/**
 * @Description: Test Controller
 * @author: HymanHu
 * @date: 2021年2月17日
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	
	@Value("${server.port}")
	private int port;
	@Value("${com.sfac.name}")
	private String name;
	@Value("${com.sfac.age}")
	private int age;
	@Value("${com.sfac.description}")
	private String description;
	@Value("${com.sfac.random}")
	private String random;
	
	@Autowired
	private ApplicationTest applicationTest;
	@Autowired
	private CityService cityService;
	@Autowired
	private CountryService countryService;
	
	/**
	 * 127.0.0.1/test/index ---- get
	 */
	@GetMapping("/index")
	public String testIndexPage(ModelMap modelMap) {
		int countryId = 522;
		Country country = countryService.getCountryByCountryId(countryId);
		List<City> cities = cityService.getCitiesByCountryId(countryId);
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
		
		modelMap.addAttribute("template", "test/index");
		return "index";
	}
	
	/**
	 * 127.0.0.1/test/logger ---- get
	 */
	@GetMapping("/logger")
	@ResponseBody
	public String loggerTest() {
		LOGGER.trace("This is trace log.");
		LOGGER.debug("This is debug log.");
		LOGGER.info("This is info log.");
		LOGGER.warn("This is warn log.");
		LOGGER.error("This is error log.");
		return "This is logger test.";
	}
	
	/**
	 * 127.0.0.1/test/config ---- get
	 */
	@RequestMapping("/config")
	@ResponseBody
	public String configTest() {
		StringBuffer sb = new StringBuffer();
		sb.append(port).append("----")
			.append(name).append("----")
			.append(age).append("----")
			.append(description).append("----")
			.append(random).append("<br>");
		sb.append(applicationTest.getName()).append("----")
			.append(applicationTest.getAge()).append("----")
			.append(applicationTest.getDescription()).append("----")
			.append(applicationTest.getRandom()).append("<br>");
		return sb.toString();
	}
	
	/**
	 * 127.0.0.1/test/helloWorld ---- get
	 */
	@GetMapping("/helloWorld")
	@ResponseBody
	public String helloWorld() {
		return "Hello World!!!!!!!";
	}

}
