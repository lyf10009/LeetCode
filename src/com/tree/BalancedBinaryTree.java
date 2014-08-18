package com.tree;

import com.bean.TreeNode;

public class BalancedBinaryTree {

    /**
     * Given a binary tree, determine if it is height-balanced.
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees 
     * of every node never differ by more than 1.
     */
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
        
        System.out.println(isBalanced(tree1));
    }
    public static boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left1=getDepth(root.left);
        int right1=getDepth(root.right);
        if(Math.abs(left1-right1)>1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public static boolean isBalanced1(TreeNode root) {
        if(root==null) return true;
        if(isBalanced(root.left) && isBalanced(root.right)){
            int left1=getDepth(root.left);
            int right1=getDepth(root.right);
            
            return Math.abs(left1-right1)<2;
        }
        return false;
    }
    
    public static int getDepth(TreeNode root){
        if(root==null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right))+1;
    }
}
