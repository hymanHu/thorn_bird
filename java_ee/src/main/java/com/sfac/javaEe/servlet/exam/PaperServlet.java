package com.sfac.javaEe.servlet.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
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
			 * -编程题 30 分，随机在对应集合中选择 2 道，对应集合不足 2 道则全部添加
			 * -简答题 10 分，随机在对应集合中选择 2 道，对应集合不足 2 道则全部添加
			 * -多选题 20 分，随机在对应集合中选择 4 道，对应集合不足 4 道则全部添加
			 * -填空题 10 分，随机在对应集合中选择 4 道，对应集合不足 4 道则全部添加
			 * -判断题 10 分，随机在对应集合中选择 4 道，对应集合不足 4 道则全部添加
			 * -单选题 20 分，随机在对应集合中选择 8 道，对应集合不足 8 道则全部添加
			 * ------------------
			 * -当所选类型不足时，随机从所有试题集中选择试题，补足 100 分
			 */
			List<Question> questions = new ArrayList<Question>();
			
			// 随机填充各类型试题，每种类型设定有基础数量，题库不足时添加题库对应类型数量
			questionsMap.entrySet().forEach(item -> {
				List<Question> tempList = item.getValue();
				QuestionType questionType = QuestionType.getQuestionType(item.getKey());
				int loopCount = tempList.size() >= questionType.baseNumber ? questionType.baseNumber : tempList.size();
				randomAddQuestions(tempList, questions, loopCount);
			});
			
			// 总分不足 100 时，从总试题集中随机添加，补足 100 分
			randomAddQuestions(allQuestions, questions, 0);
			
			// 设置试题集和分数
			paper.setQuestions(questions.stream()
					.sorted(Comparator.comparing(Question :: getType))
					.collect(Collectors.toList()));
			paper.setTotalScore(questions.stream()
					.map(question -> question.getScore())
					.reduce((i, j) -> i + j).orElse(0.0));
			
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
	
	/**
	 * -从源头集合随机添加试题到目标集合
	 * @param fromList		源头集合
	 * @param toList		目标集合
	 * @param loopCount		添加试题数量，0 表示不知添加次数，需要用总分判断
	 */
	public void randomAddQuestions(List<Question> fromList, List<Question> toList, int loopCount) {
		// 已知循环次数
		if (loopCount > 0) {
			double totalScore = toList.stream()
					.map(question -> question.getScore())
					.reduce((i, j) -> i + j).orElse(0.0);
			for (int i = 0; i < loopCount; i ++) {
				Random random = new Random();
				Question question = fromList.get(random.nextInt(fromList.size()));
				// 当 toList 已经包含该试题 || 分数超过 100 时候不添加
				if (toList.contains(question) || ((totalScore + question.getScore()) > Paper.DEFAULT_TOTAL_SCORE)) {
					i --;
				} else {
					toList.add(question);
					totalScore += question.getScore();
				}
			}
			System.out.println(String.format("====填充基础数量，%s类型，总分%s====", fromList.get(0).getType(), totalScore));
		} else { // 未知循环次数
			double totalScore = toList.stream()
					.map(question -> question.getScore())
					.reduce((i, j) -> i + j)
					.orElse(0.0);
			double allQuestionsScore = fromList.stream()
					.map(question -> question.getScore())
					.reduce((i, j) -> i + j)
					.orElse(0.0);
			System.out.println(String.format("====开始补分，总分%s，题库分数%s====", totalScore, allQuestionsScore));
			while (totalScore < Paper.DEFAULT_TOTAL_SCORE && 
					totalScore < allQuestionsScore) {
				Random random = new Random();
				Question questionRandom = fromList.get(random.nextInt(fromList.size()));
				if (!toList.contains(questionRandom) && 
						(totalScore + questionRandom.getScore()) <= Paper.DEFAULT_TOTAL_SCORE) {
					toList.add(questionRandom);
					totalScore += questionRandom.getScore();
					System.out.println(String.format("====添加%s,总分%s====", questionRandom.getScore(), totalScore));
				}
			}
			System.out.println(String.format("====总分%s====", totalScore));
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
