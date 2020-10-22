package com.sfac.javaEe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Description: DB Util
 * @author: HymanHu
 * @date: 2020年10月21日
 */
/**
 * @Description: 
 * @author: HymanHu
 * @date: 2020年10月22日
 */
public class DBUtil {
	
	private static String user ="";
    private static String password = "";
    private static String url = "";
    private static String driver = "";
    private static Connection conn = null;
    
    /**
     * -初始化连接属性
     */
    static {
    	driver = ConfigUtil.properties.getProperty("jdbc.driverClassName");
    	url = ConfigUtil.properties.getProperty("jdbc.url");
    	user = ConfigUtil.properties.getProperty("jdbc.username");
    	password = ConfigUtil.properties.getProperty("jdbc.password");
    }
    
    /**
     * -获取数据库连接
     */
    public static Connection getConnection() {
    	try {
    		Class.forName(driver);
    		conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return conn;
    }
    
    /**
     * -关闭数据库连接
     */
    public static void closeConnection(Connection conn) {
    	if (conn != null) {
    		try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
}
