package com.sfac.javaEe.entity.exam;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Description: 试题标识
 * @author HymanHu
 * @date 2020-10-29 13:44:45
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum QuestionFlag {
	JAVA_SE("Java_SE"),
	JAVA_EE("Java_EE"),
	JAVA_FRAMEWORK("Java_Framework"),
	PYTHON_BASE("Python_Base"),
	PYTHON_SPIDER("Python_Spider"),
	PYTHON_WEB("Python_Web"),
	DB_SQL("DB_Sql"),
	DB_NOSQL("DB_NoSql"),
	FRONT_HTML("Front_Html"),
	FRONT_CSS("Front_Css"),
	FRONT_JS("Front_Js");

	public String flag;

	private QuestionFlag(String flag) {
		this.flag = flag;
	}
	
}
