package com.sfac.springBoot.modules.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: Pay Controller
 * @author HymanHu
 * @date 2021-03-30 13:31:48
 */
@Controller
@RequestMapping("/pay")
public class PayController {

	/**
	 * 127.0.0.1/pay/alipayIndex ---- get
	 */
	@GetMapping("/alipayIndex")
	public String alipayIndex() {
		return "index";
	}
	
}
