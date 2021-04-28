package com.sfac.springBoot.modules.common.service.impl;

import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
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
		if (mail.getCc() != null) {
			smm.setCc(mail.getCc());
		}
		if (mail.getBcc() != null) {
			smm.setBcc(mail.getBcc());
		}
		if (StringUtils.isNotBlank(mail.getReplyTo())) {
			smm.setReplyTo(mail.getReplyTo());
		}
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
			if (mail.getCc() != null) {
				helper.setCc(mail.getCc());
			}
			if (mail.getBcc() != null) {
				helper.setBcc(mail.getBcc());
			}
			if (StringUtils.isNotBlank(mail.getReplyTo())) {
				helper.setReplyTo(mail.getReplyTo());
			}
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getText());
			helper.setSentDate(new Date());
			
			// build attachments
			if (null != mail.getAttachments()) {
				for (String attachment : mail.getAttachments()) {
					Resource resource = new UrlResource(Paths.get(attachment).toUri());
					helper.addAttachment(resource.getFilename(), resource);
				}
			}
			
			// build images
			if (null != mail.getImages()) {
				for (int i = 0; i < mail.getImages().length; i++) {
					Resource resource = new UrlResource(Paths.get(mail.getImages()[i]).toUri());
					helper.addInline(String.format("%s%d", "image-", i), resource);
				}
			}
			
			javaMailSender.send(mimeMessage);
		} catch (MessagingException | MalformedURLException e) {
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
			if (mail.getCc() != null) {
				helper.setCc(mail.getCc());
			}
			if (mail.getBcc() != null) {
				helper.setBcc(mail.getBcc());
			}
			if (StringUtils.isNotBlank(mail.getReplyTo())) {
				helper.setReplyTo(mail.getReplyTo());
			}
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
