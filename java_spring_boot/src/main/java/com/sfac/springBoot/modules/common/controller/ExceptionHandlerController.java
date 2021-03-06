package com.sfac.springBoot.modules.common.controller;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.sfac.springBoot.modules.common.entity.ExceptionLog;
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

    private final static Logger LOGGER =
            LoggerFactory.getLogger(ExceptionHandlerController.class);
    @Autowired
    private ExceptionLogService exceptionLogService;

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionHandlerFor403(HttpServletRequest request,
                                                       Exception ex) {
    	
    	// 异常信息插入数据库
    	insertExceptionLog(request, ex);

    	String message = "";
    	String data = "";
    	HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    	if (ex instanceof UnauthorizedException) {
    		message = "No permit.";
    		data = "/common/403";
    		httpStatus = HttpStatus.FORBIDDEN;
    	} else  {
    		message = "Internal server error.";
    		data = "/common/500";
    		httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    	}

    	// 根据请求的方式决定返回的方式
    	if (isInterface(request)) {
    		return jsonResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, data);
    	} else {
    		return pageResult(data, httpStatus);
    	}
    }

    // 判断目标方法是否为数据接口
    private boolean isInterface(HttpServletRequest request) {
        HandlerMethod handlerMethod = (HandlerMethod) request.getAttribute(
                "org.springframework.web.servlet.HandlerMapping.bestMatchingHandler");
        Annotation[] classAnnotations = handlerMethod.getBeanType().getAnnotationsByType(RestController.class);
        Annotation[] classAnnotations2 = handlerMethod.getBeanType().getAnnotationsByType(ResponseBody.class);
        Annotation[] methodAnnotations = handlerMethod.getMethod().getAnnotationsByType(ResponseBody.class);
        return (classAnnotations.length > 0) || (classAnnotations2.length > 0) || (methodAnnotations.length > 0);
    }

    // 返回页面
    private ModelAndView pageResult(String url, HttpStatus status) {
        // 重定向到错误页面控制器
        return new ModelAndView("redirect:" + url, status);
    }

    // 返回 Json 数据
    private ModelAndView jsonResult(int status, String message, Object data) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        mv.addObject("status", status);
        mv.addObject("message", message);
        mv.addObject("data", data);
        return mv;
    }

    public void insertExceptionLog(HttpServletRequest request, Exception ex) {
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
