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
import com.sfac.springBoot.modules.common.entity.ResultEntity;
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

    @ExceptionHandler(value = UnauthorizedException.class)
    public ModelAndView exceptionHandlerFor403(HttpServletRequest request,
                                                       Exception ex) {
        insertExceptionLog(request, ex);
        if (isInterface(request)) {
            return jsonResult(ResultEntity.ResultStatus.FAILED.status,
                    "Unauthorized error", "/common/403");
        } else {
            return pageResult("/common/403", HttpStatus.FORBIDDEN);
        }
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,
                                                 Exception ex) {
        insertExceptionLog(request, ex);
        if (isInterface(request)) {
            return jsonResult(ResultEntity.ResultStatus.FAILED.status,
            		ex.getMessage(), "/common/500");
        } else {
            return pageResult("/common/500", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 判断目标方法是否为数据接口
    private boolean isInterface(HttpServletRequest request) {
        HandlerMethod handlerMethod = (HandlerMethod) request.getAttribute(
                "org.springframework.web.servlet.HandlerMapping.bestMatchingHandler");
        Annotation[] classAnnotations = handlerMethod.getBeanType().getAnnotationsByType(RestController.class);
        Annotation[] methodAnnotations = handlerMethod.getMethod().getAnnotationsByType(ResponseBody.class);
        return (classAnnotations.length > 0) || (methodAnnotations.length > 0);
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
