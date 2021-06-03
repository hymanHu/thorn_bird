package com.sfac.springBoot.modules.spider.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * @Description:
 * @author: HymanHu
 * @date: 2021年6月3日
 */
@Entity
@Table(name = "spider_news")
public class News extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private String title;
	private String digest; // 摘要
	private String url;
	private long viewCount;
	private String label;
	private String keywords;
	private LocalDateTime newsDate;
	private String type;
	private String channel; // 渠道
	private String source; // 来源
	private String imageUrl;
	@Column(columnDefinition="text")
	private String detail;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getViewCount() {
		return viewCount;
	}

	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public LocalDateTime getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(LocalDateTime newsDate) {
		this.newsDate = newsDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
