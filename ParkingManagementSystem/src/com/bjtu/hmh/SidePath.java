package com.bjtu.hmh;

import java.io.Serializable;

/**
 * �����ʽ����
 * 
 * @author hmh
 * 
 */
public class SidePath implements Serializable {
	private static final long serialVersionUID = -6726728595616312615L;

	// ����һ���ڲ���
	private class Node {
		private Car car;// ����������Ϣ
		private Node next;// ָ���¸��ڵ������

		public Node() {

		}

		public Node(Car car, Node next) {
			this.next = next;
			this.car = car;
		}
	}

	private Node front;// ������е�ͷ���
	private Node rear;// ������е�β�ڵ�
	private int length;// �����������
	private int size=0;//��ʽ���е�ǰ����

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
	 * ���
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
	 * ����
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
	
	
	//���ض�βԪ��
	public Car getRear(){
		return rear.car;
	}
}
