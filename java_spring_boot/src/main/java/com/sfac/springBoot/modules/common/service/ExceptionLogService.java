package com.sfac.springBoot.modules.common.service;

import com.sfac.springBoot.modules.common.entity.ExceptionLog;
import com.sfac.springBoot.modules.common.entity.ResultEntity;

/**
 * @Description: Exception Log Service
 * @author: HymanHu
 * @date: 2021年2月20日
 */
public interface ExceptionLogService {

	ResultEntity<ExceptionLog> insertExceptionLog(ExceptionLog exceptionLog);
}
