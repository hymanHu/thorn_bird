package com.sfac.scGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: Java Spring Cloud Gateway Application
 * @author: HymanHu
 * @date: 2021年4月24日
 */
@SpringBootApplication
@EnableEurekaClient
public class JavaSpringCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringCloudGatewayApplication.class, args);
	}

}
