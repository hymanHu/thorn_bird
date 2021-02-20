package com.sfac.springBoot.modules.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: Common Controller
 * @author: HymanHu
 * @date: 2021年2月20日
 */
@Controller
@RequestMapping("/common")
public class CommonController {

	/**
	 * 127.0.0.1/common/403 ---- get
	 */
	@GetMapping("/403")
	public String errorPageFor403() {
		return "indexError";
	}
	
	/**
	 * 127.0.0.1/common/404 ---- get
	 */
	@GetMapping("/404")
	public String errorPageFor404() {
		return "indexError";
	}
	
	/**
	 * 127.0.0.1/common/500 ---- get
	 */
	@GetMapping("/500")
	public String errorPageFor500() {
		return "indexError";
	}
}
