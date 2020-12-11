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

import com.sfac.javaEe.entity.account.User;

/**
 * Description: Login Filter
 * @author HymanHu
 * @date 2020-10-20 10:26:14
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "/account/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			resp.sendRedirect("/login");
			//重定向后，需要返回语句，不然会继续执行，进入目标 Servlet
			return;
		}
		
		chain.doFilter(req, resp);
	}

}
