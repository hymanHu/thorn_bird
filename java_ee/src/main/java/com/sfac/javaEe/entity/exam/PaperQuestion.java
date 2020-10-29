package com.sfac.javaEe.entity.exam;

/**
 * Description: 试卷试题中间表
 * @author HymanHu
 * @date 2020-10-29 11:30:59
 */
public class PaperQuestion {
	private int id;
	private int paperId;
	private int questionId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPaperId() {
		return paperId;
	}

	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
}
