package programming;

import java.util.ArrayList;
import java.util.List;
/**
 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 * @author zhanyr
 */
public class ListPrint {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		List<Integer> list = new ArrayList<Integer>();
		if(null == listNode)
			return null;
		//��listNode�������list
		while (null != listNode.next) {
			list.add(listNode.val);
			listNode = listNode.next;
		}
		list.add(listNode.val);
		//����
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = list.size()-1; i >= 0 ;i--){
			result.add(list.get(i));
		}
		return result;
	}
	
	public static void main(String[] args) {
		ListPrint listPrint = new ListPrint();
		ListNode listNode0 = new ListNode(58);
		listNode0.next = null;
		ListNode listNode1 = new ListNode(24);
		listNode1.next = listNode0;
		ListNode listNode2 = new ListNode(0);
		listNode2.next = listNode1;
		ListNode listNode = new ListNode(64);
		listNode.next = listNode2;
		listPrint.printListFromTailToHead(listNode);
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

