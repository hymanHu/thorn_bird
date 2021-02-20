package com.sfac.springBoot.modules.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: My Basic Error Controller
 * @author: HymanHu
 * @date: 2021年2月20日
 */
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class MyBasicErrorController implements ErrorController {
	
	@Override
	public String getErrorPath() {
		return null;
	}
	
	@RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
	public String errorHtml(HttpServletRequest request, HttpServletResponse response) {
		HttpStatus status = getStatus(request);
		if (status == HttpStatus.NOT_FOUND) {
			return "forward:/common/404";
		}
		return "forward:/common/500";
	}

	@RequestMapping
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		HttpStatus status = getStatus(request);
        map.put("status", status.value());
        map.put("message", status.getReasonPhrase());
		if (status == HttpStatus.NOT_FOUND) {
			map.put("data", "/common/404");
		} else {
			map.put("data", "/common/505");
		}
		return new ResponseEntity<Map<String, Object>>(map, status);
	}
	
	protected HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		} else {
			try {
				return HttpStatus.valueOf(statusCode);
			} catch (Exception var4) {
				return HttpStatus.INTERNAL_SERVER_ERROR;
			}
		}
	}
}
