package com.list;

import com.bean.ListNode;

public class InsertSortList {

    /**
     * ������Ĳ�������
     * ÿ�δ�����ǽ��������еĵ�һ��Ԫ�����������е�Ԫ�شӺ���ǰ������бȽϣ��ҳ�����λ�ã�����Ԫ�ز��뵽�������еĺ���λ���С�
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
        System.out.println("�����");
        ListNode.printListNode(insertionSortList(l1));
        ListNode.printListNode(l1);
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode resHead = null;//�±�ͷ
        ListNode resTail = null;//�±�β
        ListNode curr=null;
        while (head != null) {
            curr = head;
            head = head.next;
            if (resHead == null) {//������Ϊ��ʱ������ǰ�ڵ㵱����ͷ�ͱ�β
                resHead = curr;
                resTail = curr;
                resTail.next = null;
            } else if (curr.val <= resHead.val) {//����ǰ�ڵ��ֵС�ڵ����±�ͷʱ������ǰ�ڵ�����Ϊ��ͷ
                curr.next = resHead;
                resHead = curr;
            } else if (curr.val >= resTail.val) {//����ǰ�ڵ��ֵ���ڵ����±�βʱ������ǰ�ڵ�����Ϊ��β
                resTail.next = curr;
                resTail = curr;
                resTail.next = null;
            } else {
                //���򣬵�ǰ�ڵ�Ӧ���������С����±�ͷ��ʼ�������������������һ���ڵ�ֵ������Сʱ���ڵ�Ӯ����ýڵ�֮��
                //1-->2-->4�� 3��3Ӧ�ò�����2 4֮��
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
