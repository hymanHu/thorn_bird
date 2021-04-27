package com.sfac.springBoot.modules.common.service;

import com.sfac.springBoot.modules.common.entity.Mail;

/**
 * Description: Mail Service
 * @author HymanHu
 * @date 2021-04-27 15:40:30
 */
public interface MailService {
	
	void sendSimpleMail(Mail mail);
	
	void sendComplexMail(Mail mail);
	
	void sendTemplateMail(Mail mail);
}
