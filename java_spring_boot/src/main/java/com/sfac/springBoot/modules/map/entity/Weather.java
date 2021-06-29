package com.sfac.springBoot.modules.map.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * Description: Weather
 * 
 * @author HymanHu
 * @date 2021-06-29 09:56:04
 */
@Entity
@Table(name = "map_weather")
public class Weather extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String province;
	private String city;
	@JsonProperty("adcode")
	private String adCode;
	@JsonProperty("weather")
	private String meteorology; // 气象状态，阴到小雨，可能有雪
	private String temperature; // 温度
	@JsonProperty("winddirection")
	private String windDirection; // 风向
	@JsonProperty("windpower")
	private String windPower; // 风力级别
	private String humidity; // 湿度
	@JsonProperty("reporttime")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime reportTime;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdCode() {
		return adCode;
	}

	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}

	public String getMeteorology() {
		return meteorology;
	}

	public void setMeteorology(String meteorology) {
		this.meteorology = meteorology;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getWindPower() {
		return windPower;
	}

	public void setWindPower(String windPower) {
		this.windPower = windPower;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public LocalDateTime getReportTime() {
		return reportTime;
	}

	public void setReportTime(LocalDateTime reportTime) {
		this.reportTime = reportTime;
	}
}
