package com.sfac.springBoot.config.task;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.ScheduleBuilder;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Configuration
public class QuartzTaskConfig {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(QuartzTaskConfig.class);
	
	@Bean
	public JobDetail jobDetail_1() {
		Job job = new QuartzJobBean() {
			@Override
			protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
				LOGGER.debug("==== 第一个 Quartz 任务：Hello World！ ====");
			}
		};
		
		return JobBuilder.newJob(job.getClass()).storeDurably().build();
	}
	
	@Bean
	public Trigger trigger_1() {
		ScheduleBuilder<SimpleTrigger> scheduleBuilder = SimpleScheduleBuilder
				.simpleSchedule()
				.withIntervalInSeconds(10)
				.repeatForever();
		return TriggerBuilder.newTrigger().forJob(jobDetail_1()).withSchedule(scheduleBuilder).build();
	}

}
