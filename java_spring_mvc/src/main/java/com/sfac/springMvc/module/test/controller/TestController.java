package com.sfac.springMvc.module.test.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sfac.springMvc.module.test.entity.City;
import com.sfac.springMvc.module.test.service.CityService;

/**
 * Description: Test Controller
 * @author HymanHu
 * @date 2020-12-08 10:10:23
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	private final static Logger LOGGER = LogManager.getLogger(TestController.class);
	private final static String LOCAL_FILE_PATH = "D:/upload/";
	private final static String RELATIVE_FILE_PATH = "/upload/";
	@Autowired
	private CityService cityService;
	
	/**
	 * 127.0.0.1:8080/java_spring_mvc/test/desc ---- get
	 */
	@GetMapping("/desc")
	@ResponseBody
	public String testDesc() {
		return "This is test module desc.";
	}
	
	/**
	 * 127.0.0.1/test/logger ---- get
	 */
	@GetMapping("/logger")
	@ResponseBody
	public String loggerTest() {
		LOGGER.trace("This is trace logger.");
		LOGGER.debug("This is debug logger.");
		LOGGER.info("This is info logger.");
		LOGGER.warn("This is warn logger.");
		LOGGER.error("This is error logger.");
		return "This is logger test.";
	}
	
	/**
	 * 127.0.0.1/test/index ---- get
	 */
	@GetMapping("/index")
	public String testIndexPage(ModelMap modelMap) {
		List<City> cities = cityService.getCitiesByCountryId(522);
		City city = cityService.getCityByCityId(2255);
		modelMap.put("userName", "HymanHu");
		modelMap.put("current1", new Date());
		modelMap.put("current2", LocalDateTime.now());
		modelMap.put("number", 23.453);
		modelMap.put("age", 18);
		modelMap.put("cities", cities.stream().limit(10).collect(Collectors.toList()));
		modelMap.put("city", city);
		return "test/index";
	}
	
	/**
	 * 127.0.0.1/test/city ---- put
	 */
	@PutMapping(value = "/city", consumes = "application/x-www-form-urlencoded")
	public String updateCityForm(@ModelAttribute City city) {
		cityService.updateCity(city);
		return "redirect:/test/index";
	}
	
	/**
	 * 127.0.0.1/test/file ---- post
	 */
	@PostMapping(value = "/file", consumes = "multipart/form-data")
	public String uploadFile(@RequestParam MultipartFile file, 
			RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select file");
			return "redirect:/test/index";
		}
		
		String absolutePath = LOCAL_FILE_PATH + file.getOriginalFilename();
		String relativePath = RELATIVE_FILE_PATH + file.getOriginalFilename();
		try {
			File destFile = new File(absolutePath);
			file.transferTo(destFile);
	        
	        // 使用工具类 Files 来上传文件
//			byte[] bytes = file.getBytes();
//			Path path = Paths.get(absolutePath);
//			Files.write(path, bytes);
		
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "Upload fail.");
			return "redirect:/test/index";
		}
		
		redirectAttributes.addFlashAttribute("message", "Upload success.");
		redirectAttributes.addFlashAttribute("relativePath", relativePath);
		
		return "redirect:/test/index";
	}
	
	/**
	 * 127.0.0.1/test/files ---- post
	 */
	@PostMapping(value="/files", consumes="multipart/form-data")
	public String uploadFiles(@RequestParam MultipartFile[] files, 
			RedirectAttributes redirectAttributes) {
		boolean isEmpty = true;
		
		try {
			for (MultipartFile file : files) {
				if (file.isEmpty()) {
					continue;
				}
				
				String fileName = file.getOriginalFilename();
				String destFilePath = "D:\\upload\\" + fileName;
				File destFile = new File(destFilePath);
				file.transferTo(destFile);
				
				isEmpty = false;
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "Upload file failed.");
			return "redirect:/test/index";
		}
		
		if (isEmpty) {
			redirectAttributes.addFlashAttribute("message", "Please select file.");
		} else {
			redirectAttributes.addFlashAttribute("message", "Upload file success.");
		}
		return "redirect:/test/index";
	}

}
