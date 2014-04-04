package com;

import java.util.LinkedList;
import java.util.Queue;
import com.bean.TreeLinkNode;

public class PopulatingNextRightPointInEachNode {

    /**
     * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
     * Initially, all next pointers are set to NULL.
     */

    public static void main(String[] args) {
        TreeLinkNode t1=new TreeLinkNode(1);
        TreeLinkNode t2=new TreeLinkNode(2);
        TreeLinkNode t3=new TreeLinkNode(3);
        TreeLinkNode t4=new TreeLinkNode(4);
        TreeLinkNode t5=new TreeLinkNode(5);
        TreeLinkNode t6=new TreeLinkNode(6);
        TreeLinkNode t7=new TreeLinkNode(7);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
//        t3.left=t6;
        t3.right=t7;
        
//        connect(t1);
//        connect1(t1);
        connectII(t1);
    }
    
    /**
     * Note:
     * You may only use constant extra space.
     * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
     * For example,
     * Given the following perfect binary tree,
     *          1
     *         /  \
     *        2    3 
     *       / \  / \
     *      4  5  6  7
     * After calling your function, the tree should look like:
     *          1 -> NULL
     *        /  \
     *      2 -> 3 -> NULL
     *     / \  / \
     *    4->5->6->7 -> NULL
     */
    public static void connect(TreeLinkNode root) {
        if(root==null) return;
        Queue<TreeLinkNode> queue=new LinkedList<TreeLinkNode>();
        queue.offer(root);
        int floor=0;
        int num=1;
        for(int i=0;i<num;i++){
            TreeLinkNode tmp=queue.poll();
            if(num-i==1){
                System.out.println(tmp.val);
                tmp.next=null;
                if(tmp.left!=null){
                    floor++;
                    num=(int)Math.pow(2,floor);
                    i=-1;
                }
            }else{
                TreeLinkNode tmp1=queue.peek();
                System.out.println(tmp.val+" "+tmp1.val);
                tmp.next=tmp1;
            }
            if(tmp.left!=null){
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }
        }
    }

    //ตÝน้
    public static void connect1(TreeLinkNode root) {
        if(root==null) return;
        if(root.left!=null) root.left.next=root.right;
        if(root.right!=null){
            root.right.next=root.next==null?null:root.next.left;
        }
        
        if(root.left!=null) connect1(root.left);
        if(root.right!=null) connect1(root.right);
    }
    
    
    /**
     * Note:
     * You may only use constant extra space.
     * You may assume that it is any binary tree.
     * For example,
     * Given the following perfect binary tree,
     *          1
     *         /  \
     *        2    3 
     *       / \    \
     *      4  5     7
     * After calling your function, the tree should look like:
     *         1 -> NULL
     *        /  \
     *       2 -> 3 -> NULL
     *      / \    \
     *     4->5---->7 -> NULL
     */
    public static void connectII(TreeLinkNode root) {
        if(root==null) return;
        Queue<TreeLinkNode> queue=new LinkedList<TreeLinkNode>();
        queue.offer(root);
        int num=1;
        for(int i=0;i<num;i++){
            TreeLinkNode tmp=queue.poll();
            if(num-i==1){
                System.out.println(tmp.val);
                tmp.next=null;
                if(tmp.left!=null) queue.offer(tmp.left);
                if(tmp.right!=null) queue.offer(tmp.right);
                num=queue.size();
                i=-1;
            }else{
                TreeLinkNode tmp1=queue.peek();
                System.out.println(tmp.val+" "+tmp1.val);
                tmp.next=tmp1;
                if(tmp.left!=null) queue.offer(tmp.left);
                if(tmp.right!=null) queue.offer(tmp.right);
            }
        }
    }
}
