package com.list;

import com.bean.ListNode;

public class PartitionList {
    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before
     * nodes greater than or equal to x. You should preserve the original relative order of the
     * nodes in each of the two partitions. 
     * 有一个链表list和一个数x，将链表中小于x的节点放在前面，大于等于的节点放在后面
     * For example, 
     * Given  1->4->3->2->5->2 and x = 3,
     * return 1->2->2->4->3->5.
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode.printListNode(l1);
        int x = 3;
        ListNode.printListNode(partition1(l1, x));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode end = null;//小于x的最后一个数
        ListNode start = null;//大于等于x的第一个数
        ListNode pre = null;//大于等于x的最后一个数
        while (cur != null) {
            ListNode tmp = cur.next;
            if (cur.val < x) {
                if (end == null) {
                    end = cur;
                    if (start != null) {//现在表头是大于等于x的数，需要重新设置表头
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

    public static ListNode partition1(ListNode head, int x) {
        ListNode prev = new ListNode(0);//新链表
        prev.next = head;
        ListNode current = prev;
        ListNode runner = prev;
        while (current.next != null && current.next.val < x) {
            current = current.next;
            runner = runner.next;
        }
        while (runner.next != null) {
            if (runner.next.val < x) {
                ListNode temp = runner.next;
                runner.next = runner.next.next;
                temp.next = current.next;
                current.next = temp;
                current = current.next;
            } else
                runner = runner.next;
        }
        return prev.next;
    }
}
