package com.sfac.springBoot.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Description My Aspect
 * @Author HymanHu
 * @Date 2021/3/4 10:40
 */
@Aspect
@Component
public class MyAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(MyAspect.class);

    /**
     * -关联在方法上的切点，大面积额切入
     * -第一个 * 代表返回类型不限
     * -第二个 * 代表 module 下所有子包
     * -第三个 * 代表所有类
     * -第四个 * 代表所有方法
     * (..) 代表参数不限
     * Order 代表优先级，数字越小优先级越高
     */
    @Pointcut("execution(public * com.sfac.springBoot.modules.*.controller.*.*(..))")
    @Order(1)
    public void controllerPointCut(){}

    // 采用注解切点，精确切入
    @Pointcut("@annotation(com.sfac.springBoot.aspect.MyAnnotation)")
    @Order(1)
    public void annotationPointCut(){}

    @Before(value = "controllerPointCut()")
    public void beforeController(JoinPoint joinPoint) {
        LOGGER.debug("==== Before controller aspect ====");

        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        LOGGER.debug(String.format("请求来源： %s", request.getRemoteAddr()));
        LOGGER.debug(String.format("请求URL： %s", request.getRequestURL()));
        LOGGER.debug(String.format("请求方式： %s", request.getMethod()));
        LOGGER.debug(String.format("请求类： %s",
                joinPoint.getTarget().getClass().getName()));
        LOGGER.debug(String.format("请求方法： %s",
                joinPoint.getSignature().getName()));
        LOGGER.debug(String.format("请求参数： %s",
                joinPoint.getArgs() == null ? "" : joinPoint.getArgs()));
    }

    @Around(value="controllerPointCut()")
    public Object aroundController(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        LOGGER.debug("==== Around controller aspect ====");
        return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
    }

    @After(value="controllerPointCut()")
    public void afterController() {
        LOGGER.debug("==== After controller aspect ====");
    }

    @Around(value = "annotationPointCut()")
    public Object arountAnnotationMethod(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        long end  = System.currentTimeMillis();
        LOGGER.debug(String.format("方法执行时间： %s", (end -  start)));
        return result;
    }
}
