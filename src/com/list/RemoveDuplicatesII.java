package com.list;

import com.bean.ListNode;

public class RemoveDuplicatesII {
    /**
     * 去除有序链表中重复的节点
     * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
     * For example,
     * Given 1->2->3->3->4->4->5, return 1->2->5.
     * Given 1->1->1->2->3, return 2->3.
     */
    public static void main(String[] args) {
        ListNode l1=new ListNode(0);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(1);
        ListNode l4=new ListNode(2);
        ListNode l5=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        
        ListNode.printListNode(l1);
        ListNode res=deleteDuplicates(l1);
        ListNode.printListNode(res);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode res=new ListNode(0);
        ListNode pos=res;
        ListNode cur=head;
        
        int standart=head.val;
        int num=0;
        while(cur!=null){
            if(cur.val==standart){
                num++;
            }else{
                if(num==1){
                    pos.next=new ListNode(standart);
                    pos=pos.next;
                }
                standart=cur.val;
                num=1;
            }
            cur=cur.next;
        }
        if(num==1){
            pos.next=new ListNode(standart);
            pos=pos.next;
        }
        return res.next;
    }
}
