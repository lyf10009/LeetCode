package com.tree;

import java.util.ArrayList;
import java.util.Stack;

import com.bean.TreeNode;

public class BinaryTreePostorderTraversal {

    /**
     * 二叉树的后序遍历
     * Given a binary tree, return the postorder traversal of its nodes' values.
     * For example:
     * Given binary tree {1,#,2,3},
     *    1
     *     \
     *      2
     *     /
     *    3
     * return [3,2,1].
     * Note: Recursive solution is trivial, could you do it iteratively?
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
        
//        System.out.println("递归方法："+postorderTraversal(tree1).toString());
//        System.out.println("迭代方法1："+postorderTraversal1(tree1).toString());
        System.out.println("迭代方法2："+postorderTraversal2(tree1).toString());
    }
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(root==null) return res;
        if(root.left!=null) res.addAll(postorderTraversal(root.left));
        if(root.right!=null) res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }
    public static ArrayList<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(root == null)  return res;  
        Stack<TreeNode> st = new Stack<TreeNode>();
        Stack<Integer> resStack = new Stack<Integer>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode tmp=st.peek();
            resStack.push(tmp.val);
            st.pop();
            if(tmp.left!=null)  st.push(tmp.left);
            if(tmp.right!=null) st.push(tmp.right);
        }
        while(!resStack.isEmpty()){
            int tmp=resStack.pop();
            res.add(tmp);
        }
        return res;
    }
    public static ArrayList<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        TreeNode pre = null;  
        while (!stack.isEmpty() || root != null) {  
            if (root != null) {  
                stack.push(root);  
                root = root.left;  
            } else {  
                root = stack.pop();  
                if (root.right == null || root.right == pre) {  
                    pre = root;  
                    list.add(root.val);  
                    root = null;  
                } else {  
                    stack.push(root);  
                    root = root.right;  
                }  
            }  
        }  
        return list;
    }
}
