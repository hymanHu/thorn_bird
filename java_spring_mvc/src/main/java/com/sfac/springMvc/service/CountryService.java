package com.sfac.springMvc.service;

import com.sfac.springMvc.entity.Country;

/**
 * Description: Country Service
 * @author HymanHu
 * @date 2020-12-10 10:20:24
 */
public interface CountryService {

	Country getCountryByCountryId(int countryId);
	
	Country getCountryByCountryName(String countryName);
	
}
