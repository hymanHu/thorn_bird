package com.sfac.springBoot.modules.map.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description: Amap Region
 * @author HymanHu
 * @date 2021-06-28 09:24:31
 */
public class AmapRegion {

	private int status;
	private String info;
	@JsonProperty("infocode")
	private String infoCode;
	private int count;
	private List<Region> districts;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfoCode() {
		return infoCode;
	}

	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Region> getDistricts() {
		return districts;
	}

	public void setDistricts(List<Region> districts) {
		this.districts = districts;
	}

}
