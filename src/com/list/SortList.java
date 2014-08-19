package com.list;

import com.bean.ListNode;

public class SortList {

    /**
     * Sort a linked list in O(nlogn) time using constant space complexity.
     * 链表的归并排序
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(0);
        l1.next = l2;
        l2.next = l3;
        l3.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode.printListNode(l1);
        System.out.println("排序后");
        ListNode.printListNode(sortList(l1));
    }

    public static ListNode sortList(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode p=head,q=head;//通过快慢指针，将链表分成两段
        ListNode pre=p;
        while(q!=null && q.next!=null){
            q=q.next.next;
            pre=p;
            p=p.next;
        }
        pre.next=null;//将链表截断，p 是新表头
        return merge(sortList(head),sortList(p));
    }
    public static ListNode merge(ListNode h1,ListNode h2){
        ListNode head= new ListNode(0);
        ListNode p= head;
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                p.next=h1;
                h1=h1.next;
            }else{
                p.next=h2;
                h2=h2.next;
            }
            p =p.next;
        }
        p.next=h1!=null?h1:h2;
        return head.next;
    }
}
