package com.sfac.springMvc.aspect;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Description: Method Logger Aspect
 * @author HymanHu
 * @date 2021-01-28 15:18:23
 */
@Component
@Aspect
public class MethodLoggerAspect {
	
	private final static Logger LOGGER = LogManager.getLogger(MethodLoggerAspect.class);
	private ObjectMapper mapper = new ObjectMapper();

	/**
     * -第一个*代表返回类型不限
     * -第二个*代表 module 包下所有子包
     * -第三个*代表 server 包下所有类
     * -第四个*代表所有方法
     * (..) 代表参数不限
     * Order 代表优先级，数字越小优先级越高
     * -多个表达式之间使用 ||, or 表示或 ，使用 && , and 表示与 ， ！表示非
     */
	@Pointcut("execution(public * com.sfac.springMvc.module.*.service.*.*(..)) || "
			+ "@annotation(com.sfac.springMvc.aspect.MethodInfoAnnotation)")
//	@Pointcut("@annotation(com.sfac.springMvc.aspect.MethodInfoAnnotation)")
//	@Pointcut("execution(public * com.sfac.springMvc.module.*.service.*.*(..))")
	@Order(1)
	public void methodLoggerPointCut() {}
	
	@Before(value = "methodLoggerPointCut()")
	public void beforeAspect(JoinPoint joinPoint) throws JsonProcessingException {
		LOGGER.debug("======== Before Aspect ========");
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		List<String> argsList = new ArrayList<String>();
		for (Object item : args) {
			argsList.add(mapper.writeValueAsString(item));
		}
		LOGGER.debug(String.format("Call class: %s", className));
		LOGGER.debug(String.format("Call method: %s", methodName));
		LOGGER.debug(String.format("Call method args: %s", argsList));
	}
	
	@Around(value = "methodLoggerPointCut()")
	public Object aroundAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
		long endTime = System.currentTimeMillis();
		LOGGER.debug(String.format("Elapse time: %s millisecond", (endTime - startTime)));
		return result;
	}
	
	@After(value = "methodLoggerPointCut()")
	public void afterAspect(JoinPoint joinPoint) {
		LOGGER.debug("======== After Aspect ========");
	}
	
}
