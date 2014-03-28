package com;

import com.bean.ListNode;

public class LinkListCycle {

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
//        l4.next=l1;
        System.out.println(hasCycle(l1));
    }
    //判断head链表是否有cycle
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(true){  
            if(fast==null || fast.next==null || slow==null){  
                return false;  
            }  
               
            fast = fast.next.next;  
            slow = slow.next;  
               
            if(fast == slow){  
                return true;  
            }  
        }
    }
    //判断head链表是否有cycle,并返回循环的头结点
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode fast=head,slow=head;
        while(true){
            if(fast==null ||fast.next==null) return null;
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast) break;
        }
        slow=head;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
