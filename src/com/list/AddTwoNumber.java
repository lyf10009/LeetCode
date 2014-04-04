package com.list;

import com.bean.ListNode;

public class AddTwoNumber {

    /**
     * 将两个链表表示的数相加，并将结果表示为链表的形式
     * hehe
     */
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(4);
        ListNode l6=new ListNode(4);
        l4.next=l5;
        l5.next=l6;
        ListNode.printListNode(l1);
        ListNode.printListNode(l4);
        ListNode.printListNode(addTwoInt(l1,l4));
    }

    public static ListNode addTwoInt(ListNode l1, ListNode l2) {
        int a = 0;
        ListNode list = new ListNode(0);
        ListNode cur = list;
        for(;;){
            int val1=0,val2=0;
            if(l1!=null){
                val1=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                val2=l2.val;
                l2 = l2.next;
            }
            int i=val1+val2+a;
            a = i/10;
            cur.next=new ListNode(i%10);
            
            cur=cur.next;
            if(l1==null && l2==null) break;
        }
        if(a!=0){
            cur.next=new ListNode(a);
        }
        return list.next;
    }
}
