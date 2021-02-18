package com.sfac.springBoot.modules.test.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sfac.springBoot.modules.common.entity.AbstractEntity;


/**
 * Description: School
 * @author HymanHu
 * @date 2021-01-13 10:03:43
 */
@Entity
@Table(name = "test_school")
public class School extends AbstractEntity {
	private String schoolName;
	@Transient
	private String region;
    
	/**
	 * OneToMany：多方使用 joinClumn，创建外键，一方使用 mappedBy 属性
	 * cascade：联级操作
	 * fetch：加载数据策略
	*/
	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Clazz> clazzes;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<Clazz> getClazzes() {
		return clazzes;
	}

	public void setClazzes(List<Clazz> clazzes) {
		this.clazzes = clazzes;
	}
}
