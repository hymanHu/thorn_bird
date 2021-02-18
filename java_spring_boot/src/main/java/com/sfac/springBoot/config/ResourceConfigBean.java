package com.sfac.springBoot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description: Resource Config Bean
 * @author HymanHu
 * @date 2021-02-18 11:04:22
 */
@Component
@PropertySource("classpath:config/application.properties")
public class ResourceConfigBean {

	@Value("${spring.resource.path}")
	private String resourcePath;
	@Value("${spring.resource.path.pattern}")
	private String resourcePathPattern;
	@Value("${spring.resource.folder.windows}")
	private String localPathForWindow;
	@Value("${spring.resource.folder.linux}")
	private String localPathForLinux;

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public String getResourcePathPattern() {
		return resourcePathPattern;
	}

	public void setResourcePathPattern(String resourcePathPattern) {
		this.resourcePathPattern = resourcePathPattern;
	}

	public String getLocalPathForWindow() {
		return localPathForWindow;
	}

	public void setLocalPathForWindow(String localPathForWindow) {
		this.localPathForWindow = localPathForWindow;
	}

	public String getLocalPathForLinux() {
		return localPathForLinux;
	}

	public void setLocalPathForLinux(String localPathForLinux) {
		this.localPathForLinux = localPathForLinux;
	}
}
