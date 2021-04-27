package com.sfac.springBoot.modules.common.service.impl;

import java.io.File;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.sfac.springBoot.modules.common.entity.Mail;
import com.sfac.springBoot.modules.common.entity.ResultEntity;
import com.sfac.springBoot.modules.common.entity.ResultEntity.ResultStatus;
import com.sfac.springBoot.modules.common.service.MailService;

/**
 * Description: Mail Service Impl
 * @author HymanHu
 * @date 2021-04-27 15:42:19
 */
@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private TemplateEngine templateEngine;
	@Value("${spring.mail.username}")
	private String from;

	@Override
	public ResultEntity<Object> sendSimpleMail(Mail mail) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom(from);
		smm.setTo(mail.getTo());
		smm.setBcc(mail.getBcc());
		smm.setCc(mail.getCc());
		smm.setReplyTo(mail.getReplyTo());
		smm.setSubject(mail.getSubject());
		smm.setText(mail.getText());
		smm.setSentDate(new Date());
		javaMailSender.send(smm);
		
		return new ResultEntity<Object>(ResultStatus.SUCCESS.status, "Send success.");
	}

	@Override
	public ResultEntity<Object> sendComplexMail(Mail mail) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(mimeMessage, true);
			// build base info
			helper.setFrom(from);
			helper.setTo(mail.getTo());
			helper.setBcc(mail.getBcc());
			helper.setCc(mail.getCc());
			helper.setReplyTo(mail.getReplyTo());
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getText());
			helper.setSentDate(new Date());
			
			// build attachments
			if (null != mail.getAttachments() && mail.getAttachments().length > 0) {
				for (String attachment : mail.getAttachments()) {
					if (StringUtils.isNotBlank(attachment)) {
						FileSystemResource attachmentFile = new FileSystemResource(new File(attachment));
						helper.addAttachment(attachmentFile.getFilename(), attachmentFile);
					}
				}
			}
			
			// build images
			if (null != mail.getImages() && mail.getImages().length > 0) {
				for (int i = 0; i < mail.getImages().length; i++) {
					String imagePath = mail.getImages()[i];
					FileSystemResource imageFile = new FileSystemResource(new File(imagePath));
					String imageCid = null;
					if (null != mail.getImageCids() && mail.getImageCids().length > mail.getImages().length) {
						imageCid = mail.getImageCids()[i];
					}
					helper.addInline(StringUtils.isNotBlank(imageCid) ? imageCid : String.format("%s%d", "image-", i), 
						imageFile);
				}
			}
			
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
			return new ResultEntity<Object>(ResultStatus.FAILED.status, "Send failed.");
		}
		
		return new ResultEntity<Object>(ResultStatus.SUCCESS.status, "Send success.");
		
	}

	@Override
	public ResultEntity<Object> sendTemplateMail(Mail mail) {
		Context context = new Context();
		mail.getTemplateMap().entrySet().stream().forEach(item -> {
			context.setVariable(item.getKey(), item.getValue());
		});
		String emailContent = templateEngine.process("mail/" + mail.getTemplateId(), context);
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(from);
			helper.setTo(mail.getTo());
			helper.setBcc(mail.getBcc());
			helper.setCc(mail.getCc());
			helper.setReplyTo(mail.getReplyTo());
			helper.setSubject(mail.getSubject());
			helper.setText(emailContent, true);
			helper.setSentDate(new Date());
			
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
			return new ResultEntity<Object>(ResultStatus.FAILED.status, "Send failed.");
		}
		
		return new ResultEntity<Object>(ResultStatus.SUCCESS.status, "Send success.");
	}
}
