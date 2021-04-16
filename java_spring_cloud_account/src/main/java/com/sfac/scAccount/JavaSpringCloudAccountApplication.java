package com.sfac.scAccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.sfac.scAccount.config.CustomLoadBalancerConfiguration;

/**
 * Description: Java Spring Cloud Account Application
 * @author HymanHu
 * @date 2021-04-16 11:36:05
 */
@SpringBootApplication
@EnableEurekaClient
// name 和注册名保持一致，configuration 引入自定义的配置类
@LoadBalancerClient(name = "client-account", configuration = CustomLoadBalancerConfiguration.class)
public class JavaSpringCloudAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringCloudAccountApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
