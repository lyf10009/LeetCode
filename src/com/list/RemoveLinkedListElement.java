package com.list;

import com.bean.ListNode;


public class RemoveLinkedListElement {

	public static void main(String[] args) {
		ListNode list = ListNode.generateList(5);
		ListNode node = new ListNode(3);
		node.next=list;
		ListNode.printListNode(node);
		System.out.println("-------------");
		node=removeElements(node,3);
		ListNode.printListNode(node);
		System.out.println("-------------");

	}
	public static ListNode removeElements(ListNode head, int val) {
		ListNode cur = head;
		ListNode pre=null;
		
		while(cur!=null){
			if(cur.val == val){
				if(pre == null){
					head = head.next;
					cur = head;
					continue;
				}else{
					pre.next=cur.next;
				}
			}else{
				pre = cur;
			}
			cur = cur.next;
		}
        
		return head;
    }
}
