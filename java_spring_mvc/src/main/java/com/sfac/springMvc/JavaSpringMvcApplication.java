package com.sfac.springMvc;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

/**
 * Description: Java Spring Mvc Application
 * @author HymanHu
 * @date 2020-12-08 13:27:58
 */
public class JavaSpringMvcApplication {

	private static int PORT = 80;
    private static String CONTEXT_PATH = "/";

	public static void main(String[] args) throws LifecycleException {
//		String classesDir = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String classesDir = new File("target/classes").getAbsolutePath();
		String appDir = new File("src/main/webapp").getAbsolutePath();
		System.out.println(String.format("Classes Dir: %s", classesDir));
		System.out.println(String.format("Webapp Dir: %s", classesDir));
		
		// 创建 Tomcat，并设置基础目录、端口、连接器
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir(classesDir);
		tomcat.setPort(PORT);
		tomcat.getConnector();
		
		// 添加 webapp
        Context context = tomcat.addWebapp(CONTEXT_PATH, appDir);
        WebResourceRoot resources = new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", classesDir, "/"));
        context.setResources(resources);
        
        // 启动服务器
        tomcat.start();
        tomcat.getServer().await();
	}
}
