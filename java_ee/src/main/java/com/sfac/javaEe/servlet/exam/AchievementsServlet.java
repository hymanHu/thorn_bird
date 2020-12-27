package com.sfac.javaEe.servlet.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfac.javaEe.dao.exam.AchievementDao;
import com.sfac.javaEe.entity.common.PageInfo;
import com.sfac.javaEe.entity.common.SearchBean;
import com.sfac.javaEe.entity.exam.Achievement;

/**
 * @Description: Achievements Servlet
 * @author: HymanHu
 * @date: 2020年12月27日
 */
@WebServlet(value = "/api/achievements")
public class AchievementsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AchievementDao achievementDao = new AchievementDao();
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		String line = "";
		BufferedReader br = req.getReader();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		SearchBean searchBean = mapper.readValue(sb.toString(), SearchBean.class);
		
		List<Achievement> achievements = new ArrayList<Achievement>();
		int count = 0;
		try {
			achievements = achievementDao.getAchievementsBySearchBean(searchBean);
			count = achievementDao.getAchievementsCountBySearchBean(searchBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageInfo<Achievement> page = new PageInfo<Achievement>();
		page.setList(achievements);
		page.setTotal(count);
		String pageJson = mapper.writeValueAsString(page);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.append(pageJson);
		pw.flush();
	}

}
