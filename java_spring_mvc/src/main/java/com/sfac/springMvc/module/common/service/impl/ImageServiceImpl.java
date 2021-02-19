package com.sfac.springMvc.module.common.service.impl;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	private final static Logger LOGGER = LogManager.getLogger(ImageServiceImpl.class);
	@Autowired
	private ResourceConfigBean resourceConfigBean;

	@Override
	public ResultEntity<String> uploadImage(MultipartFile image, String type) {
		if (image.isEmpty()) {
			return new ResultEntity<>(ResultStatus.FAILED.status, "User image is empty.");
		}
		
		ImageType imageType = ImageType.getImageTypeByName(type);
		
		File destFolder = new File(String.format("%s%s", 
				resourceConfigBean.getLocalPathForWindow(), 
				imageType.name));
		if (!destFolder.exists()) {
			destFolder.mkdir();
		}
		
		String filename = String.format("%s.%s", 
				System.currentTimeMillis(),
				FileUtil.getFileType(image.getOriginalFilename()));
		String absolutePath = String.format("%s/%s", destFolder, filename);
		String relatedPath = String.format("%s%s/%s", 
				resourceConfigBean.getResourcePath(), 
				imageType.name,
				filename);
		LOGGER.debug("absolutePath: " + absolutePath);
		LOGGER.debug("relatedPath: " + relatedPath);
		
		try {
			File destFile = new File(absolutePath);
			image.transferTo(destFile);
			FileUtil.changeImageSize(absolutePath, absolutePath, imageType.maxWidth, imageType.maxHeight);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return new ResultEntity<>(ResultStatus.FAILED.status, "File upload error.");
		}
		
		return new ResultEntity<>(ResultStatus.SUCCESS.status, "File upload success.", relatedPath);
	}
}
