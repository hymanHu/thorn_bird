package com.sfac.javaEe.entity.exam;

/**
 * Description: 用户答案类
 * 
 * @author HymanHu
 * @date 2020-10-29 11:36:54
 */
public class Answer {
	private int id;
	private int pagerId;
	private int questionId;
	private int userId;
	private String userAnswer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPagerId() {
		return pagerId;
	}

	public void setPagerId(int pagerId) {
		this.pagerId = pagerId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

}
