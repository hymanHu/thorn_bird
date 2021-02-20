package com.sfac.springBoot.modules.common.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sfac.springBoot.modules.common.dao.ExceptionLogDao;
import com.sfac.springBoot.modules.common.entity.ExceptionLog;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.service.ExceptionLogService;

/**
 * @Description: Exception Log Service Impl
 * @author: HymanHu
 * @date: 2021年2月20日
 */
@Service
public class ExceptionLogServiceImpl implements ExceptionLogService {
	@Autowired
	private ExceptionLogDao exceptionLogDao;

	@Override
	public ResultEntity<ExceptionLog> insertExceptionLog(ExceptionLog exceptionLog) {
		List<ExceptionLog> exceptionLogs = Optional
				.ofNullable(exceptionLogDao.getExceptionLogsByParameters(exceptionLog))
				.orElse(Collections.emptyList());
		if (exceptionLogs.isEmpty()) {
			exceptionLogDao.insertExceptionLog(exceptionLog);
		}
		return new ResultEntity<ExceptionLog>(ResultEntity.ResultStatus.SUCCESS.status, 
				"Insert success.", exceptionLog);
	}
}
