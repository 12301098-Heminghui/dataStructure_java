package com.bjtu.hmh;

/**
 * 单向循环链表
 * 
 * @author hmh
 * 
 */
public class LinkList {
	private PlayerNode head;
	private PlayerNode rear;

	public LinkList() {
		head = null;
	}

	// playerNode数组存储的是每个玩家持有的密码
	public LinkList(int[] playerNode) {
		if (playerNode.length == 0) {
			head = null;
		} else {
			// 首先创建一个头节点
			int i = 0;
			head = new PlayerNode(playerNode[i], i + 1);
			rear = head;
			head.setNext(rear);
			PlayerNode temp;//指向新插入的节点
			while (i < playerNode.length - 1) {
				i++;
				temp = new PlayerNode(playerNode[i], i + 1);
				rear.setNext(temp);
				temp.setNext(head);
				rear = temp;
			}
		}
	}

	/**
	 * 
	 * @param begin
	 *            计数起点
	 * @param num
	 *            报数为num的人
	 *            从begin这个玩家开始，每次报到num的人出列
	 *            接着下一轮游戏从报num的下一个开始重新从1报数
	 */
	public void beginGame(int begin, int num) {
		// int count = 0;
		PlayerNode node = head;
		// 找到计数起点 node 指向游戏开始的那个人
		/*
		 * while(count<begin-1){ count++; node = node.getNext(); }
		 */
		//找到报1的玩家
		if (begin != head.getIdentifier()) {
			do {
				node = node.getNext();
			} while (node.getIdentifier() != begin);
		}
		
		//再找报num的上一个玩家
		if (node.getNext() != node) {
			int j = 1;// 从1开始报数
			// 找到报m的前一个
			if(num == 1){
				PlayerNode flag = node;//循环找到被删除节点的前一个节点
				do{
					node = node.getNext();
				}while(node.getIdentifier()== flag.getIdentifier());//考虑删除报数为1的情况
			}else{
			while (j < num-1) {
				j++;
					node = node.getNext();
				}
			}
			System.out.println("被删除节点的前一个节点的密码" + node.getPassword());
			num = node.getNext().getPassword();
			begin = delete(node);// 下一个开始节点
			beginGame(begin, num);
		}else{
			System.out.println("只有一个玩家了");
			System.out.println(node.getIdentifier() + ",");
		}
	}
/**
 * 链表的删除操作
 * @param node
 * @return
 */
	public int delete(PlayerNode node) {
		PlayerNode p = node.getNext();
		int num = p.getPassword();
		System.out.println(p.getIdentifier());
		if (p == head) {
			head = p.getNext();
		}
		node.setNext(p.getNext());
		return p.getNext().getIdentifier();
	}

	public static void main(String[] args) {
		int[] playerNode = { 3, 1, 7, 2, 4, 8, 4 };
		int num = 20;
		int begin = 2;
		LinkList list = new LinkList(playerNode);
		list.beginGame(begin, num);
	}

}
