package com;

import java.util.ArrayList;
import java.util.Stack;

import com.bean.TreeNode;

public class BinaryTreePreorderTraversal {

    /**
     * Given a binary tree, return the preorder traversal of its nodes' values.
     * For example:
     * Given binary tree {1,#,2,3},
     * return [1,2,3].
     * @param args
     */
    public static void main(String[] args) {
        TreeNode tree1=new TreeNode(1);
        TreeNode tree2=new TreeNode(2);
        TreeNode tree3=new TreeNode(3);
        TreeNode tree4=new TreeNode(4);
        TreeNode tree5=new TreeNode(5);
        TreeNode tree6=new TreeNode(6);
        TreeNode tree7=new TreeNode(7);
        
        tree1.left=tree2;
        tree1.right=tree5;
        tree2.left=tree3;
        tree2.right=tree7;
        tree3.right=tree4;
        tree5.right=tree6;
        
        System.out.println("递归方法：\n"+preorderTraversal(tree1).toString());
        System.out.println("迭代方法：\n"+preorderTraversal1(tree1).toString());
    }
    //使用递归方法实现
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(root==null) return res;
        res.add(root.val);
        if(root.left!=null) res.addAll(preorderTraversal(root.left));
        if(root.right!=null) res.addAll(preorderTraversal(root.right));
        return res;
    }
    
    //使用迭代方法实现
    public static ArrayList<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(root == null)  return res;  
        Stack<TreeNode> st = new Stack<TreeNode>();
        /**
         * stack的方法
         * push:入栈
         * pop：出栈，并移除
         * peek：出栈，不移除
         */
        st.push(root);
        while(!st.isEmpty()){  
            TreeNode cur = st.peek();  
            res.add(cur.val);  
            st.pop();
            if(cur.right != null)  st.push(cur.right);  
            if(cur.left != null)  st.push(cur.left);  
        }  
        st = null;  
        return res;
    }
}
