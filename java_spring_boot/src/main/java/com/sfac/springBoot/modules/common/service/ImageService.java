package com.sfac.springBoot.modules.common.service;

import com.sfac.springBoot.modules.common.entity.ResultEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * Description: Image Service
 * @author HymanHu
 * @date 2021-02-03 10:25:57
 */
public interface ImageService {

	ResultEntity<String> uploadImage(MultipartFile image, String type);
}
