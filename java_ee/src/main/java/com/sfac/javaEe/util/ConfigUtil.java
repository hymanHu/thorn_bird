package com.sfac.javaEe.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * @Description: Config Util
 * @author: HymanHu
 * @date: 2020年10月21日
 */
public class ConfigUtil {

	public static Properties properties = new Properties();
	
	/**
	 * 先将配置文件读取到properties文件中
	 */
	static {
		InputStream is = null;
		try {
			is = ConfigUtil.class.getClassLoader().getResourceAsStream("jdbc-parms.properties");
			properties.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(ConfigUtil.properties.getProperty("jdbc.url", ""));
	}
}
