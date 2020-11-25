package com.sfac.javaEe.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// 获取传递到servlet的method参数，以确定该调用哪个方法
		String methodName = req.getParameter("method");
		if (methodName == null || methodName.trim().isEmpty()) {
			throw new RuntimeException("没有指定method参数，无法确定调用的方法！");
		}
		Class baseServlet = this.getClass();
		Method method = null;
		try {
			// 通过反射获取当前class对应methodName的方法
			method = baseServlet.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		try {
			// 调用该方法，返回字符串类型的结果
			String result = (String) method.invoke(this, req, resp);
			// 如果结果为空，什么也不做
			if (result == null || result.trim().isEmpty()) {
				return;
			}
			// 这里定义冒号存在的情况：冒号前面部分表示操作，目前支持redirect重定向和forward请求转发两种
			// 冒号后面部分表示对应的url路径
			if (result.contains(":")) {
				// 获取冒号位置
				int index = result.indexOf(":");
				String prefix = result.substring(0, index);
				String path = result.substring(index + 1);
				if (prefix.toLowerCase().startsWith("r")) {
					resp.sendRedirect(path);
				} else if (prefix.toLowerCase().startsWith("f")) {
					req.getRequestDispatcher(path).forward(req, resp);
				} else {
					throw new RuntimeException("指定的操作目前版本不支持");
				}
			} else {
				// 默认就是请求转发
				req.getRequestDispatcher(result).forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
