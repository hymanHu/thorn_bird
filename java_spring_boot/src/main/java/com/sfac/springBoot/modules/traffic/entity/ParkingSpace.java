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
	private int status; // 0：空闲，1: 已停，2：停用

	public String getParkingSpaceType() {
		return parkingSpaceType;
	}

	public void setParkingSpaceType(String parkingSpaceType) {
		this.parkingSpaceType = parkingSpaceType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @Description: Parking Space Type
	 * @author: HymanHu
	 * @date: 2021年3月21日
	 */
	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum ParkingSpaceType {
		MINI_PARK("mini", "微型停车位", 4, 2, 5, 1),
		STANDARD_PARK("standard", "标准停车位", 5.3, 2.5, 5, 1.5),
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
	
	/**
	 * @Description: Parking Space Status
	 * @author: HymanHu
	 * @date: 2021年3月21日
	 */
	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum ParkingSpaceStatus {
		IDLE(0, "空闲"),
		USED(1, "已用"),
		OUT_SERVICE(2, "停用"),
		;
		
		public int status;
		public String desc;
		
		private ParkingSpaceStatus(int status, String desc) {
			this.status = status;
			this.desc = desc;
		}
	}
}
