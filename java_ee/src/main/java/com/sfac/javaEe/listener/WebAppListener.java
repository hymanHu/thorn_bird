package com.sfac.javaEe.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Description: Web App Listener
 * @author HymanHu
 * @date 2020-10-20 11:13:40
 */
@WebListener
public class WebAppListener implements ServletContextListener {

	// 初始化监听器，实现如打开数据库连接池等功能
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("==== Init Webapp Listener ====");
	}

	// 销毁监听器，实现关闭数据库连接池等功能
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("==== Destroy Webapp Listener ====");
	}

}
