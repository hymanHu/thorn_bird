package com.sfac.springMvc.module.test.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Description: Student
 * @author HymanHu
 * @date 2021-01-13 10:00:38
 */
@Entity
@Table(name = "test_student")
public class Student extends AbstractEntity {
	private String studentName;
	
	/**
	 * OneToOne：一对一关系中，有外键方使用 JoinColumn 注解，另一方使用 mappedBy 属性（可选）
	 * targetEntity：目标实体
	 * cascade：联级操作
	 * fetch：加载数据策略
	 * JoinColumn
	 * name 对应 test_student 表中 card_id 外键列
	*/
	@OneToOne(targetEntity = Card.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "card_id", unique = true)
	private Card studentCard;
    
	/**
	 * ManyToMany，一方使用 JoinTable 注解，另一方配置 mappedBy 属性
	 * cascade：联级操作
	 * fetch：加载数据策略
	 * JsonIgnore：不序列化该字段，避免无限递归
	*/
	@ManyToMany(mappedBy = "students", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Clazz> clazzes;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Card getStudentCard() {
		return studentCard;
	}

	public void setStudentCard(Card studentCard) {
		this.studentCard = studentCard;
	}

	public List<Clazz> getClazzes() {
		return clazzes;
	}

	public void setClazzes(List<Clazz> clazzes) {
		this.clazzes = clazzes;
	}
}
