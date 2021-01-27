package com.sfac.springMvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sfac.springMvc.module.account.entity.User;
import com.sfac.springMvc.module.account.service.UserService;

/**
 * Description: Auth Filter
 * @author HymanHu
 * @date 2021-01-27 09:21:33
 */
@Component
public class AuthFilter implements Filter {
	
	private final static Logger LOGGER = LogManager.getLogger(AuthFilter.class);
	@Autowired
	private UserService userService;

	/**
	 * Authorization: Basic userName:password
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;
		LOGGER.debug("RequestUri: " + req.getRequestURI());
		
		String authHeader = req.getHeader("Authorization");
		if (StringUtils.isNotBlank(authHeader) && authHeader.startsWith("Basic ")) {
			String userNameAndPassword = authHeader.substring(authHeader.indexOf(" ") + 1);
			String userName = userNameAndPassword.split(":")[0];
			String password = userNameAndPassword.split(":")[1];
			LOGGER.debug(String.format("Request header Auth:%s - %s", userName, password));
			
			User user = userService.getUserByUserNameAndPassword(userName, password);
			if (user != null) {
				LOGGER.debug(String.format("User %s is auth success.", user.getUserName()));
				req.getSession().setAttribute("user", user);
			}
		}
		chain.doFilter(req, resp);
	}
}
