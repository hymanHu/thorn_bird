package com.sfac.springMvc.module.common.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Description: Exception Log
 * @author HymanHu
 * @date 2021-01-29 13:54:31
 */
@Entity
@Table(name = "common_exception_log")
public class ExceptionLog extends AbstractEntity {
	private String ip;
	private String className;
	private String methodName;
	private String exceptionType;
	private String exceptionMessage;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}
