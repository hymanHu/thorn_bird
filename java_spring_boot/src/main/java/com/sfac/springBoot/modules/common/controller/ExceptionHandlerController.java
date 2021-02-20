package com.sfac.springBoot.modules.common.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import com.sfac.springBoot.modules.common.entity.ExceptionLog;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.ResultEntity.ResultStatus;
import com.sfac.springBoot.modules.common.service.ExceptionLogService;
import com.sfac.springBoot.util.IPUtil;
import com.sfac.springBoot.util.StringUtil;


/**
 * @Description: Exception Handler Controller
 * @author: HymanHu
 * @date: 2021年2月20日
 */
@ControllerAdvice
public class ExceptionHandlerController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);
	@Autowired
	private ExceptionLogService exceptionLogService;
	
	/**
	 * - 假定 ArithmeticException 属于 403 异常
	 */
	@ExceptionHandler(value = ArithmeticException.class)
	@ResponseBody
	public ResultEntity<String> exceptionHandlerFor403(
			HttpServletRequest request,
			HttpServletResponse response, 
			Exception ex) {
		insertException(request, ex);
		return new ResultEntity<String>(ResultStatus.FAILED.status, "You have no permission.", "/common/403");
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultEntity<String> exceptionHandlerFor500(
			HttpServletRequest request,
			HttpServletResponse response, 
			Exception ex) {
		insertException(request, ex);
		return new ResultEntity<String>(ResultStatus.FAILED.status, "Internal Server Error.", "/common/500");
	}
	
	// 插入异常信息
	public void insertException(HttpServletRequest request, Exception ex) {
		ex.printStackTrace();
		LOGGER.debug("======== Log exception into db ========");
		
		ExceptionLog exceptionLog = new ExceptionLog();
		exceptionLog.setIp(IPUtil.getIpAddr(request));
		exceptionLog.setPath(request.getServletPath());
		HandlerMethod handlerMethod = (HandlerMethod) request.getAttribute(
				"org.springframework.web.servlet.HandlerMapping.bestMatchingHandler");
		if (handlerMethod != null) {
			exceptionLog.setClassName(handlerMethod.getBeanType().getName());
			exceptionLog.setMethodName(handlerMethod.getMethod().getName());
		}
		exceptionLog.setExceptionType(ex.getClass().getSimpleName());
		exceptionLog.setExceptionMessage(StringUtils.isBlank(ex.getMessage()) ? "" : 
			StringUtil.splitString(ex.getMessage().trim(), 200));
		exceptionLog.setCreateDate(LocalDateTime.now());
		
		exceptionLogService.insertExceptionLog(exceptionLog);
	}
}
