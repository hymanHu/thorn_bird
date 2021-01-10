package com.sfac.javaEe.servlet.exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * 127.0.0.1/exam/achievement/21
 * @Description: Achievement Page Servlet
 * @author: HymanHu
 * @date: 2021年1月9日
 */
@WebServlet(value = "/exam/achievement/*")
public class AchievementPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String[] urlPatterns = req.getRequestURI().split("/");
		String achievementId = urlPatterns[urlPatterns.length - 1];
		if (StringUtils.isBlank(achievementId) || !achievementId.matches("^[0-9]*$")) {
			throw new ServletException("Achievement id is null or not number.");
		}
		
		req.setAttribute("achievementId", achievementId);
		resp.setContentType("text/html;charset=utf-8");
		req.getRequestDispatcher("/WEB-INF/jsp/exam/achievement.jsp").forward(req, resp);
	}

}
