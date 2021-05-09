package com.sfac.common.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description: String Util
 * @author: HymanHu
 * @date: 2021年2月3日
 */
public class StringUtil {
	
	/**
	 * String 根据 byte 长度截取
	 */
	public static String splitString(String source, int limit) { 
		if (StringUtils.isBlank(source)) {
			return "";
		}
		
		int count = 0;
		StringBuffer sb = new StringBuffer();
		for (char ch : source.toCharArray()) {
			String item = String.valueOf(ch);
			count += item.getBytes().length;
			if (count <= limit) {
				sb.append(item);
			} else {
				break;
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String temp = "vfvs胡江vfd不舒服是大V上大夫vfdf成都撒女方大bgffb版本不的方式收到才对nvfdsvfhsvds";
		System.out.println(StringUtil.splitString(temp, 20));
	}

}
