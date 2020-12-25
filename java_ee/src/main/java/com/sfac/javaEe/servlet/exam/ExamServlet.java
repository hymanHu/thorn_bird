package com.sfac.javaEe.servlet.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfac.javaEe.dao.exam.AnswerDao;
import com.sfac.javaEe.dao.exam.ExamDao;
import com.sfac.javaEe.dao.exam.QuestionDao;
import com.sfac.javaEe.entity.exam.Answer;
import com.sfac.javaEe.entity.exam.Exam;
import com.sfac.javaEe.entity.exam.Question;
import com.sfac.javaEe.entity.exam.QuestionType;

/**
 * Description: Exam Servlet
 * @author HymanHu
 * @date 2020-12-24 21:26:01
 */
@WebServlet(value = "/api/exam")
public class ExamServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ExamDao examDao = new ExamDao();
	private AnswerDao answerDao = new AnswerDao();
	private QuestionDao questionDao = new QuestionDao();
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
		
		
		try {
			// 客观题分数，确定分值
			double objectiveQuestionsScore = 0.0;
			// 主观题分数，须人工判卷，不确定分值
			double subjectiveQuestionsScore = 0.0;
			Exam exam = mapper.readValue(sb.toString(), Exam.class);
			for (Answer answer : exam.getAnswers()) {
				Question question = questionDao.getQuestionById(answer.getQuestionId());
				if (question.getType().equals(QuestionType.SINGLE_CHOICE.name) || 
						question.getType().equals(QuestionType.MULTIPLE_CHOICE.name) || 
						question.getType().equals(QuestionType.JUDGE.name)) {
					if (question != null && 
							StringUtils.isNotBlank(question.getReferenceAnswer()) && 
							answer.getUserAnswer().equals(question.getReferenceAnswer())) {
						objectiveQuestionsScore += question.getScore();
					}
				} else {
					subjectiveQuestionsScore += question.getScore();
				}
			}
			// 参考分值 = 客观题分值 ~ （客观题分值 + 主观题总分）
			exam.setReferenceScore(String.format("%s ~ %s", 
					objectiveQuestionsScore, (objectiveQuestionsScore + subjectiveQuestionsScore)));
			if (subjectiveQuestionsScore == 0) {
				exam.setScore(objectiveQuestionsScore);
			} else {
				exam.setScore(0.0);
			}
			exam.setExamDate(new Date());
			examDao.insertExam(exam);
			
			int examId = exam.getId();
			for (Answer answer : exam.getAnswers()) {
				answer.setId(examId);
				answerDao.insertAnswer(answer);
			}
			
			result.put("status", 200);
			result.put("message", "Insert success.");
			result.put("data", exam);
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
