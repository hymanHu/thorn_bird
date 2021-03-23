package com.sfac.springBoot.modules.traffic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: Traffic Controller
 * @author HymanHu
 * @date 2021-03-12 17:03:46
 */
@Controller
@RequestMapping("/traffic")
public class TrafficController {
	
	/**
	 * 127.0.0.1/traffic/parkingSpaces ---- get
	 */
	@GetMapping("/parkingSpaces")
	public String parkingSpacesPage() {
		return "index";
	}
	
	/**
	 * 127.0.0.1/traffic/parkingCharges ---- get
	 */
	@GetMapping("/parkingCharges")
	public String ParkingChargePage() {
		return "index";
	}

}
