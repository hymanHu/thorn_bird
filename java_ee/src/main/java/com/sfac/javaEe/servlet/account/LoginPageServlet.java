package com.sfac.javaEe.servlet.account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
 * Description: Login Servlet
 * @author HymanHu
 * @date 2020-10-19 13:20:02
 */
@WebServlet(value = "/login")
public class LoginPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/account/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String resultJson = "";
		
		// 接收 request json 数据
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader reader = req.getReader();
		if ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		User user = StringUtils.isNotBlank(sb) ? mapper.readValue(sb.toString(), User.class) : new User();
		
		User userTemp = null;
		try {
			userTemp = userDao.getUserByUserNameAndPassword(user.getUserName(), user.getPassword());
			if (userTemp == null) {
				resultMap.put("status", 500);
				resultMap.put("message", "User name or password error.");
			} else {
				// 将 user 保存在 Session
				req.getSession().setAttribute("user", userTemp);
				resultMap.put("status", 200);
				resultMap.put("message", "Login success.");
				resultMap.put("data", user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			resultMap.put("status", 500);
			resultMap.put("message", e.getMessage());
		}
		
		// 包装返回 json 对象
		resultJson = mapper.writeValueAsString(resultMap);
		
		// 输出 json
		resp.setContentType("text/json;charset=utf-8;");
		PrintWriter printWriter = resp.getWriter();
		printWriter.append(resultJson);
		printWriter.flush();
	}
}
