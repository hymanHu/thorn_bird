package com.sfac.springMvc.module.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: Common Controller
 * @author HymanHu
 * @date 2021-01-25 13:37:33
 */
@Controller
@RequestMapping("/common")
public class CommonController {
	
	/**
	 * 127.0.0.1/common/dashboard ---- get
	 */
	@GetMapping("/dashboard")
	public String dashboardPage() {
		return "common/dashboard";
	}

}
