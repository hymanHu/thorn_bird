package com.sfac.springMvc.module.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sfac.springMvc.module.test.entity.City;
import com.sfac.springMvc.module.test.service.CityService;

import junit.framework.TestCase;

/**
 * Description: City Controller Test
 * @author HymanHu
 * @date 2021-01-26 09:24:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/applicationContext.xml",
		"classpath:config/springMvcConfig.xml",
		"classpath:config/mybatisConfig.xml",
		"classpath:config/springHibernate.xml",
		"classpath:config/springJpa.xml"})
@WebAppConfiguration("src/main/webapp")
public class CityControllerTest_ {
	
	@Autowired
	private CityService cityService;
	
	@Test
	public void testGetCityByCityId() {
		City city = cityService.getCityByCityId(2250);
		TestCase.assertNotNull(city);
	}
}
