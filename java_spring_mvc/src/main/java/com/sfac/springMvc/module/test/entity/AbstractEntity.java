package com.sfac.springMvc.module.test.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Description: 抽象实体，将 id 和 createDate 抽取出来
 * 
 * @author HymanHu
 * @date 2021-01-13 13:44:42
 */
@MappedSuperclass
public class AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime createDate;
	
	// 在 insert 之前，该方法被调用
	@PrePersist
	public void preInsert() {
		setCreateDate(LocalDateTime.now());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
}
