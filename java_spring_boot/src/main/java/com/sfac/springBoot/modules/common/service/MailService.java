package com.sfac.springBoot.modules.common.service;

import com.sfac.springBoot.modules.common.entity.Mail;
import com.sfac.springBoot.modules.common.entity.ResultEntity;

/**
 * Description: Mail Service
 * @author HymanHu
 * @date 2021-04-27 15:40:30
 */
public interface MailService {
	
	ResultEntity<Object> sendSimpleMail(Mail mail);
	
	ResultEntity<Object> sendComplexMail(Mail mail);
	
	ResultEntity<Object> sendTemplateMail(Mail mail);
}
