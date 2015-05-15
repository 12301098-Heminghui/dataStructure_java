package com.bjtu.hmh;

/**
 * ����ѭ������
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

	// playerNode����洢����ÿ����ҳ��е�����
	public LinkList(int[] playerNode) {
		if (playerNode.length == 0) {
			head = null;
		} else {
			// ���ȴ���һ��ͷ�ڵ�
			int i = 0;
			head = new PlayerNode(playerNode[i], i + 1);
			rear = head;
			head.setNext(rear);
			PlayerNode temp;//ָ���²���Ľڵ�
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
	 *            �������
	 * @param num
	 *            ����Ϊnum����
	 *            ��begin�����ҿ�ʼ��ÿ�α���num���˳���
	 *            ������һ����Ϸ�ӱ�num����һ����ʼ���´�1����
	 */
	public void beginGame(int begin, int num) {
		// int count = 0;
		PlayerNode node = head;
		// �ҵ�������� node ָ����Ϸ��ʼ���Ǹ���
		/*
		 * while(count<begin-1){ count++; node = node.getNext(); }
		 */
		//�ҵ���1�����
		if (begin != head.getIdentifier()) {
			do {
				node = node.getNext();
			} while (node.getIdentifier() != begin);
		}
		
		//���ұ�num����һ�����
		if (node.getNext() != node) {
			int j = 1;// ��1��ʼ����
			// �ҵ���m��ǰһ��
			if(num == 1){
				PlayerNode flag = node;//ѭ���ҵ���ɾ���ڵ��ǰһ���ڵ�
				do{
					node = node.getNext();
				}while(node.getIdentifier()== flag.getIdentifier());//����ɾ������Ϊ1�����
			}else{
			while (j < num-1) {
				j++;
					node = node.getNext();
				}
			}
			System.out.println("��ɾ���ڵ��ǰһ���ڵ������" + node.getPassword());
			num = node.getNext().getPassword();
			begin = delete(node);// ��һ����ʼ�ڵ�
			beginGame(begin, num);
		}else{
			System.out.println("ֻ��һ�������");
			System.out.println(node.getIdentifier() + ",");
		}
	}
/**
 * �����ɾ������
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
