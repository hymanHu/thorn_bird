package com.sfac.springBoot.modules.test.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description: Application Test
 * Component ---- 注册为 Bean
 * PropertySource ---- 指定配置文件位置
 * ConfigurationProperties ---- 指定公有前缀
 * -有警告信息，Pom 导入 spring-boot-configuration-processor
 * @author HymanHu
 * @date 2021-02-18 08:52:40
 */
@Component
@PropertySource("classpath:config/applicationTest.properties")
@ConfigurationProperties(prefix = "com.test")
public class ApplicationTest {

	private String name;
	private int age;
	private String description;
	private String random;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRandom() {
		return random;
	}

	public void setRandom(String random) {
		this.random = random;
	}
}
