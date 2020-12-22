package com.sfac.javaEe.servlet.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfac.javaEe.dao.exam.PaperDao;
import com.sfac.javaEe.dao.exam.PaperQuestionDao;
import com.sfac.javaEe.dao.exam.QuestionDao;
import com.sfac.javaEe.entity.account.User;
import com.sfac.javaEe.entity.exam.Paper;
import com.sfac.javaEe.entity.exam.PaperBuilder;
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
	private PaperQuestionDao paperQuestionDao = new PaperQuestionDao();
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader br = req.getReader();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		
		PaperBuilder paperBuilder = mapper.readValue(sb.toString(), PaperBuilder.class);
		Paper paper = new Paper();
		paper.setSubject(paperBuilder.getPaperTitle());
		paper.setTotalTime(paperBuilder.getPaperTime());
		paper.setCreateDate(new Date());
		
		try {
			// 查询出满足条件的所有试题集合
			List<Question> allQuestions = questionDao.getQuestionsByPaperBuilder(paperBuilder);
			// 按照试题类型分组，拆分成小集合，装到 map 中
			Map<String, List<Question>> questionsMap = 
					allQuestions.stream().collect(Collectors.groupingBy(Question :: getType));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
		
		String result = mapper.writeValueAsString(paper);
		
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
				paperQuestionDao.deletePaperQuestionByPaperId(Integer.parseInt(paperId));
				result.put("status", 200);
				result.put("message", "Delete success.");
			} catch (Exception e) {
				result.put("status", 500);
				result.put("message", e.getMessage());
				e.printStackTrace();
			}
		}
		String resultJson = mapper.writeValueAsString(result);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.append(resultJson);
		pw.flush();
	}

}
