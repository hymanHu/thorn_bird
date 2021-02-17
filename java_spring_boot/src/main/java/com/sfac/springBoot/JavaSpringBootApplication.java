package com.sfac.springBoot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Description: Java Spring Boot Application
 * @author: HymanHu
 * @date: 2021年2月17日
 */
@SpringBootApplication
public class JavaSpringBootApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(JavaSpringBootApplication.class);
	}

	public static void main(String[] args) {
//		SpringApplication.run(JavaSpringBootApplication.class, args);
		SpringApplication springApplication = new  SpringApplication(JavaSpringBootApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}

}
