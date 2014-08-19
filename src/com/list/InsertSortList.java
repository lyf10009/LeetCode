package com.list;

import com.bean.ListNode;

public class InsertSortList {

    /**
     * 单链表的插入排序
     * 每次处理就是将无序数列的第一个元素与有序数列的元素从后往前逐个进行比较，找出插入位置，将该元素插入到有序数列的合适位置中。
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(-1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode.printListNode(l1);
        System.out.println("排序后");
        ListNode.printListNode(insertionSortList(l1));
        ListNode.printListNode(l1);
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode resHead = null;//新表头
        ListNode resTail = null;//新表尾
        ListNode curr=null;
        while (head != null) {
            curr = head;
            head = head.next;
            if (resHead == null) {//新链表为空时，将当前节点当做表头和表尾
                resHead = curr;
                resTail = curr;
                resTail.next = null;
            } else if (curr.val <= resHead.val) {//当当前节点的值小于等于新表头时，将当前节点设置为表头
                curr.next = resHead;
                resHead = curr;
            } else if (curr.val >= resTail.val) {//当当前节点的值大于等于新表尾时，将当前节点设置为表尾
                resTail.next = curr;
                resTail = curr;
                resTail.next = null;
            } else {
                //否则，当前节点应该在链表中。从新表头开始往后遍历，当遍历到下一个节点值不比它小时，节点赢插入该节点之后
                //1-->2-->4， 3。3应该插入在2 4之间
                ListNode findPos = resHead;
                while (curr.val > findPos.next.val) {
                    findPos = findPos.next;
                }
                curr.next = findPos.next;
                findPos.next = curr;
            }
        }
        return resHead;
    }
}
