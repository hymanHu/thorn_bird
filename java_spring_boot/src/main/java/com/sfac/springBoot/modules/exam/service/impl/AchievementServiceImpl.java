package com.sfac.springBoot.modules.exam.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.exam.dao.AchievementDao;
import com.sfac.springBoot.modules.exam.dao.AnswerDao;
import com.sfac.springBoot.modules.exam.dao.QuestionDao;
import com.sfac.springBoot.modules.exam.entity.Achievement;
import com.sfac.springBoot.modules.exam.entity.Answer;
import com.sfac.springBoot.modules.exam.entity.Question;
import com.sfac.springBoot.modules.exam.entity.QuestionType;
import com.sfac.springBoot.modules.exam.service.AchievementService;

/**
 * Description: Achievement Service Impl
 * @author HymanHu
 * @date 2021-05-27 12:53:42
 */
@Service
public class AchievementServiceImpl implements AchievementService {
	
	@Autowired
	private AchievementDao achievementDao;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private AnswerDao answerDao;

	@Override
	@Transactional
	public ResultEntity<Achievement> insertAchievement(Achievement achievement) {
		// 客观题分数，确定分值
		double objectiveQuestionsScore = 0.0;
		// 主观题分数，须人工判卷，不确定分值
		double subjectiveQuestionsScore = 0.0;
		for (Answer item : achievement.getAnswers()) {
			Question question = questionDao.getQuestionById(item.getQuestionId());
			if (question.getType().equals(QuestionType.SINGLE_CHOICE.name) || 
					question.getType().equals(QuestionType.MULTIPLE_CHOICE.name) || 
					question.getType().equals(QuestionType.JUDGE.name)) {
				if (question != null && 
						StringUtils.isNotBlank(question.getReferenceAnswer()) && 
						item.getUserAnswer().equals(question.getReferenceAnswer())) {
					objectiveQuestionsScore += question.getScore();
				}
			} else {
				subjectiveQuestionsScore += question.getScore();
			}
		}
		
		if (subjectiveQuestionsScore == 0) {
			achievement.setReferenceScore(objectiveQuestionsScore + "");
		} else {
			// 参考分值 = 客观题分值 ~ （客观题分值 + 主观题总分）
			achievement.setReferenceScore(String.format("%s ~ %s", 
					objectiveQuestionsScore, (objectiveQuestionsScore + subjectiveQuestionsScore)));
		}
		if (subjectiveQuestionsScore == 0) {
			achievement.setScore(objectiveQuestionsScore);
			BigDecimal bg = new BigDecimal(objectiveQuestionsScore / achievement.getTotalScore());
			achievement.setPercentScore(bg.setScale(2, RoundingMode.HALF_UP).doubleValue());
		} else {
			achievement.setScore(0.0);
			achievement.setPercentScore(0.0);
		}
		
		// 插入成绩
		achievement.setCreateDate(LocalDateTime.now());
		achievement.setExamDate(LocalDateTime.now());
		achievementDao.insertAchievement(achievement);
		
		// 插入答题
		int achievementId = achievement.getId();
		achievement.getAnswers().stream().forEach(item -> {
			item.setAchievementId(achievementId);
			answerDao.insertAnswer(item);
		});
		
		return new ResultEntity<Achievement>(ResultEntity.ResultStatus.SUCCESS.status, "Insert success.", achievement);
	}

	@Override
	@Transactional
	public ResultEntity<Achievement> updateAchievement(Achievement achievement) {
		achievementDao.updateAchievement(achievement);
		return new ResultEntity<Achievement>(ResultEntity.ResultStatus.SUCCESS.status, "Update success.", achievement);
	}

	@Override
	@Transactional
	public ResultEntity<Object> deleteAchievementById(int id) {
		achievementDao.deleteAchievementById(id);
		answerDao.deleteAnswersByAchievementId(id);
		return new ResultEntity<Object>(ResultEntity.ResultStatus.SUCCESS.status, "Delete success.");
	}

	@Override
	public Achievement getAchievementById(int id) {
		return achievementDao.getAchievementById(id);
	}

	@Override
	public PageInfo<Achievement> getAchievementsBySearchBean(SearchBean searchBean) {
		searchBean.initSearchBean();
		PageHelper.startPage(searchBean.getCurrentPage(), searchBean.getPageSize());
		return new PageInfo<Achievement>(
				Optional.ofNullable(achievementDao.getAchievementsBySearchBean(searchBean))
					.orElse(Collections.emptyList()));
	}
}
