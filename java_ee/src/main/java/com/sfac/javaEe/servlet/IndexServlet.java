package com.sfac.javaEe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: Index Servlet
 * @author HymanHu
 * @date 2020-10-19 12:53:40
 */
@WebServlet(value = "/")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset:utf-8;");
		PrintWriter printWriter = resp.getWriter();
		printWriter.append("<h1>Index page</h1>");
		printWriter.append("This is index page.");
		printWriter.flush();
	}
}
