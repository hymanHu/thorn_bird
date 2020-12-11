package com.sfac.javaEe.servlet.account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import com.sfac.javaEe.dao.account.UserDao;
import com.sfac.javaEe.entity.account.User;


/**
 * Description: User Servlet
 * @author HymanHu
 * @date 2020-12-11 14:44:27
 */
@WebServlet(value = "/api/user")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ObjectMapper objectMapper = new ObjectMapper();
	private UserDao userDao = new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String userId = req.getParameter("userId");
		if (StringUtils.isBlank(userId) || !userId.matches("^[0-9]*$")) {
			throw new ServletException("User Id is null or not number.");
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		User user = null;
		try {
			user = userDao.getUserByUserId(Integer.parseInt(userId));
			resultMap.put("status", 200);
			resultMap.put("data", user);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
			resultMap.put("status", 500);
			resultMap.put("message", e.getMessage());
		}
		
		String resultJson = objectMapper.writeValueAsString(resultMap);
		
		resp.setContentType("test/json;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.append(resultJson);
		printWriter.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 接收 request json 数据
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader reader = req.getReader();
		if ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		User user = StringUtils.isNotBlank(sb) ? objectMapper.readValue(sb.toString(), User.class) : new User();
		user.setCreateDate(new Date());
		
		User userTemp = null;
		try {
			userTemp = userDao.getUserByUserName(user.getUserName());
			if (userTemp == null) {
				userDao.insertUser(user);
				req.getSession().setAttribute("userName", userTemp);
				resultMap.put("status", 200);
				resultMap.put("message", "Register success.");
				resultMap.put("data", user);
			} else {
				resultMap.put("status", 500);
				resultMap.put("message", "User name is repeat.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			resultMap.put("status", 500);
			resultMap.put("message", e.getMessage());
		}
		
		// 包装返回 json 对象
		String resultJson = objectMapper.writeValueAsString(resultMap);
		
		// 输出 json
		resp.setContentType("text/json;charset=utf-8;");
		PrintWriter printWriter = resp.getWriter();
		printWriter.append(resultJson);
		printWriter.flush();
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 接收 request json 数据
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader reader = req.getReader();
		if ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		User user = StringUtils.isNotBlank(sb) ? objectMapper.readValue(sb.toString(), User.class) : new User();
		user.setCreateDate(new Date());
		
		User userTemp = null;
		try {
			userTemp = userDao.getUserByUserName(user.getUserName());
			if (userTemp != null && userTemp.getUserId() != user.getUserId()) {
				resultMap.put("status", 500);
				resultMap.put("message", "User is not exit.");
			} else {
				userDao.updateUser(user);
				req.getSession().setAttribute("userName", userTemp);
				resultMap.put("status", 200);
				resultMap.put("message", "Register success.");
				resultMap.put("data", user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			resultMap.put("status", 500);
			resultMap.put("message", e.getMessage());
		}
		
		// 包装返回 json 对象
		String resultJson  = objectMapper.writeValueAsString(resultMap);
		
		// 输出 json
		resp.setContentType("text/json;charset=utf-8;");
		PrintWriter printWriter = resp.getWriter();
		printWriter.append(resultJson);
		printWriter.flush();
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		if (StringUtils.isBlank(userId) || !userId.matches("^[0-9]*$")) {
			throw new ServletException("User Id is null or not number.");
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			userDao.deleteUser(Integer.parseInt(userId));
			resultMap.put("status", 200);
			resultMap.put("message", "Delete success.");
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
			resultMap.put("status", 500);
			resultMap.put("message", e.getMessage());
		}
		
		// 包装返回 json 对象
		String resultJson  = objectMapper.writeValueAsString(resultMap);
		
		// 输出 json
		resp.setContentType("text/json;charset=utf-8;");
		PrintWriter printWriter = resp.getWriter();
		printWriter.append(resultJson);
		printWriter.flush();
	}
	
}
