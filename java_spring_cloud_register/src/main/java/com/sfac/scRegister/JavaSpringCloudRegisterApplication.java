package com.sfac.scRegister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JavaSpringCloudRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringCloudRegisterApplication.class, args);
	}

}
