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
    }

    //���ݲ���ʱ������ֳ�ʱ�����
    public static ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode preNode=head;
        ListNode cur=head.next;
        ListNode nextNode=null;
        while(cur!=null){
            nextNode=cur.next;
            if(head.val>cur.val){
                cur.next=head;
                preNode.next=nextNode;
                head=cur;
            }else{
                ListNode curTmp=head.next;
                ListNode preNodeTmp=head;
                while(curTmp!=null){
                    if(curTmp==cur) break;
                    if(curTmp.val>cur.val){
                        cur.next=curTmp;
                        preNodeTmp.next=cur;
                        preNode.next=nextNode;
                        break;
                    }
                    preNodeTmp=curTmp;
                    curTmp=curTmp.next;
                }
            }
            preNode=cur;
            cur=nextNode;
        }
        return head;
    }

    //ͨ��
    public static ListNode insertionSortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode resHead = null;
        ListNode resTail = null;
        while (head != null) {
            ListNode curr = head;
            head = head.next;
            //if it's the first node, we can set resHead and resTail
            if (resHead == null) {
                resHead = curr;
                resTail = curr;
                resTail.next = null;
            // if the current node is smaller than head, we insert before the resHead
            } else if (curr.val <= resHead.val) {
                curr.next = resHead;
                resHead = curr;
            // if the current node is larger than tail, we insert after the resTail
            } else if (curr.val >= resTail.val) {
                resTail.next = curr;
                resTail = curr;
                resTail.next = null;
            // otherwise, when the current node's value is in the middle,   
            // we should go through the result list to find the right insertion position
            } else {
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
