package com.sfac.javaEe.servlet.account;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Description: Logout Servlet
 * @author HymanHu
 * @date 2020-10-19 15:03:26
 */
@WebServlet(value = "/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		req.getSession().removeAttribute("user");
		String redirectUrl = StringUtils.isBlank(name) ? "/login" : "/login?name=" + URLEncoder.encode(name, "utf-8");
		
		resp.sendRedirect(redirectUrl);
	}

}
