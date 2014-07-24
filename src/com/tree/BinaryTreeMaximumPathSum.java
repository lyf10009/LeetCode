package com.tree;

import com.bean.TreeNode;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode tree1=new TreeNode(1);
        TreeNode tree2=new TreeNode(2);
        TreeNode tree3=new TreeNode(3);
        TreeNode tree4=new TreeNode(4);
        TreeNode tree5=new TreeNode(5);
        TreeNode tree6=new TreeNode(6);
        TreeNode tree7=new TreeNode(7);
        TreeNode tree8=new TreeNode(8);
        
        tree1.left=tree2;
        tree1.right=tree6;
        tree2.left=tree3;
        tree3.left=tree4;
        tree2.right=tree5;
        tree6.right=tree7;
        tree7.right=tree8;
        
        System.out.println(maxPathSum(tree1));
    }
    /**
     * Given a binary tree, find the maximum path sum.
     * The path may start and end at any node in the tree.
     * For example:
     * Given the below binary tree,       
     *     1
     *    / \
     *   2   3
     * Return 6.
     */
    private static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxSum(root);
        return max;
    }
    private static int maxSum(TreeNode root){
        if(root == null) return 0;
        int  value  = root.val;  
        int  lmax = 0;  
        int  rmax = 0;  
        if(root.left!=null) {  
            lmax = maxSum(root.left);  
            if(lmax>0) {  
                value  += lmax;  
            }  
        }  
        if(root.right!=null) {  
            rmax = maxSum(root.right);  
            if(rmax>0) {  
                value  += rmax;  
            }  
        }  
        //更新最大值  
        if (value>max) {  
            max = value;  
        }  
        //返回值  
        //return max of (root.val, root.val + lmax, root.val + rmax)  
        return  Math.max(root.val,Math.max(root.val + lmax, root.val + rmax));  
    }
}
