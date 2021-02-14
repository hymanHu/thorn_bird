package com.sfac.springMvc.module.humanNature.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Description: Track Type
 * @author: HymanHu
 * @date: 2021年2月8日
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TrackType {
	PHYSIOLOGY(1, "生理", "生理紊乱", "养生有道"),
	PSYCHOLOGY(2, "心理", "内心世界繁杂", "简单明了"),
	WORK(3, "工作", "勤劳，有事业心", "懒惰敷衍"),
	HOME(4, "家庭", "顾家", "家庭观念淡薄"),
	SOCIAL_INTERCOURSE(5, "交际", "善于交际", "不擅交际 OR 过度交际、滥交"),
	STUDY(6, "学习", "好学", "无上进心"),
	MOTION(7, "运动", "爱运动，体魄强健", "亚健康，少运动"),
	TRAVEL(8, "旅行", "见识广，爱旅行", "很少旅行"),
	MAKE_UP(8, "妆容", "爱打扮、时尚", "不爱打扮、朴素"),
	CONSUME(10, "消费", "消费欲强", "节俭持家"),
	PLAN_PROMISE(11, "计划&承诺", "假大空", "切实，不轻易承诺"),
	KEEP_PROMISE(12, "守信", "践行者，值得信赖", "践行者，值得信赖"),
	BREAK_PROMISE(13, "失信", "信誉值低，RPExceptuion", "信誉值低，RPExceptuion");
	
	public int id;
	public String name;
	public String labelA;
	public String labelB;
	
	private TrackType(int id, String name, String labelA, String labelB) {
		this.id = id;
		this.name = name;
		this.labelA = labelA;
		this.labelB = labelB;
	}
	
	public static TrackType getTrackTypeByName(String name) {
		for (TrackType trackType : TrackType.values()) {
			if (name.equals(trackType.name)) {
				return trackType;
			}
		}
		return null;
	}
	
}
