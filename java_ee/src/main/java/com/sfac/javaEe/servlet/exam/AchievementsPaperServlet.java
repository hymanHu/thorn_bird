package com.sfac.javaEe.servlet.exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: Achievements Paper Servlet
 * @author: HymanHu
 * @date: 2020年12月27日
 */
@WebServlet(value = "/exam/achievements")
public class AchievementsPaperServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/exam/achievements.jsp").forward(req, resp);
	}

}
