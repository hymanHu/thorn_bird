package com.sfac.springBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Description: Web Socket Config
 * @author: HymanHu
 * @date: 2021年4月9日
 */
@Configuration
public class WebSocketConfig {
	/**
	 * - 自动注册使用 @ServerEndpoint 注解声明的 WebSocket Endpoint
	 * - 可理解为将之注册为控制器
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
