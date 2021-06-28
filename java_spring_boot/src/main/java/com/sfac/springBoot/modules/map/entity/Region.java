package com.sfac.springBoot.modules.map.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * Description: Region
 * 
 * @author HymanHu
 * @date 2021-06-28 09:00:59
 */
@Entity
@Table(name = "map_Region")
public class Region extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	// 接口返回该字段类型不定：[] 或 ""，故以 Object 来装载
	@Transient
	private Object citycode;
	private String cityCode;
	// 接口返回该字段名全小写，重新定义
	@JsonProperty("adcode")
	private String adCode;
	private String name;
	private String center;
	private String level;
	private String area;
	private String perimeter;
	@Transient
	private List<Region> districts;

	public Object getCitycode() {
		return citycode;
	}

	public void setCitycode(Object citycode) {
		this.citycode = citycode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAdCode() {
		return adCode;
	}

	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(String perimeter) {
		this.perimeter = perimeter;
	}

	public List<Region> getDistricts() {
		return districts;
	}

	public void setDistricts(List<Region> districts) {
		this.districts = districts;
	}

}
