package com.sfac.springBoot.modules.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: Test Controller
 * @author: HymanHu
 * @date: 2021年2月17日
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
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
		return sb.toString();
	}
	
	/**
	 * 127.0.0.1/test/helloWorld ---- get
	 */
	@GetMapping("/helloWorld")
	@ResponseBody
	public String helloWorld() {
		return "Hello World!";
	}

}
