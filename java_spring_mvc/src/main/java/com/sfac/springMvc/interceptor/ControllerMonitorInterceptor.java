package com.sfac.springMvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sfac.springMvc.filter.AuthFilter;

/**
 * Description: Controller Monitor Interceptor
 * @author HymanHu
 * @date 2021-01-28 10:24:39
 */
@Component
public class ControllerMonitorInterceptor extends HandlerInterceptorAdapter {
	
	private final static Logger LOGGER = LogManager.getLogger(AuthFilter.class);
	private static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.debug("======== Pre Interceptor ========");
		long startTime = System.currentTimeMillis();
		threadLocal.set(startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		LOGGER.debug(String.format("Request uri: %s", request.getRequestURI()));
		LOGGER.debug(String.format("Request method: %s", request.getMethod()));
		LOGGER.debug(String.format("Request remote address: %s", request.getRemoteAddr()));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long endTime = System.currentTimeMillis();
		long startTime = threadLocal.get();
		LOGGER.debug(String.format("Elapse time: %s millisecond", (endTime - startTime)));
		LOGGER.debug("======== After Interceptor ========");
	}
}
