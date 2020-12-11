package com.sfac.javaEe.servlet.account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfac.javaEe.dao.account.UserDao;
import com.sfac.javaEe.entity.account.User;
import com.sfac.javaEe.entity.common.PageInfo;
import com.sfac.javaEe.entity.common.SearchBean;

/**
 * Description: Users Servlet
 * @author HymanHu
 * @date 2020-12-11 13:41:44
 */
@WebServlet(value = "/api/users")
public class UsersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ObjectMapper objectMapper = new ObjectMapper();
	private UserDao userDao = new UserDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		String line = "";
		BufferedReader reader = req.getReader();
		while (StringUtils.isNotBlank(line = reader.readLine())) {
			sb.append(line);
		}
		SearchBean searchBean = objectMapper.readValue(sb.toString(), SearchBean.class);
		
		List<User> users = new ArrayList<User>();
		int total = 0;
		try {
			users = userDao.getUsersBySearchBean(searchBean);
			total = userDao.getUsersCountBySearchBean(searchBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PageInfo<User> pageinfo = new PageInfo<User>();
		pageinfo.setList(users);
		pageinfo.setTotal(total);
		String resultJson = objectMapper.writeValueAsString(pageinfo);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		writer.append(resultJson);
		writer.flush();
	}

}
