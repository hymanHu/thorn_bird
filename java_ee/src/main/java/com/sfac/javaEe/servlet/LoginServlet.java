package com.sfac.javaEe.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfac.javaEe.entity.User;

/**
 * Description: Login Servlet
 * @author HymanHu
 * @date 2020-10-19 13:20:02
 */
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println(req.getParameter("name"));
		
		resp.setContentType("text/html;charset:utf-8;");
		PrintWriter printWriter = resp.getWriter();
		printWriter.append("<h1>Login page</h1>");
		printWriter.append("这是登录页面.");
		printWriter.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		// 接收 “查询参数” 或 “form表单数据”
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		User userByForm = new User();
		userByForm.setUserName(userName);
		userByForm.setPassword(password);
		userByForm.setCreateDate(new Date());
		
		// 接收 request json 数据
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader reader = req.getReader();
		if ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		User userByJson = StringUtils.isNotBlank(sb) ? mapper.readValue(sb.toString(), User.class) : new User();
		
		// 将userName 保存在 Session
		req.getSession().setAttribute("userName", userName);
		
		// 包装返回 json 对象
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", 200);
		resultMap.put("message", "Login success.");
		resultMap.put("data1", userByForm);
		resultMap.put("data2", userByJson);
		String resultJson = mapper.writeValueAsString(resultMap);
		
		// 输出 json
		resp.setContentType("text/json;charset=utf-8;");
		PrintWriter printWriter = resp.getWriter();
		printWriter.append(resultJson);
		printWriter.flush();
	}
}
