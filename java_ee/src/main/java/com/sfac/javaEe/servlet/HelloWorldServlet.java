package com.sfac.javaEe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: Hello World Servlet
 * @author HymanHu
 * @date 2020-10-16 11:21:56
 */
//@WebServlet(value = "/helloWorld")
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public HelloWorldServlet() {
		super();
		System.out.println("==== New HelloWorldServlet Object ====");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("==== Init HelloWorldServlet ====");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("==== Destroy HelloWorldServlet ====");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("==== Call Service Method ====");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("==== Call Get Method ====");
		// 设置响应类型
		resp.setContentType("text/html;charset:utf-8;");
		// 获得输出流
		PrintWriter printWriter = resp.getWriter();
		// 输出流写入响应内容
		printWriter.write("<h1>Hello World!</h1>");
		printWriter.append("<p>" + String.format("RemoteAddress: %s | RemoteHost: %s | RemoteHost: %s", 
				req.getRemoteAddr(), req.getRemoteHost(), req.getRemotePort()) + "</p>");
		printWriter.append("<p>" + String.format("LocalAddr: %s | LocalName: %s | LocalPort: %s", 
				req.getLocalAddr(), req.getLocalName(), req.getLocalPort()) + "</p>");
		printWriter.append("<p>" + String.format("Scheme: %s | Protocol: %s | Method: %s", 
				req.getScheme(), req.getProtocol(), req.getMethod()) + "</p>");
		printWriter.append("<p>" + String.format("ServerName: %s | ServletPath: %s | ServerPort: %s", 
				req.getServerName(), req.getServletPath(), req.getServerPort()) + "</p>");
		printWriter.append("<p>" + String.format("Parameter: %s | ParameterNames: %s | ParameterMap: %s", 
				req.getParameter("name"), req.getParameterNames(), req.getParameterMap()) + "</p>");
		// flush强制输出
		printWriter.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		System.out.println("==== Call Post Method ====");
	}
}
