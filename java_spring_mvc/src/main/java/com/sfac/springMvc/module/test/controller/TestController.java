package com.sfac.springMvc.module.test.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: Test Controller
 * @author HymanHu
 * @date 2020-12-08 10:10:23
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	private final static Logger LOGGER = LogManager.getLogger(TestController.class);
	
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

}
