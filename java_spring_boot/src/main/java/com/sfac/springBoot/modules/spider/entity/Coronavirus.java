package com.sfac.springBoot.modules.spider.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * @Description: Coronavirus
 * @author: HymanHu
 * @date: 2021年6月3日
 */
@Entity
@Table(name = "spider_coronavirus")
public class Coronavirus extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private String date;
	private String region;
	private Integer diagnosis;
	private Integer overseasImport;
	private Integer cure;
	private Integer death;
	private Integer therapy;
	private Integer observation;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Integer diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Integer getOverseasImport() {
		return overseasImport;
	}

	public void setOverseasImport(Integer overseasImport) {
		this.overseasImport = overseasImport;
	}

	public Integer getCure() {
		return cure;
	}

	public void setCure(Integer cure) {
		this.cure = cure;
	}

	public Integer getDeath() {
		return death;
	}

	public void setDeath(Integer death) {
		this.death = death;
	}

	public Integer getTherapy() {
		return therapy;
	}

	public void setTherapy(Integer therapy) {
		this.therapy = therapy;
	}

	public Integer getObservation() {
		return observation;
	}

	public void setObservation(Integer observation) {
		this.observation = observation;
	}

}
