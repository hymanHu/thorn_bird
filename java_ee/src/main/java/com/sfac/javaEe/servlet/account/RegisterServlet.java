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
 * @Description: Register Servlet
 * @author: HymanHu
 * @date: 2020年10月22日
 */
@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ObjectMapper objectMapper = new ObjectMapper();
	private UserDao userDao = new UserDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/account/register.jsp").forward(req, resp);
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
		} catch (SQLException | ClassNotFoundException e) {
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

}
