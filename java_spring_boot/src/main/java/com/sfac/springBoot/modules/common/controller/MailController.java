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
	 * 127.0.0.1/api/simpleMail ---- post
	 * {"to":["898899721@qq.com"],"cc":["hujiangyx@163.com"],"subject":"SimpleMailSubject",
	 * "text":"SimpleMailContent"}
	 */
	@PostMapping(value = "/simpleMail", consumes = "application/json")
	public ResultEntity<Object> sendSimpleMail(@RequestBody Mail mail) {
		return mailService.sendSimpleMail(mail);
	}
	
	/**
	 * 127.0.0.1/api/complexMail ---- post
	 * {"to":["898899721@qq.com"],"cc":["hujiangyx@163.com"],"subject":"SimpleMailSubject",
	 * "text":"<html><head></head><body><h1>hello! Welcome thornBird!</h1><br><img src='cid:image-0'>
	 * </img><br><img src='cid:image-1'></img></body></html>","attachments":["E:/temp/attachments_1.txt",
	 * "E:/temp/attachments_2.txt"],"images":["E:/temp/QQ截图20190824190407.jpg","E:/temp/QQ截图20190824190855.jpg"],
	 * "imageCids":["image-0","image-1"]}
	 */
	@PostMapping(value = "/complexMail",consumes = "application/json")
	public ResultEntity<Object> sendComplexMail(@RequestBody Mail mail) {
		return mailService.sendComplexMail(mail);
	}
	
	/**
	 * 127.0.0.1/api/templateMail/wellCome ---- post
	 * {"to":["898899721@qq.com"],"cc":["hujiangyx@163.com"],"subject":"SimpleMailSubject",
	 * "text":"SimpleMailContent","templateMap":{"name":"HymanHu","id":"12345"},"templateId":"wellCome"}
	 */
	@PostMapping(value = "/templateMail/{templateId}",consumes = "application/json")
	public ResultEntity<Object> sendTemplateMail(Mail mail) {
		return mailService.sendTemplateMail(mail);
	}

}
