package programming;

import java.util.ArrayList;
import java.util.Stack;
/**
 * 输入一个链表，从尾到头打印链表每个节点的值
 * @author zhanyr
 */
public class ListPrint1 {
	public static void main(String[] args) {
		ListPrint1 listPrint = new ListPrint1();
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
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		//栈先进后出
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(null == listNode)
			return result;
		while(null != listNode.next){
			stack.add(listNode.val);
			listNode = listNode.next;
		}
		stack.add(listNode.val);
		while(!stack.isEmpty()){
			result.add(stack.pop());
		}
		return result;	
	}
	
}
class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}