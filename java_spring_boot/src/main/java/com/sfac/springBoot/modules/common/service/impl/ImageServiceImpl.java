package com.sfac.springBoot.modules.common.service.impl;

import java.io.File;
import java.io.IOException;

import com.sfac.springBoot.config.ResourceConfigBean;
import com.sfac.springBoot.modules.common.entity.ImageType;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.service.ImageService;
import com.sfac.springBoot.util.FileUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Description: Image Service Impl
 * @author HymanHu
 * @date 2021-02-03 10:25:36
 */
@Service
public class ImageServiceImpl implements ImageService {
	
	private final static Logger LOGGER = LogManager.getLogger(ImageServiceImpl.class);
	@Value("${artifactId}")
	private String artifactId;
	@Autowired
	private ResourceConfigBean resourceConfigBean;

	@Override
	public ResultEntity<String> uploadImage(MultipartFile image, String type) {
		// 检查图片是否为空
        if (image.isEmpty()) {
            return new ResultEntity<>(ResultEntity.ResultStatus.FAILED.status,
                    "Image is null.");
        }
        // 检查 file 是否是图片
        if (!FileUtil.isImage(image)) {
            return new ResultEntity<>(ResultEntity.ResultStatus.FAILED.status,
                    "The file is not image.");
        }
		
        // 获取图片枚举类型
		ImageType imageType = ImageType.getImageTypeByName(type);
		
		// 获取目标文件绝对路径
        String destFolderPath = String.format("%s%s/%s",
        		System.getProperty("os.name").toLowerCase().startsWith("win") ? 
        				resourceConfigBean.getLocalPathForWindow() : 
        				resourceConfigBean.getLocalPathForLinux(), 
				artifactId,
                imageType.name);
		File destFolder = new File(destFolderPath);
		if (!destFolder.exists()) {
			destFolder.mkdirs();
		}
		String fileName = String.format("%s.%s", 
				System.currentTimeMillis(),
				FileUtil.getFileType(image.getOriginalFilename()));
		String absolutePath = String.format("%s/%s", destFolderPath, fileName);
		
		// 获取目标文件相对路径
		String relatedPath = String.format("%s%s/%s/%s", 
				resourceConfigBean.getResourcePath(), 
				artifactId, 
				imageType.name,
				fileName);
		LOGGER.debug("absolutePath: " + absolutePath);
		LOGGER.debug("relatedPath: " + relatedPath);
		
		try {
			// 移植图片文件并修改文件大小
			image.transferTo(new File(absolutePath));
			FileUtil.changeImageSize(absolutePath, absolutePath, imageType.maxWidth, imageType.maxHeight);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return new ResultEntity<>(ResultEntity.ResultStatus.FAILED.status, "File upload error.");
		}
		
		return new ResultEntity<>(ResultEntity.ResultStatus.SUCCESS.status, "File upload success.", relatedPath);
	}
}
