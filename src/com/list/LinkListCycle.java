package com.list;

import com.bean.ListNode;

public class LinkListCycle {

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l1;
        System.out.println(hasCycle(l1));
    }
    /**
     * �ж�head�����Ƿ���cycle
     * ˼·��ͨ������ָ������������ָ�����غϣ�����������ѭ��
     * @param head ����������
     * @return ����ѭ��������true�����򣬷���false��
     */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(true){
            if(fast==null || fast.next==null || slow==null){  
                return false;  
            }  
            fast = fast.next.next;  
            slow = slow.next;  
            if(fast == slow){  
                return true;  
            }  
        }
    }
    /**
     * �ж�head�����Ƿ���cycle,������ѭ����ͷ���
     * ˼·��������ָ���غϺ󣬽���ָ���ƻر�ͷ����ָ���ٶȼ�����
     *       ������ָ���ٴ��غ�ʱ���غϵĽڵ㼴Ϊѭ����ͷ���
     * @param head ����������
     * @return ѭ����ͷ��㡣����ѭ�����򷵻�null
     */
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode fast=head,slow=head;
        while(true){
            if(fast==null ||fast.next==null) return null;
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast) break;
        }
        
        slow=head;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
