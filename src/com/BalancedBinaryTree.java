package com;

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
        System.out.println(isBalanced1(tree1));
    }
    public static boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left1=getDepth(root.left);
        int right1=getDepth(root.right);
        if(Math.abs(left1-right1)>1) return false;

        boolean left=isBalanced(root.left);
        if(!left) return false;
        boolean right=isBalanced(root.right);
        if(!right) return false;
        return true;
    }
    public static int getDepth(TreeNode root){
        if(root==null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right))+1;
    }
    
    
    public static boolean isBalanced1(TreeNode root) {
        int depth = 0;  
        return isbalance(root, depth);
    }
    public static boolean isbalance(TreeNode root, int depth){  
        if(root == null){  
            depth = 0;  
            return true;  
        }  
        int ld = 0,rd=0;  
        if( isbalance(root.left,ld) && isbalance(root.right,rd)){  
            if( Math.abs(ld - rd) > 1){  
                return false;  
            }  
            depth = ld > rd ? ld + 1 : rd + 1;  
            return true;  
        }
        return false;  
    } 
}
