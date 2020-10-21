package com.sfac.javaEe.servlet.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: Error Servlet
 * @author HymanHu
 * @date 2020-10-19 16:15:02
 */
@WebServlet(value = "/error")
public class ErrorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset:utf-8;");
		resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "您的人品问题，无法访问！");
	}

}
