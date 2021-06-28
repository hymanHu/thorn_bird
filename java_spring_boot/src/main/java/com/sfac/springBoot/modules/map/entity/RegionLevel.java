package com.sfac.springBoot.modules.map.entity;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Description: Region Level
 * 
 * @author HymanHu
 * @date 2021-06-28 13:30:05
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RegionLevel {
	COUNTRY(0, "country"),
	PROVINCE(1, "province"),
	CITY(2, "city"),
	DISTRICT(3, "district"),
	STREET(4, "street"),
	;
	
	public int code;
	public String level;

	private RegionLevel(int code, String level) {
		this.code = code;
		this.level = level;
	}
	
	// 根据 level 查询对应 RegionLevel
	public static RegionLevel getRegionLevel(String level) {
		return Arrays.stream(RegionLevel.values())
				.filter(item -> level.equals(item.level))
				.findFirst()
				.orElse(null);
	}
	
	// 根据 code 查询下一级 RegionLevel
	public static RegionLevel getSubRegionLevel(int code) {
		return Arrays.stream(RegionLevel.values())
				.filter(item -> item.code == code + 1)
				.findFirst()
				.orElse(null);
	}
	
	public static void main(String[] args) {
		System.out.println(RegionLevel.getRegionLevel("street"));
		System.out.println(RegionLevel.getSubRegionLevel(1));
	}

}
