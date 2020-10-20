package com.sfac.javaEe.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Description: Login Filter
 * @author HymanHu
 * @date 2020-10-20 10:26:14
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "/user/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String userName = (String) req.getSession().getAttribute("userName");
		if (StringUtils.isBlank(userName)) {
			resp.sendRedirect("/login");
		}
		
		chain.doFilter(request, response);
	}

}
