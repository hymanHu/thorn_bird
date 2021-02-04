package com.sfac.springMvc.interceptor;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.sfac.springMvc.module.common.entity.ExceptionLog;
import com.sfac.springMvc.module.common.entity.ResultEntity;
import com.sfac.springMvc.module.common.service.ExceptionLogService;
import com.sfac.springMvc.util.IPUtil;
import com.sfac.springMvc.util.StringUtil;

/**
 * Description: Spring Mvc Handler Exception Resolver
 * @author HymanHu
 * @date 2021-01-29 14:21:03
 */
@Component
public class SpringMvcHandlerExceptionResolver implements HandlerExceptionResolver {
	
	private final static Logger LOGGER = LogManager.getLogger(SpringMvcHandlerExceptionResolver.class);
	@Autowired
	private ExceptionLogService exceptionLogService;

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex) {
		ex.printStackTrace();
		if (handler instanceof HandlerMethod) {
			LOGGER.debug("======== Log exception into db ========");
			String ip = IPUtil.getIpAddr(request);
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			String className = handlerMethod.getBeanType().getName();
			String methodName = handlerMethod.getMethod().getName();
			String exceptionType = ex.getClass().getSimpleName();
			String exceptionMessage = StringUtils.isBlank(ex.getMessage()) ? "" : 
				StringUtil.splitString(ex.getMessage().trim(), 200);
			
			ExceptionLog exceptionLog = new ExceptionLog();
			exceptionLog.setIp(ip);
			exceptionLog.setClassName(className);
			exceptionLog.setMethodName(methodName);
			exceptionLog.setExceptionType(exceptionType);
			exceptionLog.setExceptionMessage(exceptionMessage);
			exceptionLog.setCreateDate(LocalDateTime.now());
			
			exceptionLogService.insertExceptionLog(exceptionLog);
			
			if (isInterface(handlerMethod)) {
				return jsonResult(ResultEntity.ResultStatus.FAILED.status, exceptionMessage);
			} else {
				return pageResult("common/500");
			}
		}
		return null;
	}
	
	// 判断目标方法是否为接口
	private boolean isInterface(HandlerMethod handlerMethod) {
		Annotation[] classAnnotations = handlerMethod.getBeanType().getAnnotationsByType(RestController.class);
		Annotation[] methodAnnotations = handlerMethod.getMethod().getAnnotationsByType(ResponseBody.class);
		return (classAnnotations.length > 0) || (methodAnnotations.length > 0);
	}
	
	// 判断是否是 Ajax 请求
	@SuppressWarnings("unused")
	private boolean isAjax(HttpServletRequest request) {
		return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
	}
	
	// 返回页面
	private ModelAndView pageResult(String url) {
		// 直接返回页面
		//return new ModelAndView(url, HttpStatus.INTERNAL_SERVER_ERROR);
		// 重定向到错误页面控制器
		return new ModelAndView("redirect:/common/500", HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	// 返回 Json 数据
	private ModelAndView jsonResult(int status, String message) {
		ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
		mv.addObject("status", status);
		mv.addObject("message", message);
		return mv;
	}
}
