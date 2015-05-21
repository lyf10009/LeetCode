package com.list;

import com.bean.ListNode;

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {
		
	}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0,lenB=0;
        ListNode cur=headA;
        while(cur!=null){
        	lenA++;
        	cur=cur.next;
        }
        cur=headB;
        while(cur!=null){
        	lenB++;
        	cur=cur.next;
        }
        
        while(lenA>lenB){
        	headA=headA.next;
        	lenA--;
        }
        while(lenA<lenB){
        	headB=headB.next;
        	lenB--;
        }
        
        while(headA!=null){
        	if(headA == headB) return headA;
        	headA=headA.next;
        	headB=headB.next;
        }
        return null;
    }
}
