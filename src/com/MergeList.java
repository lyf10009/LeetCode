package com;

import com.bean.ListNode;

public class MergeList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(6);
        l1.next=l2;
        l2.next=l3;
        ListNode l4=new ListNode(2);
        ListNode l5=new ListNode(4);
        ListNode l6=new ListNode(5);
        l4.next=l5;
        l5.next=l6;
        ListNode.printListNode(l1);
        ListNode.printListNode(l4);
        System.out.println("排序后：");
        ListNode.printListNode(mergeTwoLists(l1,l4));
        ListNode.printListNode(mergeTwoLists1(l1,l4));

    }
    /**
     * Merge two sorted linked lists and return it as a new list. 
     * The new list should be made by splicing together the nodes of the first two lists.
     */
    //将l1、l2插入一个新链表中
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode res = new ListNode(0);
        ListNode cur=res;
        while(l1!=null || l2!=null){
            if(l1!=null && l2!=null){
                int a=l1.val,b=l2.val;
                if(a>b){
                    cur.next=new ListNode(b);
                    l2=l2.next;
                }else{
                    cur.next=new ListNode(a);
                    l1=l1.next;
                }
                cur=cur.next;
            }else{
                if(l1==null){
                    cur.next=l2;
                    break;
                }else{
                    cur.next=l1;
                    break;
                }
            }
        }
        return res.next;
    }
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode res= new ListNode(0);
        ListNode cur= res;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur =cur.next;
        }
        cur.next=l1!=null?l1:l2;
        return res.next;
    }
}
