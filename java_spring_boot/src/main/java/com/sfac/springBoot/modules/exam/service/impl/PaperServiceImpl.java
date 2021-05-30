package com.sfac.springBoot.modules.exam.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.exam.dao.PaperDao;
import com.sfac.springBoot.modules.exam.dao.PaperQuestionDao;
import com.sfac.springBoot.modules.exam.dao.QuestionDao;
import com.sfac.springBoot.modules.exam.entity.Paper;
import com.sfac.springBoot.modules.exam.entity.PaperBuilder;
import com.sfac.springBoot.modules.exam.entity.Question;
import com.sfac.springBoot.modules.exam.entity.QuestionType;
import com.sfac.springBoot.modules.exam.service.PaperService;

/**
 * Description: Paper Service Impl
 * @author HymanHu
 * @date 2021-05-26 09:46:30
 */
@Service
public class PaperServiceImpl implements PaperService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(PaperServiceImpl.class);
	
	@Autowired
	private PaperDao paperDao;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private PaperQuestionDao paperQuestionDao;

	@Override
	@Transactional
	public ResultEntity<Paper> insertPaper(PaperBuilder paperBuilder) {
		paperBuilder.initPaperTypesString();
		Paper paper = new Paper();
		paper.setSubject(paperBuilder.getPaperTitle());
		paper.setTotalTime(paperBuilder.getPaperTime());
		paper.setCreateDate(LocalDateTime.now());
		
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
		paperDao.insertPaper(paper);
		
		// 插入试题集
		questions.stream().forEach(item -> {
			paperQuestionDao.insertPaperQuestion(paper.getId(), item.getId());
		});
		
		return new ResultEntity<Paper>(ResultEntity.ResultStatus.SUCCESS.status, "Insert success.", paper);
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
			LOGGER.debug(String.format("====填充基础数量，%s类型，总分%s====", fromList.get(0).getType(), totalScore));
		} else { // 未知循环次数
			double totalScore = toList.stream()
					.map(question -> question.getScore())
					.reduce((i, j) -> i + j)
					.orElse(0.0);
			double allQuestionsScore = fromList.stream()
					.map(question -> question.getScore())
					.reduce((i, j) -> i + j)
					.orElse(0.0);
			LOGGER.debug(String.format("====开始补分，总分%s，题库分数%s====", totalScore, allQuestionsScore));
			while (totalScore < Paper.DEFAULT_TOTAL_SCORE && 
					totalScore < allQuestionsScore) {
				Random random = new Random();
				Question questionRandom = fromList.get(random.nextInt(fromList.size()));
				if (!toList.contains(questionRandom) && 
						(totalScore + questionRandom.getScore()) <= Paper.DEFAULT_TOTAL_SCORE) {
					toList.add(questionRandom);
					totalScore += questionRandom.getScore();
					LOGGER.debug(String.format("====添加%s,总分%s====", questionRandom.getScore(), totalScore));
				}
			}
			LOGGER.debug(String.format("====总分%s====", totalScore));
		}
	}

	@Override
	@Transactional
	public ResultEntity<Paper> updatePaper(Paper paper) {
		paperDao.updatePaper(paper);
		return new ResultEntity<Paper>(ResultEntity.ResultStatus.SUCCESS.status, "Update success.", paper);
	}

	@Override
	@Transactional
	public ResultEntity<Object> deletePaperById(int id) {
		paperDao.deletePaperById(id);
		paperQuestionDao.deletePaperQuestionsByPaperId(id);
		return new ResultEntity<Object>(ResultEntity.ResultStatus.SUCCESS.status, "Delete success.");
	}

	@Override
	public ResultEntity<Object> deletePapers() {
		paperDao.deletePapers();
		paperQuestionDao.deletePaperQuestions();
		return new ResultEntity<Object>(ResultEntity.ResultStatus.SUCCESS.status, "Delete success.");
	}

	@Override
	public Paper getPaperById(int id) {
		return paperDao.getPaperById(id);
	}

	@Override
	public PageInfo<Paper> getPagersBySearchBean(SearchBean searchBean) {
		searchBean.initSearchBean();
		PageHelper.startPage(searchBean.getCurrentPage(), searchBean.getPageSize());
		return new PageInfo<Paper>(
				Optional.ofNullable(paperDao.getPagersBySearchBean(searchBean))
					.orElse(Collections.emptyList()));
	}

}
