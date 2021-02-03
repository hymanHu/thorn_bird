package com.sfac.springMvc.module.common.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sfac.springMvc.config.ResourceConfigBean;
import com.sfac.springMvc.module.common.entity.ImageType;
import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.ResultEntity.ResultStatus;
import com.sfac.springMvc.module.common.service.ImageService;
import com.sfac.springMvc.util.FileUtil;

/**
 * Description: Image Service Impl
 * @author HymanHu
 * @date 2021-02-03 10:25:36
 */
@Service
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ResourceConfigBean resourceConfigBean;

	@Override
	public ResultEntity<String> uploadImage(MultipartFile image, String imageType) {
		if (image.isEmpty()) {
			return new ResultEntity<>(ResultStatus.FAILED.status, "User image is empty.");
		}
		if (!FileUtil.isImage(image)) {
			return new ResultEntity<>(ResultStatus.FAILED.status, "File is not a image.");
		}
		
		File destFolder = new File(String.format("%s%s/", 
				resourceConfigBean.getResourcePathLocalWindows(), 
				ImageType.getImageTypeByName(imageType).name));
		if (!destFolder.exists()) {
			destFolder.mkdir();
		}
		
		String filename = String.format("%s%s", 
				System.currentTimeMillis(),
				image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf(".")));
		String absolutePath = String.format("%s%s", destFolder, filename);
		String relatedPath = String.format("%s%s/%s", 
				resourceConfigBean.getResourcePathPattern(), 
				ImageType.getImageTypeByName(imageType).name,
				filename);
		
		try {
			File destFile = new File(absolutePath);
			image.transferTo(destFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return new ResultEntity<>(ResultStatus.FAILED.status, "File upload error.");
		}
		
		return new ResultEntity<>(ResultStatus.SUCCESS.status, "File upload success.", relatedPath);
	}
}
