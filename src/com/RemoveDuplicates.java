package com;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {

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
//		l5.next=l6;
		printListNode(l1);
		ListNode res=deleteDuplicates(l1);
		printListNode(res);
	}
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res=new ListNode(0);
        ListNode cur=res;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        while(head!=null){
            int val=head.val;
            if(map.get(val)==null){
                cur.next=new ListNode(head.val);
                
                cur=cur.next;
                map.put(val,1);
            }
            head=head.next;  
        }
        return res.next;
//        if(head==null) return null;
//        ListNode res=new ListNode(head.val);
//        ListNode cur=res;
//        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
//        map.put(head.val,1);
//        head=head.next;
//        while(head!=null){
//        	int val=head.val;
//        	if(map.get(val)==null){
//        		cur.next=new ListNode(head.val);
//        		
//        		cur=cur.next;
//        		map.put(val,1);
//        	}
//        	head=head.next;  
//        }
//        return res;
    }
	public static void printListNode(ListNode l1){
		if(l1==null) return;
		for(;;){
			System.out.print(l1.val+"-->");
			l1=l1.next;
			if(l1 == null) break;
		}
		System.out.println();
	}
}
