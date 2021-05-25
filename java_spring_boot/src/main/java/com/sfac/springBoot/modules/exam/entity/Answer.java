package com.sfac.springBoot.modules.exam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * Description: 用户答案类
 * 
 * @author HymanHu
 * @date 2020-10-29 11:36:54
 */
@Entity
@Table(name = "exam_answer")
public class Answer extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private int achievementId;
	private int questionId;
	@Column(columnDefinition="text")
	private String userAnswer;
	
	@Transient
	private Question question;

	public int getAchievementId() {
		return achievementId;
	}

	public void setAchievementId(int achievementId) {
		this.achievementId = achievementId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
