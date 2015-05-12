package com.bjtu.hmh;

import java.util.Date;

/**
 * 汽车类（到达离去信息，车牌号，时间）
 * @author hmh
 *
 */
public class Car {
	private String carNumber;
	private String state;//到达或者离开（A-Arrival.D-Departure）
	private int date;//到达或者离开的时间
	
	//构造方法
	public Car(String carNumber){
		this.carNumber = carNumber;
	}
	
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}
	
}
