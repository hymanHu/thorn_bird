package com.sfac.javaEe.entity.exam;

/**
 * Description: 用户答案类
 * 
 * @author HymanHu
 * @date 2020-10-29 11:36:54
 */
public class Answer {
	private int id;
	private int examId;
	private int questionId;
	private String userAnswer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
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

}
