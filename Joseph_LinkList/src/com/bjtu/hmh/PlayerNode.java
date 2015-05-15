package com.bjtu.hmh;
/**
 * 把每个玩家看做一个节点，
 * 玩家手中持有的密码为数据域，
 * 指针域指向另一个节点
 * @author hmh
 *
 */
public class PlayerNode {
	private int password;//数据域
	private int identifier = 0;
	private PlayerNode next;//指针域
	


	/**
	 * 构造方法
	 */
	public PlayerNode(int password,int identifier){
		this.password = password;
		this.identifier = identifier;
		next = null;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
	
	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	public PlayerNode getNext() {
		return next;
	}

	public void setNext(PlayerNode next) {
		this.next = next;
	}

}
