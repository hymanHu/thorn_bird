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

import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.exam.entity.Answer;
import com.sfac.springBoot.modules.exam.service.AnswerService;

/**
 * Description: Answer Controller
 * @author HymanHu
 * @date 2021-05-27 10:47:10
 */
@RestController
@RequestMapping("/api")
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	
	/**
	 * 127.0.0.1/api/answer ---- post
	 * {"achievementId":1,"questionId":1,"userAnswer":"D"}
	 */
	@PostMapping(value = "/answer", consumes = "application/json")
	public ResultEntity<Answer> insertAnswer(@RequestBody Answer answer) {
		return answerService.insertAnswer(answer);
	}
	
	/**
	 * 127.0.0.1/api/answer ---- put
	 * {"id":1,"achievementId":1,"questionId":1,"userAnswer":"D"}
	 */
	@PutMapping(value = "/answer", consumes = "application/json")
	public ResultEntity<Answer> updateAnswer(@RequestBody Answer answer) {
		return answerService.updateAnswer(answer);
	}
	
	/**
	 * 127.0.0.1/api/answers/1 ---- gelete
	 */
	@DeleteMapping("/answers/{achievementId}")
	public ResultEntity<Object> deleteAnswersByAchievementId(@PathVariable int achievementId) {
		return answerService.deleteAnswersByAchievementId(achievementId);
	}
	
	/**
	 * 127.0.0.1/api/answer/1 ---- get
	 */
	@GetMapping("/answer/{id}")
	public Answer getAnswerById(@PathVariable int id) {
		return answerService.getAnswerById(id);
	}
	
	/**
	 * 127.0.0.1/api/answers/1 ---- get
	 */
	@GetMapping("/answers/{achievementId}")
	public List<Answer> getAnswersByAchievementId(@PathVariable int achievementId) {
		return answerService.getAnswersByAchievementId(achievementId);
	}

}
