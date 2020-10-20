package com.sfac.javaEe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: User Profile Servlet
 * @author HymanHu
 * @date 2020-10-20 10:06:17
 */
@WebServlet(value = "/user/profile")
public class UserProfileServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset:utf-8;");
		PrintWriter printWriter = resp.getWriter();
		printWriter.append("<h1>This is user profile page.</h1>");
		printWriter.append("User name is:" + req.getSession().getAttribute("userName"));
		printWriter.flush();
	}

}
