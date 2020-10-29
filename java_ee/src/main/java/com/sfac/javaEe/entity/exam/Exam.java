package com.sfac.javaEe.entity.exam;

import java.time.LocalDateTime;

/**
 * Description: 考试
 * @author HymanHu
 * @date 2020-10-29 11:41:30
 */
public class Exam {
	private int id;
	private int userId;
	private int paperId;
	// 参考得分
	private String referenceScore;
	private int score;
	private int spendTime;
	private LocalDateTime examDate;

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

	public int getPaperId() {
		return paperId;
	}

	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}

	public String getReferenceScore() {
		return referenceScore;
	}

	public void setReferenceScore(String referenceScore) {
		this.referenceScore = referenceScore;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getSpendTime() {
		return spendTime;
	}

	public void setSpendTime(int spendTime) {
		this.spendTime = spendTime;
	}

	public LocalDateTime getExamDate() {
		return examDate;
	}

	public void setExamDate(LocalDateTime examDate) {
		this.examDate = examDate;
	}
}
