package com.sfac.javaEe.servlet.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfac.javaEe.dao.exam.PaperDao;
import com.sfac.javaEe.dao.exam.QuestionDao;
import com.sfac.javaEe.entity.exam.Paper;
import com.sfac.javaEe.entity.exam.Question;

/**
 * Description: Paper Servlet
 * @author HymanHu
 * @date 2020-10-29 16:26:51
 */
@WebServlet(value = "/api/paper")
public class PaperServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PaperDao paperDao = new PaperDao();
	private QuestionDao questionDao = new QuestionDao();
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int paperId = Integer.parseInt(req.getParameter("paperId"));
		Paper paper = new Paper();
		try {
			paper = paperDao.getPaperById(paperId);
			List<Question> questions = questionDao.getQuestionsByPaperId(paperId);
			paper.setQuestions(questions);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String result = objectMapper.writeValueAsString(paper);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.append(result);
		pw.flush();
	}

}
