package com.sfac.scConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Description: Java Spring Cloud Config Application
 * @author HymanHu
 * @date 2021-04-25 09:36:22
 */
@SpringBootApplication
@EnableConfigServer
public class JavaSpringCloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringCloudConfigApplication.class, args);
	}

}
