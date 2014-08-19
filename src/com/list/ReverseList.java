package com.list;

import com.bean.ListNode;

public class ReverseList {

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
        ListNode.printListNode(reverseList1(l1));
        
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next=null;
        int m=1,n=3;//翻转区域的起点和终点。序号从1开始
        ListNode.printListNode(reverseListII(l1,m,n));
    }
    
    /**
     * 翻转链表
     */
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
    public static ListNode reverseList1(ListNode head){
        ListNode newHead=null;
        ListNode cur=head,pre=null;
        while(cur!=null){
            ListNode next=cur.next;
            if(next==null){
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return newHead;
    }
    
    /**
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.
     * For example:
     * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     * return 1->4->3->2->5->NULL.
     * Note:
     * Given m, n satisfy the following condition:
     * 1 ≤ m ≤ n ≤ length of list.
     */
    public static ListNode reverseListII(ListNode head,int m,int n){
        if(m==n) return head;
        ListNode cur=head;
        ListNode start=null,end=null,pre=null,next=null;
        for(int i=1;i<m;i++){
            pre = cur;
            cur=cur.next;
        }
        start = cur;
        end=cur;
        for(int i=m;i<=n;i++){
            next=cur.next;
            cur.next=end;
            end=cur;
            cur=next;
        }
        if(pre==null){
            head = end;
        }else{
            pre.next=end;
        }
        start.next=next;
        return head;
    }
}
