package com.sfac.springMvc.module.common.service;

import com.sfac.springMvc.module.common.entity.ExceptionLog;
import com.sfac.springMvc.module.common.entity.ResultEntity;

/**
 * Description: Exception Log Service 
 * @author HymanHu
 * @date 2021-01-29 14:13:02
 */
public interface ExceptionLogService {

	ResultEntity<ExceptionLog> insertExceptionLog(ExceptionLog exceptionLog);
}
