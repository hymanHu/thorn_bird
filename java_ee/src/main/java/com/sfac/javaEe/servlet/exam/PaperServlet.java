package com.sfac.javaEe.servlet.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfac.javaEe.dao.exam.PaperDao;
import com.sfac.javaEe.dao.exam.QuestionDao;
import com.sfac.javaEe.entity.account.User;
import com.sfac.javaEe.entity.exam.Paper;
import com.sfac.javaEe.entity.exam.Question;

/**
 * Description: Paper Servlet
 * @author HymanHu
 * @date 2020-10-29 16:26:51
 */
@WebServlet(value = "/api/paper/*")
public class PaperServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PaperDao paperDao = new PaperDao();
	private QuestionDao questionDao = new QuestionDao();
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] urlPatterns = req.getRequestURI().split("/");
		String paperId = urlPatterns[urlPatterns.length - 1];
		if (StringUtils.isBlank(paperId) || !paperId.matches("^[0-9]*$")) {
			throw new ServletException("Paper id is null or not number.");
		}
		
		Paper paper = new Paper();
		try {
			paper = paperDao.getPaperById(Integer.parseInt(paperId));
			List<Question> questions = questionDao.getQuestionsByPaperId(Integer.parseInt(paperId));
			paper.setQuestions(questions);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String result = objectMapper.writeValueAsString(paper);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.append(result);
		pw.flush();
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] urlPatterns = req.getRequestURI().split("/");
		String paperId = urlPatterns[urlPatterns.length - 1];
		if (StringUtils.isBlank(paperId) || !paperId.matches("^[0-9]*$")) {
			throw new ServletException("Paper id is null or not number.");
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			result.put("status", 500);
			result.put("message", "未登录用户无删除权限。");
		} else {
			try {
				paperDao.deletePaperById(Integer.parseInt(paperId));
				paperDao.deletePaperQuestionByPaperId(Integer.parseInt(paperId));
				result.put("status", 200);
				result.put("message", "Delete success.");
			} catch (Exception e) {
				result.put("status", 500);
				result.put("message", e.getMessage());
				e.printStackTrace();
			}
		}
		String resultJson = objectMapper.writeValueAsString(result);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.append(resultJson);
		pw.flush();
	}

}
