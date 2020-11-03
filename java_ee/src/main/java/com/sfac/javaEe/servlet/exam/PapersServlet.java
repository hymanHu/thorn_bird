package com.sfac.javaEe.servlet.exam;

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
import com.sfac.javaEe.dao.exam.PaperDao;
import com.sfac.javaEe.entity.common.PageInfo;
import com.sfac.javaEe.entity.common.SearchVo;
import com.sfac.javaEe.entity.exam.Paper;

/**
 * Description: Papers Servlet
 * @author HymanHu
 * @date 2020-11-01 19:21:51
 */
@WebServlet(value = "/api/papers")
public class PapersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PaperDao paperDao = new PaperDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		String line = "";
		BufferedReader br = req.getReader();
		while (StringUtils.isNotBlank((line = br.readLine()))) {
			sb.append(line);
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		SearchVo searchVo = objectMapper.readValue(sb.toString(), SearchVo.class);
		
		searchVo.initSearchVo();
		List<Paper> papers = new ArrayList<Paper>();
		int count = 0;
		try {
			papers = paperDao.getPapersBySearchVo(searchVo);
			count = paperDao.getPapersCountBySearchVo(searchVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PageInfo<Paper> pageInfo = new PageInfo<Paper>();
		pageInfo.setTotal(count);
		pageInfo.setList(papers);
		String result = objectMapper.writeValueAsString(pageInfo);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.append(result);
		pw.flush();
	}

}
