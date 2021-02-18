package com.sfac.springBoot.listener;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: Log File Destroy Listener
 * @author: HymanHu
 * @date: 2021年2月18日
 */
@WebListener
public class LogFileDestroyListener implements ServletContextListener {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(LogFileDestroyListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOGGER.debug("==== Init context ====");
		File file = new File("/log");
		if (file == null || !file.exists()) {
			return;
		}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String currentDate = dtf.format(LocalDateTime.now());
		
		File[] files = file.listFiles();
		for (File f : files) {
			String fileName = f.getName();
			if (!fileName.contains(currentDate)) {
				f.delete();
			}
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LOGGER.debug("==== Destroy context ====");
	}

}
