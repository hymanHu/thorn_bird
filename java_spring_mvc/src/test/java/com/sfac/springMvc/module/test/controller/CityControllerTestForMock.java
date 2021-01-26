package com.sfac.springMvc.module.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;

import com.sfac.springMvc.module.test.entity.City;
import com.sfac.springMvc.module.test.service.CityService;

import junit.framework.TestCase;

/**
 * Description: City Controller Test For Mockit
 * @author HymanHu
 * @date 2021-01-26 09:24:12
 */
@RunWith(MockitoJUnitRunner.class)
public class CityControllerTestForMock {
	
	@InjectMocks
	private CityController cityController;
	@Mock
	private CityService cityService;
	
	@Test
	public void testGetCityByCityId() {
		City city = new City();
		city.setCityId(2250);
		city.setCityName("aaaaa");
		PowerMockito.when(cityService.getCityByCityId(city.getCityId())).thenReturn(city);
		City result = cityController.getCityByCityId(city.getCityId());
		TestCase.assertEquals(city.getCityName(), result.getCityName());
	}

}
