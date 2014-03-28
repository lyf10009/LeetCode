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
            System.out.print(listNode.val+"-->");
            listNode=listNode.next;
        }
        System.out.println();
    }
}
