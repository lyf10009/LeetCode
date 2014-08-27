package com.tree;

import java.util.ArrayList;

import com.bean.TreeNode;

public class SumRoottoLeafNumbers {

    /**
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     * Find the total sum of all root-to-leaf numbers.
     * For example,
     *     1
     *    / \
     *   2   3
     * The root-to-leaf path 1->2 represents the number 12
     * The root-to-leaf path 1->3 represents the number 13.
     * Return the sum = 12 + 13 = 25.
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
        
        System.out.println(sumNumbers1(tree1));
        System.out.println(sumNumbers2(tree1));
    }
    
    //参考pathsum的思路，将其中ArrayList转变成String
    public static int sumNumbers1(TreeNode root) {
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder sBuilder= new StringBuilder();
        path(root,res,sBuilder);
        int sum=0;
        for(String s:res){
            sum+=Integer.parseInt(s);
        }
        return sum;
    }
    private static void path(TreeNode root,ArrayList<String> res,StringBuilder sBuilder){
        if(root==null) return;
        
        sBuilder.append(root.val);
        if(root.left==null && root.right==null){
            res.add(sBuilder.toString());
        }
        path(root.left,res,sBuilder);
        path(root.right,res,sBuilder);
        sBuilder.deleteCharAt(sBuilder.length()-1);
    }
    
    
    //霍纳法则
    static int res = 0;
    public static int sumNumbers2(TreeNode root) {
        if(root == null)  return 0; 
        sumnum(root,0);
        return res;
    }
    public static void sumnum(TreeNode root, int tmpsum) {
        if (root.left == null && root.right == null) {
            res += tmpsum * 10 + root.val;
        }
        if (root.left != null) {
            sumnum(root.left, tmpsum * 10 + root.val);
        }
        if (root.right != null) {
            sumnum(root.right, tmpsum * 10 + root.val);
        }
    }
}
