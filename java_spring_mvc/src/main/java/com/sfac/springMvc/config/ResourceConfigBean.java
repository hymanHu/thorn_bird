package com.sfac.springMvc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description: Resource Config Bean
 * @author HymanHu
 * @date 2021-02-03 14:11:03
 */
@Component
@PropertySource("classpath:config/properties/springMvcParms.properties")
public class ResourceConfigBean {

	@Value("${resource.path.pattern}")
	private String resourcePathPattern;
	@Value("${resource.path.mapping}")
	private String resourcePathMapping;
	@Value("${resource.path.local.windows}")
	private String resourcePathLocalWindows;
	@Value("${resource.path.local.linux}")
	private String resourcePathLocalLinux;

	public String getResourcePathPattern() {
		return resourcePathPattern;
	}

	public void setResourcePathPattern(String resourcePathPattern) {
		this.resourcePathPattern = resourcePathPattern;
	}

	public String getResourcePathMapping() {
		return resourcePathMapping;
	}

	public void setResourcePathMapping(String resourcePathMapping) {
		this.resourcePathMapping = resourcePathMapping;
	}

	public String getResourcePathLocalWindows() {
		return resourcePathLocalWindows;
	}

	public void setResourcePathLocalWindows(String resourcePathLocalWindows) {
		this.resourcePathLocalWindows = resourcePathLocalWindows;
	}

	public String getResourcePathLocalLinux() {
		return resourcePathLocalLinux;
	}

	public void setResourcePathLocalLinux(String resourcePathLocalLinux) {
		this.resourcePathLocalLinux = resourcePathLocalLinux;
	}
}
