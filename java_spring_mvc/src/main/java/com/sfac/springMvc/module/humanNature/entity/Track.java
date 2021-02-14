package com.sfac.springMvc.module.humanNature.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.sfac.springMvc.module.common.entity.AbstractEntity;

/**
 * @Description: Track
 * @author: HymanHu
 * @date: 2021年2月8日
 */
@Entity
@Table(name = "hn_track")
public class Track extends AbstractEntity {

	private String target;
	private String description;
	private String type;
	private double assessment;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime dateTime;

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAssessment() {
		return assessment;
	}

	public void setAssessment(double assessment) {
		this.assessment = assessment;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
