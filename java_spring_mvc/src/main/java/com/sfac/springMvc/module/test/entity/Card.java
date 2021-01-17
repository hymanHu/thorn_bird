package com.sfac.springMvc.module.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Description: Card
 * @author HymanHu
 * @date 2021-01-13 09:57:47
 */
@Entity
@Table(name = "test_card")
public class Card extends AbstractEntity {
	@Column(name = "card_no", length = 33, unique = true)
	private String cardNo;
	
	/**
	 * OneToOne：一对一关系中，有外键方使用 JoinColumn 注解，另一方使用 mappedBy 属性（可选）
	 * cascade：联级操作
	 * fetch：加载数据策略
	 * JsonIgnore：不序列化该字段，避免无限递归
	*/
	@OneToOne(mappedBy = "studentCard", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Student student;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
