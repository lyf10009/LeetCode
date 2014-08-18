package com.tree;

import com.bean.TreeNode;

public class RecoverBinarySearchTree {
    /**
     * Two elements of a binary search tree (BST) are swapped by mistake.
     * Recover the tree without changing its structure.
     * Note:
     * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
     * 题意二叉查找树不合法，有两个节点的值被交换了，找出这两个节点并且不改变树的结构，使得二叉查找树合法，常数空间限制。
     */
    public static void main(String[] args) {

    }
    static TreeNode mistake1, mistake2,pre; 
    public static void recoverTree(TreeNode root) {  
        //pre必须设为null，通过遍历的时候设进去。因为是中序遍历，所以pre应该是深层叶子左子树的父节点。  
        recursiveTraversal(root);  
        if(mistake1!=null && mistake2!=null) {
            //交换两个错误节点的value
            int tmp = mistake1.val;
            mistake1.val = mistake2.val;  
            mistake2.val = tmp;  
        }  
    }  
    private static void recursiveTraversal(TreeNode root) {  
        if(root==null) return;  
        recursiveTraversal(root.left);  
        if(pre!=null&&root.val<pre.val) {  
            if(mistake1==null) {  
                mistake1 = pre;  
                mistake2 = root;  
            } else {  
                mistake2 = root;  
            }  
        }  
        pre = root;  
        recursiveTraversal(root.right);  
    }  
}
