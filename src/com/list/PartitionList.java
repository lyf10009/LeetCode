package com.list;

import com.bean.ListNode;

public class PartitionList {
    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before
     * nodes greater than or equal to x. You should preserve the original relative order of the
     * nodes in each of the two partitions. For example, Given 1->4->3->2->5->2 and x = 3, return
     * 1->2->2->4->3->5.
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode.printListNode(l1);
        int x = 2;
        ListNode.printListNode(partition(l1, x));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode cur = head, start = null, end = null, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            if (cur.val < x) {
                if (end == null) {
                    end = cur;
                    if (start != null) {
                        pre.next = end.next;
                        end.next = head;
                        head = end;
                    }
                } else {
                    if (start != null) {
                        cur.next = end.next;
                        end.next = cur;
                        pre.next = tmp;
                    }
                    end = cur;
                }
            } else {
                if (start == null) {
                    start = cur;
                }
                pre = cur;
            }
            cur = tmp;
        }
        return head;
    }
}
