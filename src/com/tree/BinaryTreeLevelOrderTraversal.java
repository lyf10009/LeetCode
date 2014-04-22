package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.bean.TreeLinkNode;
import com.bean.TreeNode;

public class BinaryTreeLevelOrderTraversal {

    /**Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     * For example:
     * Given binary tree {3,9,20,#,#,15,7},
     *         3
     *        / \
     *       9  20
     *         /  \
     *        15   7
     */
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.right=t7;
        levelOrderI(t1);
    }
    /**
     * return its level order traversal as:
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */
    public static ArrayList<ArrayList<Integer>> levelOrderI(TreeNode root) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        if(root==null) return list;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int num=1;
        ArrayList<Integer> hangList=new ArrayList<Integer>();
        for(int i=0;i<num;i++){
            TreeNode tmp = queue.poll();
            hangList.add(tmp.val);
            if(tmp.left!=null) queue.offer(tmp.left);
            if(tmp.right!=null) queue.offer(tmp.right);
            if(num-i==1){
                num=queue.size();
                list.add(hangList);
                hangList=new ArrayList<Integer>();
                
                i=-1;
            }
        }
        System.out.println(list);
        return list;
    }
    
    
    /**
     * return its level order traversal as:
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     */
    public static ArrayList<ArrayList<Integer>> levelOrderII1(TreeNode root) {
        ArrayList<ArrayList<Integer>> list=levelOrderI(root);
        ArrayList<ArrayList<Integer>> re=new ArrayList<ArrayList<Integer>>();
        for(int j=list.size()-1;j>=0;j--){
            re.add(list.get(j));
        }
        return re;
    }
    
    public static ArrayList<ArrayList<Integer>> levelOrderII2(TreeNode root) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        if(root==null) return list;
        
        
        return list;
    }
}
