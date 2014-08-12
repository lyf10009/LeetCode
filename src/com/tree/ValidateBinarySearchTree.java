package com.tree;

import java.util.ArrayList;

import com.bean.TreeNode;

public class ValidateBinarySearchTree {
    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     * Assume a BST is defined as follows:
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     */
    public static void main(String[] args) {
        TreeNode tree1=new TreeNode(1);
        TreeNode tree2=new TreeNode(2);
        TreeNode tree3=new TreeNode(3);
        TreeNode tree4=new TreeNode(4);
        TreeNode tree5=new TreeNode(5);
        tree1.left=tree2;
        tree1.right=tree3;
        tree3.left=tree4;
        tree4.right=tree5;
        System.out.println(isValidBST1(tree1));
    }
    
    public static boolean isValidBST1(TreeNode root) {
        return rec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);  
    }  
    // 用最小值和最大值，来限定子树的范围  
    public static boolean rec(TreeNode root, int min, int max){  
        if(root == null){  
            return true;  
        }  
        // 不在范围内  
        if(root.val <= min || root.val >= max){  
            return false;  
        }  
        // 检查左右子树的合法性并更新上下限  
        return rec(root.left, min, root.val) && rec(root.right, root.val, max);  
    }  
    
    
    //先中序遍历，再看是否是递增
    public static boolean isValidBST2(TreeNode root) {
        ArrayList<Integer> list = inorderTraversal(root);
        for(int i=1;i<list.size();i++){
            if (list.get(i) <= list.get(i - 1)) {  
                return false;  
            }
        }
        return true;
    }
    //中序遍历
    private static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(root==null) return res;
        if(root.left!=null) res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        if(root.right!=null) res.addAll(inorderTraversal(root.right));
        return res;
    }
}
