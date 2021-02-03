package com.sfac.springMvc.module.common.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.entity.ResultEntity.ResultStatus;
import com.sfac.springMvc.module.common.service.ImageService;
import com.sfac.springMvc.util.FileUtil;
import com.sun.net.httpserver.Authenticator.Result;

/**
 * Description: Image Service Impl
 * @author HymanHu
 * @date 2021-02-03 10:25:36
 */
@Service
public class ImageServiceImpl implements ImageService {
	

	@Override
	public ResultEntity<String> uploadImage(MultipartFile image, String imageType) {
		if (image.isEmpty()) {
			return new ResultEntity<>(ResultStatus.FAILED.status, "User image is empty.");
		}
		if (!FileUtil.isImage(image)) {
			return new ResultEntity<>(ResultStatus.FAILED.status, "File is not a image.");
		}
		
//		File destFolder = new File(resourceConfigBean.getLocalPathForWindow());
//		if (!destFolder.exists()) {
//			destFolder.mkdir();
//		}
//		
//		String originalFilename = image.getOriginalFilename();
//		String relatedPath = resourceConfigBean.getResourcePath() + originalFilename;
//		String destPath = String.format("%s%s", resourceConfigBean.getLocalPathForWindow(), originalFilename);
//		
//		try {
//			File destFile = new File(destPath);
//			image.transferTo(destFile);
//		} catch (IllegalStateException | IOException e) {
//			e.printStackTrace();
//			return new ResultEntity<>(ResultStatus.FAILED.status, "File upload error.");
//		}
		
		return new ResultEntity<>(ResultStatus.SUCCESS.status, "File upload success.");
	}
}
