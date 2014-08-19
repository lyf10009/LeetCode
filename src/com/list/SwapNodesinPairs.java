package com.list;

import com.bean.ListNode;

public class SwapNodesinPairs {
    /**
     *  Given a linked list, swap every two adjacent nodes and return its head. 
     *  For example, Given 1->2->3->4, you should return the list as 2->1->4->3. 
     *  Your algorithm should use only constant space.
     *  You may not modify the values in the list, only nodes itself can be changed.
     *  
     *  相当于ReverseNodesinkGroup k=2
     */
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode.printListNode(l1);
        
        ListNode res = swapPairs1(l1);
        ListNode.printListNode(res);
    }
    //将原链表插入新链表
    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode res = new ListNode(0);
        ListNode reHead = res;
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            reHead.next = cur.next;
            reHead = reHead.next;
            cur.next = cur.next.next;
            reHead.next = cur;
            reHead=reHead.next;
            cur = cur.next;
        }
        return res.next;
    }
    //直接改编原链表的节点顺序
    public static ListNode swapPairs1(ListNode head) {
        ListNode cur = null, next = null, tmp = null, pre = null;  
        cur = head;  
        if(head != null && head.next != null)  head = cur.next;  
        while(cur != null && cur.next != null){  
            next = cur.next;  
            if(pre != null)  
                pre.next = next;  
            tmp = next.next;  
            next.next = cur;  
            cur.next = tmp;  
            pre = cur;  
            cur = tmp;  
        }  
        return head;  
    }
}
