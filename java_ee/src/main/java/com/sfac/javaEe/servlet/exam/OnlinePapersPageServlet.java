package com.sfac.javaEe.servlet.exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: Papers Page Servlet
 * @author HymanHu
 * @date 2020-11-01 15:43:42
 */
@WebServlet(value = "/papers")
public class OnlinePapersPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.getRequestDispatcher("/WEB-INF/jsp/exam/onlinePapers.jsp").forward(req, resp);
	}
}
