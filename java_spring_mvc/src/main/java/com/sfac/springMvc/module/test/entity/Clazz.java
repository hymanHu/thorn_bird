package com.sfac.springMvc.module.test.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Description: Clazz
 * @author HymanHu
 * @date 2021-01-13 10:02:35
 */
@Entity
@Table(name = "test_clazz")
public class Clazz {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clazzId;
    private String schoolName;
    
    /**
     * ManyToMany，一方使用 JoinTable 注解，另一方配置 mappedBy 属性
     * cascade：联级操作
     * fetch：加载数据策略
     * JoinTable：中间表
     * name： 中间表表名
     * joinColumns：表 test_clazz 参与中间表的主键
     * inverseJoinColumns：关联表 test_student 参与中间表的主键
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "test_clazz_student",
            joinColumns = @JoinColumn(name = "clazz_id"),
            inverseJoinColumns = @JoinColumn(name="student_id"))
    private List<Student> students;
    
    /**
     * ManyToOne：多方使用 joinClumn，创建外键，一方使用 mappedBy 属性
     * cascade：联级操作
     * fetch：加载数据策略
     * JoinColumn
     * name：多方 test_clazz 表的外键 school_id
     * insertable & updatable：标识该属性是否参与插入和更新插入
     * JsonIgnore：不序列化该字段，避免无限递归
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id", insertable = false, updatable = false)
    @JsonIgnore
    private School school;

	public int getClazzId() {
		return clazzId;
	}

	public void setClazzId(int clazzId) {
		this.clazzId = clazzId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
}
