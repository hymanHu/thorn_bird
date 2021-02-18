package com.sfac.springBoot.modules.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sfac.springBoot.modules.test.dao.CountryDao;
import com.sfac.springBoot.modules.test.entity.Country;
import com.sfac.springBoot.modules.test.service.CountryService;

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
