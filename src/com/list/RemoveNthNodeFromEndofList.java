package com.list;

import com.bean.ListNode;

public class RemoveNthNodeFromEndofList {
    /**
     * Given a linked list, remove the nth node from the end of list and return its head.
     * For example,
     *    Given linked list: 1->2->3->4->5, and n = 2.
     *    After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     * Given n will always be valid.
     * Try to do this in one pass.
     * @param args
     */
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        
        ListNode.printListNode(l1);
        ListNode.printListNode(removeNthFromEnd(l1, 5));
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode tmp = head;
        int i=0;
        while(cur.next!=null){
            cur = cur.next;
            i++;
            if(i>n){
                tmp = tmp.next;
            }
        }
        if(i==n-1){//重新设置头结点
            head = head.next;
//            ListNode.printListNode(head);
        }else{
            tmp.next=tmp.next.next;
        }
        return head;
    }
}
