package com.tree;

import com.bean.TreeNode;

public class RecoverBinarySearchTree {
    /**
     * Two elements of a binary search tree (BST) are swapped by mistake.
     * Recover the tree without changing its structure.
     * Note:
     * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
     * ���������������Ϸ����������ڵ��ֵ�������ˣ��ҳ��������ڵ㲢�Ҳ��ı����Ľṹ��ʹ�ö���������Ϸ��������ռ����ơ�
     */
    public static void main(String[] args) {

    }
    static TreeNode mistake1, mistake2,pre; 
    public static void recoverTree(TreeNode root) {  
        //pre������Ϊnull��ͨ��������ʱ�����ȥ����Ϊ���������������preӦ�������Ҷ���������ĸ��ڵ㡣  
        recursiveTraversal(root);  
        if(mistake1!=null && mistake2!=null) {
            //������������ڵ��value
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
