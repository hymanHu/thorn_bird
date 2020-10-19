package com.sfac.javaEe.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: Morning Servlet
 * @author HymanHu
 * @date 2020-10-19 16:57:22
 */
@WebServlet(value = "/morning")
public class MorningServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/helloWorld").forward(req, resp);
	}

}