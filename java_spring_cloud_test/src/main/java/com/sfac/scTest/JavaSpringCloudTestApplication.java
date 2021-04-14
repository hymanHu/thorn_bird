package com.sfac.scTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class JavaSpringCloudTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringCloudTestApplication.class, args);
	}

}
