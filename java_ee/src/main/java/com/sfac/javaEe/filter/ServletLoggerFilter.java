package com.sfac.javaEe.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Description: Servlet Logger Filter
 * @author HymanHu
 * @date 2020-10-20 09:58:10
 */
@WebFilter(filterName = "ServletLoggerFilter", urlPatterns = "/*")
public class ServletLoggerFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(String.format("Servlet Uri: %s", ((HttpServletRequest)request).getServletPath()));
		chain.doFilter(request, response);
	}

}
