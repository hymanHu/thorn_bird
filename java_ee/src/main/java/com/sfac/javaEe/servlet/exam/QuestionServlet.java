package com.sfac.javaEe.servlet.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfac.javaEe.dao.exam.QuestionDao;
import com.sfac.javaEe.entity.exam.Question;

/**
 * Description: Question Servlet
 * @author HymanHu
 * @date 2020-12-19 19:42:11
 */
@WebServlet(value = "/api/question")
public class QuestionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ObjectMapper mapper = new ObjectMapper();
	private QuestionDao questionDao = new QuestionDao();

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

}
