package com.sfac.javaEe.servlet.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfac.javaEe.entity.User;

/**
 * Description: Jsp Test Servlet
 * @author HymanHu
 * @date 2020-10-20 15:14:33
 */
@WebServlet(value = "/test/index")
public class JspTestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().setAttribute("userName", "Hujiang");
		req.setAttribute("otherName", "HymanHu");
		req.setAttribute("now", new Date());
		req.setAttribute("number", 18.3456);
		req.setAttribute("age", 18);
		List<User> users = new ArrayList<User>();
		IntStream.range(1, 10).forEach(i -> {
			User user = new User();
			user.setId(i);
			user.setUserName(String.format("Hujiang%d", new Random().nextInt(12)));
			users.add(user);
		});
		req.setAttribute("users", users);
		req.getRequestDispatcher("/WEB-INF/jsp/test/index.jsp").forward(req, resp);
	}

}
