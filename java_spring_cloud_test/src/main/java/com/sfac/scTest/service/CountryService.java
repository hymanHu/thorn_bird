package com.sfac.scTest.service;

import com.sfac.common.entity.test.Country;

/**
 * Description: Country Service
 * @author HymanHu
 * @date 2020-12-10 10:20:24
 */
public interface CountryService {

	Country getCountryByCountryId(int countryId);
	
	Country getCountryByCountryName(String countryName);
	
}
