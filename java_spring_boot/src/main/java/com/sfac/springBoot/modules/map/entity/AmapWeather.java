package com.sfac.springBoot.modules.map.entity;

import java.util.List;

/**
 * Description: Amap Weather
 * @author HymanHu
 * @date 2021-06-29 10:19:47
 */
public class AmapWeather {

	private int status;
	private int count;
	private String info;
	private String infocode;
	private List<Weather> lives;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfocode() {
		return infocode;
	}

	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}

	public List<Weather> getLives() {
		return lives;
	}

	public void setLives(List<Weather> lives) {
		this.lives = lives;
	}

}
