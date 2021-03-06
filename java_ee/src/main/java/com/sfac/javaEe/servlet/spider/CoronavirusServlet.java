package com.sfac.javaEe.servlet.spider;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfac.javaEe.dao.spider.CoronavirusDao;
import com.sfac.javaEe.entity.spider.Coronavirus;

/**
 * Description: Coronavirus Servlet
 * @author HymanHu
 * @date 2020-10-23 13:48:31
 */
@WebServlet(value = "/api/gzbds")
public class CoronavirusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CoronavirusDao coronavirusDao = new CoronavirusDao();
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Coronavirus> coronavirusList = new ArrayList<Coronavirus>();
		
		try {
			coronavirusList = coronavirusDao.getCoronavirusList();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String results = objectMapper.writeValueAsString(coronavirusList);
		
		resp.setContentType("text/json;charset=utf-8;");
		PrintWriter printWriter = resp.getWriter();
		printWriter.append(results);
		printWriter.flush();
	}

}
