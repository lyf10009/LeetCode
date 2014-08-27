package com.tree;

import java.util.Stack;

import com.bean.TreeNode;

public class SymmetricTrees {

    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * For example, this binary tree is symmetric:
     *       1
     *      / \
     *     2   2
     *    / \ / \
     *   3  4 4  3
     * But the following is not:
     *         1
     *        / \
     *       2   2
     *        \   \
     *        3    3
     * Note:
     * Bonus points if you could solve it both recursively and iteratively.
     * @param args
     */
    public static void main(String[] args) {
        TreeNode tree1=new TreeNode(1);
        TreeNode tree2=new TreeNode(2);
        TreeNode tree3=new TreeNode(2);
        TreeNode tree4=new TreeNode(4);
        TreeNode tree5=new TreeNode(4);
        TreeNode tree6=new TreeNode(4);
        TreeNode tree7=new TreeNode(4);
        TreeNode tree8=new TreeNode(3);
        TreeNode tree9=new TreeNode(4);
        
        tree1.left=tree2;
        tree1.right=tree3;
        tree2.right=tree4;
        tree3.left=tree5;
        tree4.right=tree6;
        tree4.left=tree7;
        tree5.right=tree8;
        tree5.left=tree9;
        
        System.out.println(isSymmetric1(tree1));
        System.out.println(isSymmetric2(tree1));
    }
    
    //µÝ¹é
    public static boolean isSymmetric1(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left,root.right);
    }
    private static boolean isSymmetric(TreeNode root,TreeNode root1) {
        if(root==null && root1==null) return true;
        if((root!=null && root1==null)||(root==null && root1!=null)||(root.val!=root1.val)) return false;
        return isSymmetric(root.left, root1.right) && isSymmetric(root.right, root1.left);
    }
    
    //µü´ú
    public static boolean isSymmetric2(TreeNode root) {
        if(root==null) return true;
        TreeNode left=root.left;
        TreeNode right=root.right;
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();
        while(!st1.isEmpty()|| left!=null || !st2.isEmpty()|| right!=null){
            if(left!=null && right!=null){
                if(left.val!=right.val) return false;
                st1.push(left);
                left=left.left;
                
                st2.push(right);
                right=right.right;
            }else if(left==null && right==null){
                TreeNode tmp1=st1.pop();
                TreeNode tmp2=st2.pop();
                
                if(tmp1.right!=null && tmp2.left!=null){
                    left=tmp1.right;
                    right=tmp2.left;
                }else{
                    if((tmp1.right==null && tmp2.left!=null)||(tmp1.right!=null && tmp2.left==null)) return false;
                }
            }else{
                return false;
            }
        }        
        return true;
    }
}
