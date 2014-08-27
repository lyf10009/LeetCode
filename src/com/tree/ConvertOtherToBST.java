package com.tree;

import com.bean.ListNode;
import com.bean.TreeNode;

public class ConvertOtherToBST {

    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST(Binary Search Tree)
     * @param args
     */
    public static void main(String[] args) {
        int[] preorder= {1,2,3,4,5,6,7,8};
        System.out.println(BinaryTreeInorderTraversal.inorderTraversal(sortedArrayToBST(preorder)).toString());//�������
        System.out.println(BinaryTreePreorderTraversal.preorderTraversal(sortedArrayToBST(preorder)).toString());//�������
    }
    
    public static TreeNode sortedArrayToBST(int[] num) {
        return sortToBST(num,0, num.length-1);
    }
    private static TreeNode sortToBST(int[] num,int start,int end){
        if(start>end) return null;
        int index=(end+start)/2;
        TreeNode root = new TreeNode(num[index]);
        root.left = sortToBST(num,start,index-1);
        root.right = sortToBST(num,index+1,end);
        return root;
    }
    
    
    public static TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        int[] num=new int[len];int i=0;
        cur=head;
        while(cur!=null){
            num[i]=cur.val;
            i++;
            cur=cur.next;
        }
        return sortToBST(num, 0, len-1);
        
    }
    
    
    public static TreeNode sortedListToBST1(ListNode head) {
        return sortToBST1(head, null);
    }
    private static TreeNode sortToBST1(ListNode start,ListNode end){
        if(start==end) return null;
        // һ�α����ҵ��е�ķ���������ָ��  
        ListNode mid = start;           // ��ָ�����ջ�ָ���е�  
        ListNode probe = start;         // ̽�����ջᵽ��end  
        while(probe!=end && probe.next!=end){       // ̽�����������ע��ֹͣ�����Ǻ�end�Ƚ϶����Ǻ�null�ȣ�  
            mid = mid.next;  
            probe = probe.next.next;  
        }
        TreeNode root = new TreeNode(mid.val);
        root.left=sortToBST1(start, mid);
        root.right=sortToBST1(mid.next, end);
        return root;
    }
}
