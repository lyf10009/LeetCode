package com.bean;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
    public static void printListNode(ListNode listNode){
        while(listNode!=null){
            System.out.print(listNode.val);
            listNode=listNode.next;
            if(listNode!=null){
            	System.out.print("-->");
            }
        }
        System.out.println();
    }
    public static ListNode generateList(int length){
    	if(length<1) return null;
    	ListNode head = new ListNode(1);
    	ListNode cur = head;
    	for(int i=2;i<=length;i++){
    		ListNode tmp = new ListNode(i);
    		cur.next=tmp;
    		cur=tmp;
    	}
    	return head;
    }
}
