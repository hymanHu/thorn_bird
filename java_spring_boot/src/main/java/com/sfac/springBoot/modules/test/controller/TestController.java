package com.sfac.springBoot.modules.test.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sfac.springBoot.config.ApplicationTest;
import com.sfac.springBoot.config.ResourceConfigBean;
import com.sfac.springBoot.modules.test.entity.City;
import com.sfac.springBoot.modules.test.entity.Country;
import com.sfac.springBoot.modules.test.service.CityService;
import com.sfac.springBoot.modules.test.service.CountryService;

/**
 * @Description: Test Controller
 * @author: HymanHu
 * @date: 2021年2月17日
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	
	@Value("${server.port}")
	private int port;
	@Value("${com.sfac.name}")
	private String name;
	@Value("${com.sfac.age}")
	private int age;
	@Value("${com.sfac.description}")
	private String description;
	@Value("${com.sfac.random}")
	private String random;
	
	@Autowired
	private ApplicationTest applicationTest;
	@Autowired
	private CityService cityService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private ResourceConfigBean resourceConfigBean;
	
	/**
	 * 127.0.0.1/test/vueIndex ---- get
	 */
	@GetMapping("/vueIndex")
	public String vueIndexPage() {
		return "index";
	}
	
	/**
	 * 127.0.0.1/test/file?fileName=***.jpg ---- get
	 */
	@RequestMapping("/file")
	public ResponseEntity<Resource> downLoadFile(@RequestParam String fileName) {
		try {
			Resource resource = new UrlResource(Paths.get(
					resourceConfigBean.getLocalPathForWindow() + fileName).toUri());
			
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
					.header(HttpHeaders.CONTENT_DISPOSITION, 
							String.format("attachment; filename=\"%s\"", resource.getFilename()))
					.body(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
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
				String destFilePath = resourceConfigBean.getLocalPathForWindow() + fileName;
				File destFile = new File(destFilePath);
				file.transferTo(destFile);
				
				isEmpty = false;
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "Upload file failed.");
			return "redirect:/test/thymeleafIndex";
		}
		
		if (isEmpty) {
			redirectAttributes.addFlashAttribute("message", "Please select file.");
		} else {
			redirectAttributes.addFlashAttribute("message", "Upload file success.");
		}
		
		return "redirect:/test/thymeleafIndex";
	}

	/**
	 * 127.0.0.1/test/file ---- post
	 */
	@PostMapping(value = "/file", consumes = "multipart/form-data")
	public String uploadFile(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes) {
		
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select file");
			return "redirect:/test/thymeleafIndex";
		}
		
		String absolutePath = resourceConfigBean.getLocalPathForWindow() + file.getOriginalFilename();
		String relativePath = resourceConfigBean.getResourcePath() + file.getOriginalFilename();
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
			return "redirect:/test/thymeleafIndex";
		}
		
		redirectAttributes.addFlashAttribute("message", "Upload success.");
		redirectAttributes.addFlashAttribute("relativePath", relativePath);
		
		return "redirect:/test/thymeleafIndex";
	}
	
	/**
	 * 127.0.0.1/test/thymeleafIndex ---- get
	 */
	@GetMapping("/thymeleafIndex")
	public String thymeleafIndexPage(ModelMap modelMap) {
		int countryId = 522;
		Country country = countryService.getCountryByCountryId(countryId);
		List<City> cities = cityService.getCitiesByCountryId(countryId);
		cities = cities.stream().limit(10).collect(Collectors.toList());
		
		modelMap.addAttribute("checked", true);
		modelMap.addAttribute("currentNumber", 99);
		modelMap.addAttribute("changeType", "checkbox");
		modelMap.addAttribute("baiduUrl", "/test/config");
//		modelMap.addAttribute("shopLogo", "http://cdn.duitang.com/uploads/item/201308/13/20130813115619_EJCWm.thumb.700_0.jpeg");
		modelMap.addAttribute("country", country);
		modelMap.addAttribute("cities", cities);
		modelMap.addAttribute("updateCityUri", "/api/city");
		modelMap.addAttribute("city", cities.get(0));
		modelMap.addAttribute("thymeleafTitle", "This is thymeleaf page.");
		
//		modelMap.addAttribute("template", "test/index");
		return "index";
	}
	
	/**
	 * 127.0.0.1/test/logger ---- get
	 */
	@GetMapping("/logger")
	@ResponseBody
	public String loggerTest() {
		LOGGER.trace("This is trace log.");
		LOGGER.debug("This is debug log.");
		LOGGER.info("This is info log.");
		LOGGER.warn("This is warn log.");
		LOGGER.error("This is error log.");
		return "This is logger test.";
	}
	
	/**
	 * 127.0.0.1/test/config ---- get
	 */
	@RequestMapping("/config")
	@ResponseBody
	public String configTest() {
		StringBuffer sb = new StringBuffer();
		sb.append(port).append("----")
			.append(name).append("----")
			.append(age).append("----")
			.append(description).append("----")
			.append(random).append("<br>");
		sb.append(applicationTest.getName()).append("----")
			.append(applicationTest.getAge()).append("----")
			.append(applicationTest.getDescription()).append("----")
			.append(applicationTest.getRandom()).append("<br>");
		return sb.toString();
	}
	
	/**
	 * 127.0.0.1/test/helloWorld ---- get
	 */
	@GetMapping("/helloWorld")
	@ResponseBody
	public String helloWorld(HttpServletRequest request, @RequestParam(required = false) String key) {
		String key2 = request.getParameter("key");
		return String.format("Hello World! %s -- %s", key, key2);
	}

}
