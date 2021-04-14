package com.sfac.scTest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sfac.common.entity.test.Country;
import com.sfac.scTest.dao.CountryDao;
import com.sfac.scTest.service.CountryService;

/**
 * Description: Country Service Impl
 * @author HymanHu
 * @date 2020-12-10 10:21:06
 */
@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryDao countryDao;

	@Override
	public Country getCountryByCountryId(int countryId) {
		return countryDao.getCountryByCountryId(countryId);
	}

	@Override
	public Country getCountryByCountryName(String countryName) {
		return countryDao.getCountryByCountryName(countryName);
	}

}
