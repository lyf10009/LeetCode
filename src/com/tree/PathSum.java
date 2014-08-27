package com.tree;

import java.util.ArrayList;
import com.bean.TreeNode;

public class PathSum {

    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
     * such that adding up all the values along the path equals the given sum.
     * For example:
     * Given the below binary tree and sum = 22,
     *        5
     *       / \
     *      4   8
     *     /   / \
     *    11  13  4
     *   /  \      \
     *  7    2      1
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
        
//        System.out.println(hasPathSum(tree1, 10));
        System.out.println(pathSum(tree1, 10));
    }
    
    //递归    
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left==null && root.right==null){
            return root.val==sum;
        }else{
            return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
        }
    }
    
    /**
     * @return 所有满足条件的路径
     */
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp=new ArrayList<Integer>();
        sumAll(root,sum,tmp,res);
        return res;
    }
    
    //列举所有路径
    private static void sumAll(TreeNode root,int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {  
        if (root == null) return;  
        list.add(root.val);  
        if (root.left == null && root.right == null) {
            if(root.val==sum)//若满足条件，则将路径加入结果列表中
                res.add(new ArrayList<Integer>(list));  
        }  
        sumAll(root.left,sum-root.val, list, res);
        sumAll(root.right,sum-root.val, list, res);
        list.remove(list.size() - 1);  //删除最后一个节点，还原结果列表
    } 
}
