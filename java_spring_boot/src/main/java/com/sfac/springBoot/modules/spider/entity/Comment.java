package com.sfac.springBoot.modules.spider.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * Description: Comment
 * @author HymanHu
 * @date 2021-06-23 13:56:34
 */
@Entity
@Table(name = "spider_comment")
public class Comment extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private String productId;
	@Column(columnDefinition="text")
	private String content;
	private String tripStartDate;
	private String userName;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTripStartDate() {
		return tripStartDate;
	}

	public void setTripStartDate(String tripStartDate) {
		this.tripStartDate = tripStartDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
