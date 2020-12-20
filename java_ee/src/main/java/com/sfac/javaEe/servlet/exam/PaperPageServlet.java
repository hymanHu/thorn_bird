package com.sfac.javaEe.servlet.exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Description: Paper Page Servlet
 * @author HymanHu
 * @date 2020-10-29 19:34:09
 */
@WebServlet(value = "/exam/paper/*")
public class PaperPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] urlPatterns = req.getRequestURI().split("/");
		String paperId = urlPatterns[urlPatterns.length - 1];
		if (StringUtils.isBlank(paperId) || !paperId.matches("^[0-9]*$")) {
			throw new ServletException("Paper id is null or not number.");
		}
		
		req.setAttribute("paperId", paperId);
		resp.setContentType("text/html;charset=utf-8");
		req.getRequestDispatcher("/WEB-INF/jsp/exam/paper.jsp").forward(req, resp);
	}

}
