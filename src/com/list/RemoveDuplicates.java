package com.list;

import java.util.HashMap;
import java.util.Map;
import com.bean.ListNode;

public class RemoveDuplicates {
    /**
     * 去除有序链表中重复的节点
     * For example,
     * Given 1->1->2, return 1->2.
     * Given 1->1->2->3->3, return 1->2->3.
     */
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(1);
		ListNode l3=new ListNode(2);
		ListNode l4=new ListNode(3);
		ListNode l5=new ListNode(3);
		ListNode l6=new ListNode(4);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		ListNode.printListNode(l1);
		ListNode res=deleteDuplicates(l1);
		ListNode.printListNode(res);
	}
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res=new ListNode(0);
        ListNode position=res,cur=head;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();//使用map记录已有的数字
        while(cur!=null){
            int val=cur.val;
            if(map.get(val)==null){
                position.next=new ListNode(cur.val);
                position=position.next;
                map.put(val,1);
            }
            cur=cur.next;  
        }
        return res.next;
    }
}
