package com.sfac.springBoot.modules.exam.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * Description: 试卷
 * @author HymanHu
 * @date 2020-10-29 11:24:40
 */
@Entity
@Table(name = "exam_paper")
public class Paper extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	public final static double DEFAULT_TOTAL_SCORE = 100;
	
	@Column(columnDefinition="text")
	private String subject;
	private Integer totalTime;
	private Double totalScore;
	
	@Transient
	private List<Question> questions;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}

}
