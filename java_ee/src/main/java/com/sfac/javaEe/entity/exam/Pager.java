package com.sfac.javaEe.entity.exam;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Description: 试卷
 * @author HymanHu
 * @date 2020-10-29 11:24:40
 */
public class Pager {
	private int id;
	private String subject;
	private LocalDateTime createDate;
	private List<Question> questions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
