package com.sfac.javaEe.servlet.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
 * /api/questions?paperId=1
 * @author HymanHu
 * @date 2020-10-29 15:53:14
 */
@WebServlet(value = "/api/questions")
public class QuestionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private QuestionDao questionDao = new QuestionDao();
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int paperId = Integer.parseInt(req.getParameter("paperId"));
		List<Question> questions = new ArrayList<Question>();
		try {
			questions = questionDao.getQuestionsByPaperId(paperId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String result = objectMapper.writeValueAsString(questions);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.append(result);
		pw.flush();
	}

}
