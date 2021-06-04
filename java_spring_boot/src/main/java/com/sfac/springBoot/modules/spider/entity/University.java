package com.sfac.springBoot.modules.spider.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * @Description: University
 * @author: HymanHu
 * @date: 2021年6月3日
 */
@Entity
@Table(name = "spider_university")
public class University extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private String type;
	private String level;
	private String nature;
	private String belong;
	private int central;
	private int department;
	private int doublehigh;
	private int f211;
	private int f985;
	private int isRecruitment;
	private String dualClass;
	private String address;
	private String provinceName;
	private String singleProvince;
	private String cityName;
	private String countyName;
	private long viewTotalNumber;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public int getCentral() {
		return central;
	}

	public void setCentral(int central) {
		this.central = central;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getDoublehigh() {
		return doublehigh;
	}

	public void setDoublehigh(int doublehigh) {
		this.doublehigh = doublehigh;
	}

	public int getF211() {
		return f211;
	}

	public void setF211(int f211) {
		this.f211 = f211;
	}

	public int getF985() {
		return f985;
	}

	public void setF985(int f985) {
		this.f985 = f985;
	}

	public int getIsRecruitment() {
		return isRecruitment;
	}

	public void setIsRecruitment(int isRecruitment) {
		this.isRecruitment = isRecruitment;
	}

	public String getDualClass() {
		return dualClass;
	}

	public void setDualClass(String dualClass) {
		this.dualClass = dualClass;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getSingleProvince() {
		return singleProvince;
	}

	public void setSingleProvince(String singleProvince) {
		this.singleProvince = singleProvince;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public long getViewTotalNumber() {
		return viewTotalNumber;
	}

	public void setViewTotalNumber(long viewTotalNumber) {
		this.viewTotalNumber = viewTotalNumber;
	}

}
