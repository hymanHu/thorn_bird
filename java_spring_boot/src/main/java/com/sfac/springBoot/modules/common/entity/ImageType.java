package com.sfac.springBoot.modules.common.entity;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Description: Image Type
 * @author HymanHu
 * @date 2021-02-03 10:28:55
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ImageType {
	
	PROFILE_BIG("profile-big", 220, 220, 1024),
	PROFILE_MIDDLE("profile-small", 50, 50, 100);

	public String name;
	public Integer maxWidth;
	public Integer maxHeight;
	public int maxSize;
	
	private ImageType(String name, Integer maxWidth, Integer maxHeight, int maxSize) {
		this.name = name;
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
		this.maxSize = maxSize;
	}

	public static ImageType getImageTypeByName(String name) {
		return Arrays.stream(ImageType.values())
				.filter(item -> item.name.equalsIgnoreCase(name))
				.findFirst()
				.orElse(null);
	}
	
	public static void main(String[] args) {
		System.out.println(ImageType.getImageTypeByName("profile-big").maxHeight);
	}
	
}
