package com.sfac.springBoot.modules.traffic.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Description: 
 * @author HymanHu
 * @date 2021-03-11 15:30:22
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CarType {
	MINI_CAR("微型车", "A00"),
	LIGHT_DUTY_CAR("小型车", "A0"),
	COMPACT_CAR("紧凑型车", "A"),
	MEDIUM_CAR("中型车", "B"),
	MEDIUM_HIGH_GRADE_CAR("中高级车", "C"),
	LUXURY_CAR("豪华车", "D"),
	BUSINESS_CAR("商务车", "MPV"),
	OFF_ROAD_CAR("越野车", "SUV"),
	;

	public String name;
	public String abbreviation;
	
	private CarType(String name, String abbreviation) {
		this.name = name;
		this.abbreviation = abbreviation;
	}
}
