package com.sfac.springBoot.modules.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sfac.springBoot.modules.common.entity.Mail;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.service.MailService;

/**
 * @Description: Mail Controller
 * @author: HymanHu
 * @date: 2021年4月27日
 */
@RestController
@RequestMapping("/api")
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	/**
	 * - 简单邮件
	 * 127.0.0.1/api/simpleMail ---- post
	 * {"to":["898899721@qq.com"],"cc":["hujiang_cd@hqyj.com"],"subject":"SimpleMailSubject",
	 * "text":"SimpleMailContent"}
	 */
	@PostMapping(value = "/simpleMail", consumes = "application/json")
	public ResultEntity<Object> sendSimpleMail(@RequestBody Mail mail) {
		return mailService.sendSimpleMail(mail);
	}
	
	/**
	 * - 富文本邮件
	 * 127.0.0.1/api/complexMail ---- post
	 * {"to":["898899721@qq.com"],"cc":["hujiang_cd@hqyj.com"],"subject":"complexMail", 
	 * "text":"<html><head></head><body><h1>hello! Welcome Hyman!</h1></body></html>",
	 * "html":"true","attachments":["D:/temp/temp.txt","D:/temp/111.jpg","D:/temp/222.jpg"]}
	 */
	@PostMapping(value = "/complexMail",consumes = "application/json")
	public ResultEntity<Object> sendComplexMail(@RequestBody Mail mail) {
		return mailService.sendComplexMail(mail);
	}
	
	/**
	 * - Thymeleaf 模版邮件
	 * 127.0.0.1/api/templateMail ---- post
	 * {"to":["898899721@qq.com"],"cc":["hujiang_cd@hqyj.com"],"subject":"TemplateMailSubject","text":
	 * "TemplateMailContent","templateMap":{"name":"HymanHu","id":"12345"},"templateId":"wellCome"}
	 */
	@PostMapping(value = "/templateMail/{templateId}",consumes = "application/json")
	public ResultEntity<Object> sendTemplateMail(@RequestBody Mail mail) {
		return mailService.sendTemplateMail(mail);
	}

}
