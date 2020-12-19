package com.sfac.javaEe.servlet.exam;

import java.io.BufferedReader;
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

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfac.javaEe.dao.exam.QuestionDao;
import com.sfac.javaEe.entity.common.PageInfo;
import com.sfac.javaEe.entity.common.SearchBean;
import com.sfac.javaEe.entity.exam.Question;
import com.sfac.javaEe.entity.exam.QuestionType;

@WebServlet(value = "/api/questions")
public class QuestionsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private QuestionDao questionDao = new QuestionDao();
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		String line = "";
		BufferedReader br = req.getReader();
		while (StringUtils.isNotBlank((line = br.readLine()))) {
			sb.append(line);
		}
		
		SearchBean searchBean = objectMapper.readValue(sb.toString(), SearchBean.class);
		
		searchBean.initSearchBean();
		List<Question> questions = new ArrayList<Question>();
		int count = 0;
		try {
			questions = questionDao.getQuestionsBySearchBean(searchBean);
			count = questionDao.getQuestionsCountBySearchBean(searchBean);
			questions.stream().forEach(item -> item.setType(QuestionType.getLocalName(item.getType())));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		PageInfo<Question> pageInfo = new PageInfo<Question>();
		pageInfo.setTotal(count);
		pageInfo.setList(questions);
		String result = objectMapper.writeValueAsString(pageInfo);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.append(result);
		pw.flush();
	}

}
