package com.list;

import com.bean.ListNode;

public class ReverseList {

    /**
     * ·­×ªÁ´±í
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode.printListNode(l1);
        ListNode.printListNode(reverseList(l1));
        ListNode.printListNode(l1);
    }
    
    public static ListNode reverseList(ListNode head){
        ListNode pre=head.next;
        ListNode cur=head.next;
        head.next=null;
        while(cur!=null){
            cur=cur.next;
            pre.next=head;
            head=pre;
            pre=cur;
        }
        return head;
    }
}
