package com.sfac.springBoot.modules.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: Exam Controller
 * @author HymanHu
 * @date 2021-05-27 15:01:02
 */
@Controller
@RequestMapping("/exam")
public class ExamController {
	
	/**
	 * 127.0.0.1/exam/questions ---- get
	 */
	@GetMapping("/questions")
	public String questionsPage() {
		return "index";
	}
	
	/**
	 * 127.0.0.1/exam/papers ---- get
	 */
	@GetMapping("/papers")
	public String papersPage() {
		return "exam/papers";
	}

}
