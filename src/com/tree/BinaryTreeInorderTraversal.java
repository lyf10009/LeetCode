package com.tree;

import java.util.ArrayList;
import java.util.Stack;
import com.bean.TreeNode;

public class BinaryTreeInorderTraversal {

    /**
     * 二叉树的中序遍历
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
        tree1.right=tree5;
        tree2.left=tree3;
        tree2.right=tree7;
        tree3.right=tree4;
        tree4.left=tree8;
        tree5.right=tree6;
        
        System.out.println("递归方法："+inorderTraversal(tree1).toString());
        System.out.println("迭代方法："+inorderTraversal1(tree1).toString());
    }
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(root==null) return res;
        if(root.left!=null) res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        if(root.right!=null) res.addAll(inorderTraversal(root.right));
        return res;
    }
    public static ArrayList<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(root == null)  return res;  
        Stack<TreeNode> st = new Stack<TreeNode>();
        while(!st.isEmpty()|| root!=null){
            if(root!=null){
                st.push(root);
                root=root.left;
            }else{
                TreeNode tmp=st.pop();
                res.add(tmp.val);
                if(tmp.right!=null){
                    root=tmp.right;
                }
            }
        }
        return res;
    }
}
