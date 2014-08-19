package com.list;

import com.bean.RandomListNode;

public class CopyListWithRandomPointer {
    /**
     * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
     * Return a deep copy of the list.
     */
    public static void main(String[] args) {
        RandomListNode node1=new RandomListNode(1);
        RandomListNode node2=new RandomListNode(2);
        RandomListNode node3=new RandomListNode(3);
        RandomListNode node4=new RandomListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        
        node1.random=node3;
        node4.random=node2;
        
        RandomListNode.print(copyRandomList(node1));
        
    }
    public static RandomListNode copyRandomList(RandomListNode head) {
        //在每个节点后插入一个节点，该节点的值与前一个节点相同
        RandomListNode cur=head;
        while(cur!=null){
            RandomListNode tmp = new RandomListNode(cur.label);
            tmp.next=cur.next;
            cur.next=tmp;
            cur=tmp.next;
        }
        
        //将偶数节点的random与奇数节点的random相同
        cur=head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
        }
        
        //将偶数节点取出来，即为原链表的复制链表
        cur=head;
        RandomListNode newList = null;
        RandomListNode tmp= null;
        if(cur!=null){
            newList=cur.next;
            tmp=cur.next;
            cur.next=tmp.next;
            cur=cur.next;
        }
        while(cur!=null){
            tmp.next=cur.next;
            tmp=tmp.next;
            cur.next=tmp.next;
            cur=cur.next;
        }
        return newList;
    }
}
