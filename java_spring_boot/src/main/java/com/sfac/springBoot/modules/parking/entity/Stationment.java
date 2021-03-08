package com.sfac.springBoot.modules.parking.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * Description: Stationment ---- 停车位
 * @author HymanHu
 * @date 2021-03-08 16:44:50
 */
@Entity
@Table(name = "parking_stationment")
public class Stationment extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private String type; // 车位类型
	private double priceHeadFourHours; // 临停头四小时价格
	private double pricePreHour; // 临停四小时后每小时价格
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPriceHeadFourHours() {
		return priceHeadFourHours;
	}

	public void setPriceHeadFourHours(double priceHeadFourHours) {
		this.priceHeadFourHours = priceHeadFourHours;
	}

	public double getPricePreHour() {
		return pricePreHour;
	}

	public void setPricePreHour(double pricePreHour) {
		this.pricePreHour = pricePreHour;
	}

	public enum StationmentType {
		BIG_STATIONMENT("big"), 
		MIDDLE_STATIONMENT("middle"),
		SMALL_STATIONMENT("small");
		
		public String name;

		private StationmentType(String name) {
			this.name = name;
		}
		
	}

}
