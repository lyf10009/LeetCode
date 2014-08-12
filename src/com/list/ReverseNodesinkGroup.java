package com.list;

import com.bean.ListNode;

public class ReverseNodesinkGroup {
    /**
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
     * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
     * You may not alter the values in the nodes, only nodes itself may be changed.
     * Only constant memory is allowed.
     * For example,
     * Given this linked list: 1->2->3->4->5
     * For k = 2, you should return: 2->1->4->3->5
     * For k = 3, you should return: 3->2->1->4->5
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
        ListNode.printListNode(reverseKGroup1(l1,3));
        
    }
    
    //µü´ú
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        int length=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            length++;
        }
        if(length<k) return head;
        cur=head;
        ListNode start=null,end=null,pre=null,next=null;
        int group=length/k;
        for(int i=0;i<group;i++){
            start = cur;
            end=cur;
            for(int j=0;j<k;j++){
                next=cur.next;
                cur.next=end;
                end=cur;
                cur=next;
            }
            if(i==0){
                head = end;
            }else{
                pre.next=end;
            }
            start.next=next;
            pre=start;
        }
        return head;
    }
    //µÝ¹é
    public static ListNode reverseKGroup1(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        int length=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            length++;
        }
        if(length<k) return head;
        cur=head;
        ListNode start=null,end=null,next=null;
        start = cur;
        end=cur;
        for(int j=0;j<k;j++){
            next=cur.next;
            cur.next=end;
            end=cur;
            cur=next;
        }
        head = end;
        next=reverseKGroup1(next, k);
        start.next=next;
        return head;
    }
}
