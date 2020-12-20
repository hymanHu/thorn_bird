package com.sfac.javaEe.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfac.javaEe.entity.account.User;

/**
 * Description: Authentication Filter
 * @author HymanHu
 * @date 2020-12-19 10:05:33
 */
@SuppressWarnings("serial")
@WebFilter(filterName = "authenticationFilter", urlPatterns = "/*")
public class AuthenticationFilter implements Filter {
	
	private static List<String> ANON_URL = new ArrayList<String>() {{
		add("/favicon.ico");
		add("/login");
		add("/register");
		add("/static");
		add("/api/dict");
		add("/exam/paper");
		add("/api/paper");
		add("/exam/papers");
		add("/api/papers");
	}};
	
	/**
	 * -判断请求路径是否在 ANON_URL 内
	 */
	public static boolean checkServletPath(String servletPath) {
		String url = ANON_URL.stream()
				.filter(item -> item.equals(servletPath) || servletPath.startsWith(item))
				.findFirst()
				.orElse(null);
		return url == null;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("==== Init Authentication Filter ====");
		Filter.super.init(filterConfig);
	}

	@Override
	public void destroy() {
		System.out.println("==== Destroy Authentication Filter ====");
		Filter.super.destroy();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String servletPath = request.getServletPath();
		String requestUri = request.getRequestURI();
		if (!servletPath.contains("dict.do")) {
			System.out.println(String.format("Servlet Path: %s; Request URI: %s", servletPath, requestUri));
		}
		
		User user = (User) request.getSession().getAttribute("user");
		if (checkServletPath(servletPath) && user == null) {
			response.sendRedirect("/login");
		} else {
			chain.doFilter(request, response);
		}
	}

}
