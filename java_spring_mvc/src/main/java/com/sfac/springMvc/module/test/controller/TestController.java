package com.sfac.springMvc.module.test.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sfac.springMvc.module.test.entity.City;
import com.sfac.springMvc.module.test.service.CityService;

/**
 * Description: Test Controller
 * @author HymanHu
 * @date 2020-12-08 10:10:23
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	private final static Logger LOGGER = LogManager.getLogger(TestController.class);
	@Autowired
	private CityService cityService;
	
	/**
	 * 127.0.0.1:8080/java_spring_mvc/test/desc ---- get
	 */
	@GetMapping("/desc")
	@ResponseBody
	public String testDesc() {
		return "This is test module desc.";
	}
	
	/**
	 * 127.0.0.1/test/logger ---- get
	 */
	@GetMapping("/logger")
	@ResponseBody
	public String loggerTest() {
		LOGGER.trace("This is trace logger.");
		LOGGER.debug("This is debug logger.");
		LOGGER.info("This is info logger.");
		LOGGER.warn("This is warn logger.");
		LOGGER.error("This is error logger.");
		return "This is logger test.";
	}
	
	/**
	 * 127.0.0.1/test/index ---- get
	 */
	@GetMapping("/index")
	public String testIndexPage(ModelMap modelMap) {
		List<City> cities = cityService.getCitiesByCountryId(522);
		modelMap.put("userName", "HymanHu");
		modelMap.put("current1", new Date());
		modelMap.put("current2", LocalDateTime.now());
		modelMap.put("number", 23.453);
		modelMap.put("age", 18);
		modelMap.put("cities", cities.stream().limit(10).collect(Collectors.toList()));
		return "test/index";
	}

}
