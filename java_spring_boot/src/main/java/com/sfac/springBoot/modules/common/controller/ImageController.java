package com.sfac.springBoot.modules.common.controller;

import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Description: Image Controller
 * @author HymanHu
 * @date 2020-11-20 13:59:59
 */
@RestController
@RequestMapping("/api")
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	/**
	 * 127.0.0.1/api/image/profile-big ---- post
	 */
	@PostMapping(value = "/image/{type}", consumes = "multipart/form-data")
	public ResultEntity<String> uploadImage(@RequestParam MultipartFile image, @PathVariable String type) {
		return imageService.uploadImage(image, type);
	}
	
}
