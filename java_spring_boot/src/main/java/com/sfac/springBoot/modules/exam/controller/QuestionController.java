package com.sfac.springBoot.modules.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.SearchBean;
import com.sfac.springBoot.modules.exam.entity.Question;
import com.sfac.springBoot.modules.exam.service.QuestionService;

/**
 * Description: 
 * @author HymanHu
 * @date 2021-05-25 16:37:30
 */
@RestController
@RequestMapping("/api")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	/**
	 * 127.0.0.1/api/question ---- post
	 */
	@PostMapping(value = "/question", consumes = "application/json")
	public ResultEntity<Question> insertQuestion(@RequestBody Question question) {
		return questionService.insertQuestion(question);
	}
	
	/**
	 * 127.0.0.1/api/question ---- put
	 */
	@PutMapping(value = "/question", consumes = "application/json")
	public ResultEntity<Question> updateQuestion(@RequestBody Question question) {
		return questionService.updateQuestion(question);
	}
	
	/**
	 * 127.0.0.1/api/question/1 ---- delete
	 */
	@DeleteMapping("/question/{id}")
	public ResultEntity<Object> deleteQuestion(@PathVariable int id) {
		return questionService.deleteQuestion(id);
	}
	
	/**
	 * 127.0.0.1/api/question/1 ---- get
	 */
	@GetMapping("/question/{id}")
	public Question getQuestionById(@PathVariable int id) {
		return questionService.getQuestionById(id);
	}
	
	/**
	 * 127.0.0.1/api/questions ---- post
	 */
	@PostMapping(value = "/questions", consumes = "application/json")
	public PageInfo<Question> getQuestionsBySearchBean(@RequestBody SearchBean searchBean) {
		return questionService.getQuestionsBySearchBean(searchBean);
	}
	
	/**
	 * 127.0.0.1/api/questions/1 ---- get
	 */
	@GetMapping("/questions/{paperId}")
	public List<Question> getQuestionsByPaperId(@PathVariable int paperId) {
		return questionService.getQuestionsByPaperId(paperId);
	}
}
