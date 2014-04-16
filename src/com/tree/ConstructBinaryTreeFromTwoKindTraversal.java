package com.tree;

import java.util.Arrays;

import com.bean.TreeNode;

public class ConstructBinaryTreeFromTwoKindTraversal {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] preorder= {1,2,3,4,7,5,6};
        int[] inorder = {3,4,2,7,1,5,6};
        int[] postorder={4,3,7,2,6,5,1};
        TreeNode head=buildTreeFromPreorderInorder(preorder,inorder);
        
//        System.out.println("根据先序遍历和中序遍历构建树");
//        System.out.println(BinaryTreePreorderTraversal.preorderTraversal(head).toString());//先序遍历
//        System.out.println(BinaryTreeInorderTraversal.inorderTraversal(head).toString());  //中序遍历
//        System.out.println(BinaryTreePostorderTraversal.postorderTraversal(head).toString());  //后序遍历
        
        System.out.println("根据后序遍历和中序遍历构建树");
        head=buildTreeFromPostorderInorder(postorder,inorder);
        
        System.out.println(BinaryTreePreorderTraversal.preorderTraversal(head).toString());//先序遍历
        System.out.println(BinaryTreeInorderTraversal.inorderTraversal(head).toString());  //中序遍历
        System.out.println(BinaryTreePostorderTraversal.postorderTraversal(head).toString());  //后序遍历
    }
    
    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * Note:
     * You may assume that duplicates do not exist in the tree.
     */
    public static TreeNode buildTreeFromPreorderInorder(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length<=0) return null;
        int root=preorder[0];
        int len=inorder.length;
        TreeNode head=new TreeNode(root);
        if(len==1) return head;
        int index=0;
        for(;index<len;index++){
            if(inorder[index]==root)  break;
        }
        int[] pre1=Arrays.copyOfRange(preorder, 1, index+1);
        int[] in1=Arrays.copyOfRange(inorder, 0, index);
        TreeNode left=buildTreeFromPreorderInorder(pre1,in1);
        head.left=left;

        int[] pre2=Arrays.copyOfRange(preorder, index+1, len);
        int[] in2=Arrays.copyOfRange(inorder, index+1, len);
        TreeNode right=buildTreeFromPreorderInorder(pre2,in2);
        head.right=right;
        return head;
    }
    
    
    /**
     * Given postorder and inorder traversal of a tree, construct the binary tree.
     * Note:
     * You may assume that duplicates do not exist in the tree.
     */
    public static TreeNode buildTreeFromPostorderInorder(int[] postorder, int[] inorder) {
        if(postorder==null || postorder.length<=0) return null;
        int len=inorder.length;
        int root=postorder[len-1];
        TreeNode head=new TreeNode(root);
        if(len==1) return head;
        int index=0;
        for(;index<len;index++){
            if(inorder[index]==root)  break;
        }
        int[] pre1=Arrays.copyOfRange(postorder, 0, index);
        int[] in1=Arrays.copyOfRange(inorder, 0, index);
        TreeNode left=buildTreeFromPostorderInorder(pre1,in1);
        head.left=left;
        
        int[] pre2=Arrays.copyOfRange(postorder, index, len-1);
        int[] in2=Arrays.copyOfRange(inorder, index+1, len);
        TreeNode right=buildTreeFromPostorderInorder(pre2,in2);
        head.right=right;
        return head;
    }
}
