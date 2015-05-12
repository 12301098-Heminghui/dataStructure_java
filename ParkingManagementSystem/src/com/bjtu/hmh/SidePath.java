package com.bjtu.hmh;

import java.io.Serializable;

/**
 * 便道链式队列
 * 
 * @author hmh
 * 
 */
public class SidePath implements Serializable {
	private static final long serialVersionUID = -6726728595616312615L;

	// 定义一个内部类
	private class Node {
		private Car car;// 保存汽车信息
		private Node next;// 指向下个节点的引用

		public Node() {

		}

		public Node(Car car, Node next) {
			this.next = next;
			this.car = car;
		}
	}

	private Node front;// 保存队列的头结点
	private Node rear;// 保存队列的尾节点
	private int length;// 队列最大容量
	private int size=0;//链式队列当前长度

	public SidePath(int length) {
		front = null;
		rear = null;
		this.length = length;
	}

	/*public SidePath(Car car) {
		front = new Node(car, null);
		size++;
	}
*/
	public int getSize() {
		return size;
	}
	
	public boolean IsEmpty(){
		return size==0;
	}
	public boolean IsFull(){
		return size==length;
	}

	/**
	 * 入队
	 */
	public void insert(Car car) {
		if (front == null) {
			front = new Node(car, null);
			rear = front;
		} else {
			Node newNode = new Node(car, null);
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}

	/**
	 * 出队
	 */
	public Car delete() {
		if (size > 0) {
			Node oldNode = front;
			front = front.next;
			oldNode.next = null;
			size--;
			return oldNode.car;
		} else {
			return null;
		}
	}
	
	
	//返回队尾元素
	public Car getRear(){
		return rear.car;
	}
}
