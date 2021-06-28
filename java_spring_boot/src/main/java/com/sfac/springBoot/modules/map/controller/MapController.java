package com.sfac.springBoot.modules.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: AMap Controller
 * @author HymanHu
 * @date 2021-06-01 09:55:55
 */
@Controller
@RequestMapping("/map")
public class MapController {
	
	/**
	 * 127.0.0.1/map/amapIndex ---- get
	 */
	@GetMapping("/amapIndex")
	public String amapIndexPage() {
		return "index";
	}

}
