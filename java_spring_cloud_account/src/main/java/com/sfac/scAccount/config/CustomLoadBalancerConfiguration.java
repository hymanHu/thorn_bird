package com.sfac.scAccount.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * Description: Custom Load Balancer Configuration
 * - 该类不添加 @configuration 注解，因为该类为 @LoadBalancerClient 的属性准备
 * @author HymanHu
 * @date 2021-04-16 11:12:33
 */
public class CustomLoadBalancerConfiguration {
	
	@Bean
	ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(
			Environment environment, 
			LoadBalancerClientFactory loadBalancerClientFactory) {
		String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
		// 在此也可返回自定义负载均衡器
		return new RandomLoadBalancer(
				loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
	}
}
