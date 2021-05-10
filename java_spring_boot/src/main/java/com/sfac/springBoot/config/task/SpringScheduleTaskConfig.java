package com.sfac.springBoot.config.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Description: Spring Schedule Task Config
 * @author HymanHu
 * @date 2021-05-10 15:31:59
 */
@Component
public class SpringScheduleTaskConfig {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(SpringScheduleTaskConfig.class);
	
	@Scheduled(cron = "0 0 0/1 * * *")
	public void cronTask() {
		LOGGER.debug(String.format("==== Spring Schedule 计划任务：Cron 表达式，每 %s 小时执行一次====", 1));
	}
	
	@Scheduled(fixedDelay = 1 * 60 * 60 * 1000)
	public void fixedDelayTask() {
		LOGGER.debug(String.format("==== Spring Schedule 计划任务：固定间隔执行，每 %s 小时执行一次====", 1));
	}
	
	@Scheduled(fixedRate = 1 * 60 * 60 * 1000)
	public void fixRateTask() {
		LOGGER.debug(String.format("==== Spring Schedule 计划任务：固定评率执行，每 %s 小时执行一次====", 1));
	}
}
