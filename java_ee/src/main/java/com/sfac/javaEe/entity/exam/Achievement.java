package com.sfac.javaEe.entity.exam;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Description: 测试成绩
 * 
 * @author HymanHu
 * @date 2020-10-29 11:41:30
 */
public class Achievement {
	private int id;
	private int userId;
	private String subject;
	// 试卷总分
	private Double totalScore;
	// 参考得分
	private String referenceScore;
	// 得分
	private Double score;
	private Integer totalTime;
	private Integer spendTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date examDate;
	private List<Answer> answers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
