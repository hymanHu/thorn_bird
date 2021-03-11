package com.sfac.springBoot.modules.traffic.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sfac.springBoot.modules.common.entity.AbstractEntity;

/**
 * Description: Parking
 * @author HymanHu
 * @date 2021-03-11 15:50:13
 */
@Entity
@Table(name = "traffic_parking_space")
public class ParkingSpace extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private String parkingSpaceType;

	public String getParkingSpaceType() {
		return parkingSpaceType;
	}

	public void setParkingSpaceType(String parkingSpaceType) {
		this.parkingSpaceType = parkingSpaceType;
	}

	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum ParkingSpaceType {
		MINI_PARK("mini", "微型停车位", 4, 2, 5, 1),
		STANDARD_PARK("standard", "微型停车位", 5.3, 2.5, 5, 1.5),
		LARGE_PARK("large", "大型停车位", 8, 3, 5, 2),
		;

		public String name;
		public String desc;
		public double length;
		public double width;
		public double headFourHoursPrice; // 临停头四小时价格
		public double preHourPrice; // 临停四小时后每小时价格

		private ParkingSpaceType(String name, String desc, double length, double width,
				double headFourHoursPrice, double preHourPrice) {
			this.name = name;
			this.desc = desc;
			this.length = length;
			this.width = width;
			this.headFourHoursPrice = headFourHoursPrice;
			this.preHourPrice = preHourPrice;
		}
		
		public static ParkingSpaceType getParkingSpaceTypeByName(String name) {
			return Arrays.asList(ParkingSpaceType.values())
					.stream()
					.filter(item -> item.name.equals(name))
					.findFirst()
					.orElse(null);
		}

	}
}
