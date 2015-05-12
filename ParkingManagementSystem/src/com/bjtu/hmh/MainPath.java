package com.bjtu.hmh;
/**
 * 主道栈
 * @author hmh
 *
 */
public class MainPath {
	private Car[] carArray;
	private int topOfStack = -1;
	private int sizeOfStack;
	private double feePerMin = 0.5;
	public double getFeePerMin() {
		return feePerMin;
	}

	public void setFeePerMin(double feePerMin) {
		this.feePerMin = feePerMin;
	}

	//构造方法
	public MainPath(int sizeOfStack){
		this.sizeOfStack = sizeOfStack;
		carArray = new Car[sizeOfStack];
		//topOfStack = -1;
	}
	
	public boolean IsEmpty(){
		return topOfStack == -1;
	}
	public Car[] getCarArray() {
		return carArray;
	}

	public void setCarArray(Car[] carArray) {
		this.carArray = carArray;
	}

	public int getTopOfStack() {
		return topOfStack;
	}

	public void setTopOfStack(int topOfStack) {
		this.topOfStack = topOfStack;
	}

	public int getSizeOfStack() {
		return sizeOfStack;
	}

	public void setSizeOfStack(int sizeOfStack) {
		this.sizeOfStack = sizeOfStack;
	}

	public boolean IsFull(){
		return topOfStack == sizeOfStack-1;
	}
	
	//汽车入栈
	public void push(Car car){
		if(!IsFull()){
			topOfStack++;
			carArray[topOfStack]=car;
		}
	}
	//获取栈顶汽车
	public Car getTop(){
		if(IsEmpty()){
			return null;		
		}else{
			return carArray[topOfStack];
		}
	}
	
	//汽车出栈
	public void pop(){
		if(!IsEmpty()){
			carArray[topOfStack]=null;
			topOfStack--;
		}
	}
}
