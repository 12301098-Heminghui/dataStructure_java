package com.bjtu.hmh;

public class TempStack {
	private Car[] carTemp;
	private int topOfStack;
	private int size;
	
	public TempStack(int size){
		this.size = size;
		carTemp = new Car[size];
	}
	
	
	public Car[] getCarTemp() {
		return carTemp;
	}


	public void setCarTemp(Car[] carTemp) {
		this.carTemp = carTemp;
	}


	public int getTopOfStack() {
		return topOfStack;
	}


	public void setTopOfStack(int topOfStack) {
		this.topOfStack = topOfStack;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public boolean IsEmpty(){
		return topOfStack == -1;
	}
	public boolean IsFull(){
		return topOfStack == carTemp.length-1;
	}
	
	public Car getTop(){
		if(!IsEmpty()){
			return carTemp[topOfStack];
		}else{
			return null;
		}
	}
	
	//»Î’ª
	public void push(Car car){
		if(!IsFull()){
			topOfStack ++;
			carTemp[topOfStack]=car;
		}
	}
	
	//≥ˆ’ª
	public void pop(){
		if(!IsEmpty()){
			carTemp[topOfStack] = null;
			topOfStack--;
		}
	}
}
