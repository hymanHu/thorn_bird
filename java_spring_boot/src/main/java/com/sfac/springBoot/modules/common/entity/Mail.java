package com.sfac.springBoot.modules.common.entity;

import java.util.Map;

/**
 * @Description: Mail
 * @author: HymanHu
 * @date: 2021年4月26日
 */
public class Mail {
	private String from;
	private String[] to;
	// 抄送
	private String[] cc;
	// 暗抄送
	private String[] bcc;
	private String replyTo;
	private String subject;
	private String text;
	// 附件地址
	private String[] attachments;
	// 图片地址
	private String[] images;
	// 图片对应的 id 数组，在 HTML 模版中对应 <img src='cid:image-0'></img>
	private String[] imageCids;
	private String templateId;
	// 模版参数
	private Map<String, String> templateMap;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String[] getBcc() {
		return bcc;
	}

	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String[] getAttachments() {
		return attachments;
	}

	public void setAttachments(String[] attachments) {
		this.attachments = attachments;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public String[] getImageCids() {
		return imageCids;
	}

	public void setImageCids(String[] imageCids) {
		this.imageCids = imageCids;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public Map<String, String> getTemplateMap() {
		return templateMap;
	}

	public void setTemplateMap(Map<String, String> templateMap) {
		this.templateMap = templateMap;
	}
}
