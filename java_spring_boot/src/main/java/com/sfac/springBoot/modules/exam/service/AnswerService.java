package com.sfac.springBoot.modules.exam.service;

import java.util.List;

import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.exam.entity.Answer;

/**
 * Description: Answer Service
 * @author HymanHu
 * @date 2021-05-27 10:36:05
 */
public interface AnswerService {

	ResultEntity<Answer> insertAnswer(Answer answer);
	
	ResultEntity<Answer> updateAnswer(Answer answer);
	
	ResultEntity<Object> deleteAnswersByAchievementId(int achievementId);
	
	Answer getAnswerById(int id);
	
	List<Answer> getAnswersByAchievementId(int achievementId);
}
