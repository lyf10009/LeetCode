package com.list;

import com.bean.ListNode;

public class AddTwoNumber {

    /**
     * �����������ʾ������ӣ����������ʾΪ�������ʽ
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     */
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);//��λ
        ListNode l2=new ListNode(1);//ʮλ
        ListNode l3=new ListNode(3);//��λ
        l1.next=l2;
        l2.next=l3;
        ListNode l4=new ListNode(9);//��λ
        ListNode l5=new ListNode(4);//ʮλ
        ListNode l6=new ListNode(9);//��λ
        l4.next=l5;
        l5.next=l6;
        ListNode.printListNode(l1);
        ListNode.printListNode(l4);
        ListNode.printListNode(addTwoInt(l1,l4));
    }

    public static ListNode addTwoInt(ListNode l1, ListNode l2) {
        int a = 0;//��λ��־
        ListNode list = new ListNode(0);
        ListNode cur = list;
        while(l1!=null || l2!=null){
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
        }
        if(a!=0){
            cur.next=new ListNode(a);
        }
        return list.next;
    }
}
