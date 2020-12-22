package com.sfac.javaEe.entity.exam;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Description: 题目类型
 * @author HymanHu
 * @date 2020-10-29 13:30:34
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum QuestionType {
	SINGLE_CHOICE("singleChoice", "单选题", 2.5), 
	MULTIPLE_CHOICE("multipleChoice", "多选题", 5),
	JUDGE("judge", "判断题", 2.5),
	FILL_BLANK("fillBlank", "填空题", 2.5),
	SHORT_ANSWER("shortAnswer", "简答题", 5),
	PROGRAMMING("programming", "编程题", 15);
	
	public String name;
	public String localName;
	public double score;

	private QuestionType(String name, String localName, double score) {
		this.name = name;
		this.localName = localName;
		this.score = score;
	}

	public static String getLocalName(String name) {
		QuestionType questionType = Arrays.asList(QuestionType.values()).stream()
			.filter(item -> item.name.equals(name))
			.findFirst()
			.orElse(null);
		return questionType == null ? null : questionType.localName;
	}
	
	public static void main(String[] args) {
		System.out.println(QuestionType.getLocalName("judge"));
	}
}
