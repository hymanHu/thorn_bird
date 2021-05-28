package com.sfac.springBoot.modules.exam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Description: 试题标识
 * @author HymanHu
 * @date 2020-10-29 13:44:45
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum QuestionFlag {
	JAVA("Java"),
	PYTHON("Python"),
	DB_SQL("DB_Sql"),
	DB_NOSQL("DB_NoSql"),
	HTML_CSS("Html_And_Css"),
	JAVASCRIPT("JavaScript");

	public String flag;

	private QuestionFlag(String flag) {
		this.flag = flag;
	}
	
}
