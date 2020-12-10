package com.sfac.javaEe;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

/**
 * Description: Java EE Application
 * @author HymanHu
 * @date 2020-10-19 09:35:31
 */
public class JavaEEApplication {
	
    private static int PORT = 80;
    private static String CONTEXT_PATH = "/";

	public static void main(String[] args) throws LifecycleException {
//		String baseDir = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String baseDir = new File("target/classes").getAbsolutePath();
		String appDir = new File("src/main/webapp").getAbsolutePath();
		System.out.println(baseDir);
		System.out.println(appDir);
		
		// 创建 Tomcat，并设置基础目录、端口、连接器
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir(baseDir);
		tomcat.setPort(PORT);
		tomcat.getConnector();
		
		// 添加 webapp
        Context context = tomcat.addWebapp(CONTEXT_PATH, appDir);
        WebResourceRoot resources = new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", baseDir, "/"));
        context.setResources(resources);
        
        // 启动服务器
        tomcat.start();
        tomcat.getServer().await();
	}
}
