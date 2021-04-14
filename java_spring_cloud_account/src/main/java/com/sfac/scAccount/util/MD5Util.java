package com.sfac.scAccount.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

/**
 * @Description: MD5 Util
 * @author: HymanHu
 * @date: 2021年2月21日
 */
public class MD5Util {
	private static final String SALT = "&%5123***&&%%$$#@";
	
	public static String getMD5(String password) {
		if (StringUtils.isBlank(password)) {
			return null;
		}
		String base = password + "/" + SALT;
		return DigestUtils.md5DigestAsHex(base.getBytes());
	}
}
