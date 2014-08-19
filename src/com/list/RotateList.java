package com.list;

import com.bean.ListNode;

public class RotateList {
    /**
     * Given a list, rotate the list to the right by k places, where k is non-negative.
     * For example:
     * Given 1->2->3->4->5->NULL and k = 2,
     * return 4->5->1->2->3->NULL.
     * 
     * 注意一点，K可能非常大，比链表的长度大得多，但是因为是循环右移，
     * 所以实际上只要循环右移K%Length位(Length为链表长度)
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
    //当n不大于链表长度时，通过。
    //当n>length时，不通过，没有循环右移
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
    
    //注意一点，K可能非常大，比链表的长度大得多，但是因为是循环右移，所以实际上只要循环右移K%Length位(Length为链表长度)
    public static ListNode rotateRight1(ListNode head, int n) {
        if(head==null || head.next==null|| n==0) return head;
        //先遍历一遍，得到链表长度，链表尾节点
        int length=0;
        ListNode cur=head,tail=head;
        while(cur!=null){
            length++;
            tail=cur;
            cur=cur.next;
        }
        
        n=n%length;//得到翻转的序号
        
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
        //先把链表改为循环链表  
        while(front.next != null){  
            front = front.next;  
        }
        end = front;        // 记录原尾节点  
        front.next = head;  // 形成环  
        front = head;       // 复原front指针  
        // 使得front在back前面n个距离  
        for(int i=0; i<n; i++){  
            front = front.next;  
        }  
        // 双指针同步移动  
        while(front != end){  
            front = front.next;  
            back = back.next;  
        }  
        ListNode rotateHead = back.next;        // 找到rotate之后的链表头
        back.next = null;           // 切开循环链表  
        return rotateHead;  
    }
}
