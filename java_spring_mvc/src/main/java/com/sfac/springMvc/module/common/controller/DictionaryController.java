package com.sfac.springMvc.module.common.controller;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sfac.springMvc.module.common.entity.ImageType;
import com.sfac.springMvc.module.humanNature.entity.TrackType;

/**
 * @Description: Dictionary Controller
 * @author: HymanHu
 * @date: 2021年2月8日
 */
@RestController
@RequestMapping("/api/dict")
@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
public class DictionaryController {
	
	private final static Logger LOGGER = LogManager.getLogger(DictionaryController.class);

	private static Map<String, Class> enumMaps = new HashMap<String, Class>(){{
		put("imageTypes", ImageType.class);
		put("trackTypes", TrackType.class);
	}};
	
	/**
	 * 127.0.0.1/api/dict/imageTypes
	 */
	@RequestMapping("/{enumName}")
	public List<Object> findDict(@PathVariable String enumName) {
		try {
			if (enumMaps.containsKey(enumName)) {
				Class clazz = enumMaps.get(enumName);
				Method valuesMethod = clazz.getDeclaredMethod("values");
				Object[] values = (Object[]) valuesMethod.invoke(null);
				return Arrays.asList(values);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug(e.getMessage());
		}
		
		return null;
	}
	
}
