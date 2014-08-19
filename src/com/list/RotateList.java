package com.list;

import com.bean.ListNode;

public class RotateList {
    /**
     * Given a list, rotate the list to the right by k places, where k is non-negative.
     * For example:
     * Given 1->2->3->4->5->NULL and k = 2,
     * return 4->5->1->2->3->NULL.
     * 
     * ע��һ�㣬K���ܷǳ��󣬱�����ĳ��ȴ�ö࣬������Ϊ��ѭ�����ƣ�
     * ����ʵ����ֻҪѭ������K%Lengthλ(LengthΪ������)
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
        ListNode.printListNode(rotateRight2(l1,6));
    }
    //��n������������ʱ��ͨ����
    //��n>lengthʱ����ͨ����û��ѭ������
    public static ListNode rotateRight(ListNode head, int n) {
        if(head==null) return head;
        ListNode cur = head;
        ListNode tmp=head;
        for(int i=0;i<n && tmp!=null;i++){
            tmp=tmp.next;
        }
        if(tmp==null) return head;
        while(tmp.next!=null){
            tmp=tmp.next;
            cur=cur.next;
        }
        tmp.next=head;
        head=cur.next;
        cur.next=null;
        return head;
    }
    
    //ע��һ�㣬K���ܷǳ��󣬱�����ĳ��ȴ�ö࣬������Ϊ��ѭ�����ƣ�����ʵ����ֻҪѭ������K%Lengthλ(LengthΪ������)
    public static ListNode rotateRight1(ListNode head, int n) {
        if(head==null || head.next==null|| n==0) return head;
        //�ȱ���һ�飬�õ������ȣ�����β�ڵ�
        int length=0;
        ListNode cur=head,tail=head;
        while(cur!=null){
            length++;
            tail=cur;
            cur=cur.next;
        }
        
        n=n%length;//�õ���ת�����
        
        cur=head;
        for(int i=0;i<length-n-1;i++){
            cur=cur.next;
        }
        tail.next=head;
        head=cur.next;
        cur.next=null;
        return head;
    }
    
    public static ListNode rotateRight2(ListNode head, int n) {
        if(head == null) return null;  
        ListNode back = head;  
        ListNode front = head;  
        ListNode end = head;  
        //�Ȱ������Ϊѭ������  
        while(front.next != null){  
            front = front.next;  
        }
        end = front;        // ��¼ԭβ�ڵ�  
        front.next = head;  // �γɻ�  
        front = head;       // ��ԭfrontָ��  
        // ʹ��front��backǰ��n������  
        for(int i=0; i<n; i++){  
            front = front.next;  
        }  
        // ˫ָ��ͬ���ƶ�  
        while(front != end){  
            front = front.next;  
            back = back.next;  
        }  
        ListNode rotateHead = back.next;        // �ҵ�rotate֮�������ͷ
        back.next = null;           // �п�ѭ������  
        return rotateHead;  
    }
}
