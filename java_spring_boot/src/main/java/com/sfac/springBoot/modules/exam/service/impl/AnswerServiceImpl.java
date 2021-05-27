package com.sfac.springBoot.modules.exam.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.exam.dao.AnswerDao;
import com.sfac.springBoot.modules.exam.entity.Answer;
import com.sfac.springBoot.modules.exam.service.AnswerService;

/**
 * Description: Answer Service Impl
 * @author HymanHu
 * @date 2021-05-27 10:38:18
 */
@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	private AnswerDao answerDao;

	@Override
	@Transactional
	public ResultEntity<Answer> insertAnswer(Answer answer) {
		answer.setCreateDate(LocalDateTime.now());
		answerDao.insertAnswer(answer);
		return new ResultEntity<Answer>(ResultEntity.ResultStatus.SUCCESS.status, "Insert success.", answer);
	}

	@Override
	@Transactional
	public ResultEntity<Answer> updateAnswer(Answer answer) {
		answerDao.updateAnswer(answer);
		return new ResultEntity<Answer>(ResultEntity.ResultStatus.SUCCESS.status, "Update success.", answer);
	}

	@Override
	@Transactional
	public ResultEntity<Object> deleteAnswersByAchievementId(int achievementId) {
		answerDao.deleteAnswersByAchievementId(achievementId);
		return new ResultEntity<Object>(ResultEntity.ResultStatus.SUCCESS.status, "Delete success.");
	}

	@Override
	public Answer getAnswerById(int id) {
		return answerDao.getAnswerById(id);
	}

	@Override
	public List<Answer> getAnswersByAchievementId(int achievementId) {
		return answerDao.getAnswersByAchievementId(achievementId);
	}

}
