package com.sfac.springMvc.module.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sfac.springMvc.module.test.entity.Country;
import com.sfac.springMvc.module.test.service.CountryService;

/**
 * Description: Country Controller
 * @author HymanHu
 * @date 2020-12-10 10:22:52
 */
@RestController
@RequestMapping("/api")
public class CountryController {
	
	@Autowired
	private CountryService countryService;

	/**
	 * 127.0.0.1/api/country/522 ---- get
	 */
	@GetMapping("/country/{countryId}")
	public Country getCountryByCountryId(@PathVariable int countryId) {
		return countryService.getCountryByCountryId(countryId);
	}
	
	/**
	 * 127.0.0.1/api/country?countryName=China ---- get
	 */
	@GetMapping("/country")
	public Country getCountryByCountryName(@RequestParam String countryName) {
		return countryService.getCountryByCountryName(countryName);
	}
}
