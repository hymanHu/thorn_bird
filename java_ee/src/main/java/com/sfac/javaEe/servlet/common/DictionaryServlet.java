package com.sfac.javaEe.servlet.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfac.javaEe.entity.exam.QuestionFlag;
import com.sfac.javaEe.entity.exam.QuestionType;

/**
 * Description: Dictionary Servlet
 * http://127.0.0.1/api/dic/questionFlag
 * http://127.0.0.1/api/dic/questionType
 * @author HymanHu
 * @date 2020-12-19 15:38:05
 */
@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
@WebServlet(value = "/api/dic/*")
public class DictionaryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ObjectMapper mapper = new ObjectMapper();
	private static Map<String, Class> ENUM_MAP = new HashMap<String, Class>() {{
		put("questionFlag", QuestionFlag.class);
		put("questionType", QuestionType.class);
	}};

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] urlPatterns = req.getRequestURI().split("/");
		String dictKey = urlPatterns[urlPatterns.length - 1];
		
		List<Object> enums = new ArrayList<Object>();
		try {
			if (ENUM_MAP.containsKey(dictKey)) {
				Class clazz = ENUM_MAP.get(dictKey);
				Method method = clazz.getDeclaredMethod("values");
				Object[] values = (Object[]) method.invoke(null);
				enums = Arrays.asList(values);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String resultJson = mapper.writeValueAsString(enums);
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		writer.append(resultJson);
		writer.flush();
	}
}
