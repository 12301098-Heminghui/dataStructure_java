package com.bjtu.hmh;

import java.util.Date;

/**
 * �����ࣨ������ȥ��Ϣ�����ƺţ�ʱ�䣩
 * @author hmh
 *
 */
public class Car {
	private String carNumber;
	private String state;//��������뿪��A-Arrival.D-Departure��
	private int date;//��������뿪��ʱ��
	
	//���췽��
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
