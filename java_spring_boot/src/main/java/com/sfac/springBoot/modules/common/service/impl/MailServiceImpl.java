package com.sfac.springBoot.modules.common.service.impl;

import java.io.File;
import java.util.Arrays;
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

import com.sfac.springBoot.modules.common.entity.Mail;
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
	@Value("${spring.mail.username}")
	private String from;

	@Override
	public void sendSimpleMail(Mail mail) {
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
	}

	@Override
	public void sendComplexMail(Mail mail) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
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
		}
		
	}

	@Override
	public void sendTemplateMail(Mail mail) {
		// TODO Auto-generated method stub
	}
}
