package com.list;

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
        l4.next=l1;
        System.out.println(hasCycle(l1));
    }
    /**
     * 判断head链表是否有cycle
     * 思路：通过快慢指针解决。若两个指针能重合，即链表中有循环
     * @param head 待检查的链表
     * @return 若有循环，返回true；否则，返回false。
     */
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
    /**
     * 判断head链表是否有cycle,并返回循环的头结点
     * 思路：当快慢指针重合后，将慢指针移回表头，快指针速度减慢。
     *       当两个指针再次重合时，重合的节点即为循环的头结点
     * @param head 待检查的链表
     * @return 循环的头结点。若无循环，则返回null
     */
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
