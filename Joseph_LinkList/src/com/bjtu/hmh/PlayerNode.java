package com.bjtu.hmh;
/**
 * ��ÿ����ҿ���һ���ڵ㣬
 * ������г��е�����Ϊ������
 * ָ����ָ����һ���ڵ�
 * @author hmh
 *
 */
public class PlayerNode {
	private int password;//������
	private int identifier = 0;
	private PlayerNode next;//ָ����
	


	/**
	 * ���췽��
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
