package com.tree;

import java.util.Stack;
import com.bean.TreeNode;

public class FlattenBinaryTreetoLinkedList {

    public static void main(String[] args) {
        TreeNode tree1=new TreeNode(1);
        TreeNode tree2=new TreeNode(2);
        TreeNode tree3=new TreeNode(3);
        TreeNode tree4=new TreeNode(4);
        TreeNode tree5=new TreeNode(5);
        TreeNode tree6=new TreeNode(6);
        
        tree1.left=tree2;
        tree1.right=tree5;
        tree2.left=tree3;
        tree2.right=tree4;
        tree5.right=tree6;
        
        flatten(tree1);
        System.out.println(BinaryTreeInorderTraversal.inorderTraversal1(tree1).toString());
    }
    /**
     * Given a binary tree, flatten it to a linked list in-place.
     * For example,
     * Given
     *          1
     *         / \
     *        2   5
     *       / \   \
     *      3   4   6
     * The flattened tree should look like
     *    1
     *     \
     *      2
     *       \
     *        3
     *         \
     *          4
     *           \
     *            5
     *             \
     *              6
     * Hints:
     * If you notice carefully in the flattened tree, 
     * each node's right child points to the next node of a pre-order traversal.
     * @param root
     */
    public static void flatten(TreeNode root) {
        if(root == null)  return;  
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        stack.push(root);  
        TreeNode lastNode = null;  
        while (!stack.isEmpty()) {  
            TreeNode node = stack.pop();  
            if (lastNode != null) {  
                lastNode.left = null;  
                lastNode.right = node;  
            }  
            lastNode = node;  
            TreeNode left = node.left;  
            TreeNode right = node.right;  
            if (right != null) {  
                stack.push(right);  
            }  
            if (left != null) {  
                stack.push(left);  
            }  
        }  
    }
}
