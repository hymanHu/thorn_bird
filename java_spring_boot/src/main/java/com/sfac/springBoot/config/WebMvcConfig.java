package com.sfac.springBoot.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sfac.springBoot.interceptor.RequestViewMappingInterceptor;

/**
 * Description: Web Mvc Config
 * @author HymanHu
 * @date 2021-02-18 10:46:00
 */
@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Value("${server.http.port}")
	private int httpPort;
	@Autowired
	private ResourceConfigBean resourceConfigBean;
	@Autowired
	private RequestViewMappingInterceptor requestViewMappingInterceptor;
	
	@Bean
	public Connector connector() {
		Connector connector = new Connector();
		connector.setScheme("http");
		connector.setPort(httpPort);
		return connector;
	}
	
	/**
	 * - 重新注册 ServletWebServerFactory Bean
	 * - 以 TomcatServletWebServerFactory 实现，添加 Http 连接器
	 */
	@Bean
	public ServletWebServerFactory servletWebServerFactory() {
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.addAdditionalTomcatConnectors(connector());
		return factory;
	}

	/**
	 * - 添加本地资源文件夹
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String systemName = System.getProperty("os.name");
		if (systemName.toLowerCase().startsWith("win")) {
			registry.addResourceHandler(resourceConfigBean.getResourcePathPattern())
				.addResourceLocations(ResourceUtils.FILE_URL_PREFIX + resourceConfigBean.getLocalPathForWindow());
		} else  {
			registry.addResourceHandler(resourceConfigBean.getResourcePathPattern())
				.addResourceLocations(ResourceUtils.FILE_URL_PREFIX + resourceConfigBean.getLocalPathForLinux());
		}
	}

	/**
	 * - 注册拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestViewMappingInterceptor).addPathPatterns("/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	// 注册 restTemplate
	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setReadTimeout(20000); // ms
		requestFactory.setConnectTimeout(20000); // ms
		return new RestTemplate(requestFactory);
	}
}
