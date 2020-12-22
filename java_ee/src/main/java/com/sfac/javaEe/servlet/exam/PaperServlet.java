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
import java.util.Random;
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
import com.sfac.javaEe.entity.exam.QuestionType;

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

	/**
	 * 127.0.0.1/api/paper ---- post
	 * {"paperTitle":"Java_SE_hujiang", "paperFlage":"Java_Framework", "paperTime":"60", 
	 * "paperTypes":["singleChoice", "multipleChoice", "judge", "fillBlank", "shortAnswer", "programming"]}
	 */
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
			
			/*
			 * -遍历 map，按照如下规则为试卷添加试题
			 * -编程题 30 分，随机在对应集合中选择 2 道，不足则全部添加
			 * -简答题 10 分，随机在对应集合中选择 2 道，不足则全部添加
			 * -多选题 10 分，随机在对应集合中选择 2 道，不足则全部添加
			 * -填空题 10 分，随机在对应集合中选择 4 道，不足则全部添加
			 * -判断题 10 分，随机在对应集合中选择 4 道，不足则全部添加
			 * -剩余分数全安排给单选题，随机从对应集合中选择 x 道，不足则全部添加
			 */
			// 填充非单选题
			List<Question> questions = new ArrayList<Question>();
			questionsMap.entrySet().forEach(item -> {
				int max = 0;
				List<Question> tempList = item.getValue();
				if (item.getKey().equals(QuestionType.PROGRAMMING.name) || 
						item.getKey().equals(QuestionType.SHORT_ANSWER.name) || 
						item.getKey().equals(QuestionType.MULTIPLE_CHOICE.name)) {
					max = tempList.size() >= 2 ? 2 : tempList.size();
					randomAddQuestions(tempList, questions, max);
				} else if (item.getKey().equals(QuestionType.FILL_BLANK.name) || 
						item.getKey().equals(QuestionType.JUDGE.name)) {
					max = tempList.size() >= 4 ? 4 : tempList.size();
					randomAddQuestions(tempList, questions, max);
				}
			});
			// 计算单选题数量
			int singleChoiceCount = 
					(int)((100 - questions.stream().map(item -> item.getScore()).reduce((i, j) -> i + j).get()) / 
					QuestionType.SINGLE_CHOICE.score);
			// 填充单选题
			questionsMap.entrySet().forEach(item -> {
				int max = 0;
				List<Question> tempList = item.getValue();
				if (item.getKey().equals(QuestionType.SINGLE_CHOICE.name)) {
					max = tempList.size() >= singleChoiceCount ? singleChoiceCount : tempList.size();
					randomAddQuestions(tempList, questions, max);
				}
			});
			
			// 设置试卷试题集和分数
			paper.setQuestions(questions);
			paper.setTotalScore(questions.stream().map(item -> item.getScore()).reduce((i, j) -> i + j).get());
			
			// 插入试卷
			paperDao.insertPager(paper);
			
			// 插入试题集
			for (Question question : questions) {
				paperQuestionDao.insertPaperQestion(paper.getId(), question.getId());
			}
			
			result.put("status", 200);
			result.put("message", "Insert paper success.");
			result.put("data", paper);
		} catch (Exception e) {
			result.put("status", 500);
			result.put("message", e.getMessage());
			e.printStackTrace();
		}
		
		String resultJson = mapper.writeValueAsString(result);
		System.out.println(resultJson);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.append(resultJson);
		pw.flush();
	}
	
	// 随机添加试题集
	public void randomAddQuestions(List<Question> fromList, List<Question> toList, int max) {
		for (int i = 0; i < max; i ++) {
			Random random = new Random();
			Question question = fromList.get(random.nextInt(fromList.size()));
			if (toList.contains(question)) {
				i --;
			} else {
				toList.add(question);
			}
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
