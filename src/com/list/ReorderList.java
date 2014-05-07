package com.list;

import java.util.ArrayList;
import java.util.List;

import com.bean.ListNode;

public class ReorderList {

    /**
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     * You must do this in-place without altering the nodes' values.
     * For example,
     * Given {1,2,3,4}, reorder it to {1,4,2,3}.
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        
        ListNode.printListNode(l1);
//        reorderListI(l1);
        reorderListII(l1);
        ListNode.printListNode(l1);
    }
    public static void reorderListI(ListNode head) {
        if(!(head!=null && head.next!=null && head.next.next!=null)) return;
        ListNode cur = head;
        List<Integer> list=new ArrayList<Integer>();
        while(cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        cur = head.next;
        int len=list.size(),i=1,j=1;
        int num=0;
        while(cur!=null){
            if(num%2==0){
                cur.val=list.get(len-i);
                i++;
            }else{
                cur.val=list.get(j);
                j++;
            }
            cur=cur.next;
            num++;
        }
    }
    public static void reorderListII(ListNode head) {
        if(!(head!=null && head.next!=null && head.next.next!=null)) return;
        //通过快慢指针找到中间节点  
        ListNode fast = head;  
        ListNode slow = head;  
        while(fast!=null && fast.next!=null){  
            fast = fast.next.next;  
            slow = slow.next;  
        }  
        ListNode preReverse = slow; // preReverse不用翻转，因为它永远在最后一个  
        // 翻转后半段  
        ListNode reHead = preReverse.next;  
        ListNode preCur = reHead.next;  
        ListNode cur = reHead.next;  
        reHead.next = null;  
        while(cur != null){  
            cur = cur.next;  
            preCur.next = reHead;  
            reHead = preCur;  
            preCur = cur;  
        }  
        preReverse.next = reHead;  
        // 交叉合并两个链表  
        preReverse.next = null;     // 断开前半段和翻转后的后半段元素  
        cur = head;  
        while(reHead != null && cur!=null){  
            ListNode tmp = cur.next;  
            cur.next = reHead;  
            reHead = reHead.next;  
            cur.next.next = tmp;  
            cur = tmp;  
        }
    }
}
