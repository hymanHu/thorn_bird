package com.sfac.springMvc.module.common.service;

import org.springframework.web.multipart.MultipartFile;

import com.sfac.springMvc.module.common.entity.ResultEntity;

/**
 * Description: Image Service
 * @author HymanHu
 * @date 2021-02-03 10:25:57
 */
public interface ImageService {

	ResultEntity<String> uploadImage(MultipartFile image, String imageType);
}
