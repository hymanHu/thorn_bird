package com.sfac.javaEe.servlet.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfac.javaEe.dao.exam.QuestionDao;
import com.sfac.javaEe.entity.exam.Question;

/**
 * Description: Question Servlet
 * @author HymanHu
 * @date 2020-12-19 19:42:11
 */
@WebServlet(value = "/api/question/*")
public class QuestionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ObjectMapper mapper = new ObjectMapper();
	private QuestionDao questionDao = new QuestionDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] urlPatterns = req.getRequestURI().split("/");
		String questionId = urlPatterns[urlPatterns.length - 1];
		if (StringUtils.isBlank(questionId) || !questionId.matches("^[0-9]*$")) {
			throw new ServletException("Question id is null or not number.");
		}
		
		Question question = null;
		try {
			question = questionDao.getQuestionById(Integer.parseInt(questionId));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String resultJson = question == null ? "" : mapper.writeValueAsString(question);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.append(resultJson);
		pw.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader br = req.getReader();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		
		Question question = mapper.readValue(sb.toString(), Question.class);
		
		try {
			questionDao.insertQuestion(question);
			result.put("status", 200);
			result.put("message", "Insert question success.");
			result.put("data", question);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", 500);
			result.put("message", e.getMessage());
		}
		
		String resultJson = mapper.writeValueAsString(result);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.append(resultJson);
		pw.flush();
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader br = req.getReader();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		Question question = mapper.readValue(sb.toString(), Question.class);
		
		try {
			questionDao.updateQuestion(question);
			result.put("status", 200);
			result.put("message", "Update question success.");
			result.put("data", question);
		} catch (Exception e) {
			result.put("status", 500);
			result.put("message", e.getMessage());
		}
		
		String resultJson = mapper.writeValueAsString(result);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.append(resultJson);
		pw.flush();
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] urlPatterns = req.getRequestURI().split("/");
		String questionId = urlPatterns[urlPatterns.length - 1];
		if (StringUtils.isBlank(questionId) || !questionId.matches("^[0-9]*$")) {
			throw new ServletException("Question id is null or not a number");
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			questionDao.deleteQuestionById(Integer.parseInt(questionId));
			result.put("status", 200);
			result.put("message", "Delete question success.");
		} catch (Exception e) {
			result.put("status", 500);
			result.put("message", e.getMessage());
			e.printStackTrace();
		}
		
		String resultJson = mapper.writeValueAsString(result);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.append(resultJson);
		pw.flush();
	}
}
