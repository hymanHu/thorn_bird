package com.sfac.common.entity.common;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Description: Exception Log
 * @author: HymanHu
 * @date: 2021年2月20日
 */
@Entity
@Table(name = "common_exception_log")
public class ExceptionLog extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private String ip;
	private String path;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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
