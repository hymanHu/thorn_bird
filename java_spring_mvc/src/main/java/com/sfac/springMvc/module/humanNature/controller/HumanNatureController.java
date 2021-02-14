package com.sfac.springMvc.module.humanNature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: Human Nature Controller
 * @author: HymanHu
 * @date: 2021年2月9日
 */
@Controller
@RequestMapping("/humanNature")
public class HumanNatureController {
	
	/**
	 * 127.0.0.1/humanNature/tracks
	 */
	@GetMapping("/tracks")
	public String tracksPage() {
		return "humanNature/tracks";
	}
	
	/**
	 * 127.0.0.1/humanNature/trackChart
	 */
	@GetMapping("/trackChart")
	public String trackChartPage() {
		return "humanNature/trackChart";
	}

}
