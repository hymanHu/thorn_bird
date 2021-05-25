package com.sfac.springBoot.modules.exam.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * Description: 测试成绩
 * 
 * @author HymanHu
 * @date 2020-10-29 11:41:30
 */
@Entity
@Table(name = "exam_achievement")
public class Achievement extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private int userId;
	private String subject;
	// 试卷总分
	private Double totalScore;
	// 参考得分
	private String referenceScore;
	// 得分
	private Double score;
	// 分数百分比，应对总分数不是 100 的情况
	private Double percentScore;
	private Integer totalTime;
	private Integer spendTime;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime examDate;
	
	@Transient
	private List<Answer> answers;
	@Transient
	private String userName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}

	public String getReferenceScore() {
		return referenceScore;
	}

	public void setReferenceScore(String referenceScore) {
		this.referenceScore = referenceScore;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Double getPercentScore() {
		return percentScore;
	}

	public void setPercentScore(Double percentScore) {
		this.percentScore = percentScore;
	}

	public Integer getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}

	public Integer getSpendTime() {
		return spendTime;
	}

	public void setSpendTime(Integer spendTime) {
		this.spendTime = spendTime;
	}

	public LocalDateTime getExamDate() {
		return examDate;
	}

	public void setExamDate(LocalDateTime examDate) {
		this.examDate = examDate;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
