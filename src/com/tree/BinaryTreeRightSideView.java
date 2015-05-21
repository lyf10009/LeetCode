package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.bean.TreeNode;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(3);
		TreeNode root3 = new TreeNode(5);
		TreeNode root4 = new TreeNode(4);
		
		root.left=root1;
		root.right = root2;
		root1.right = root3;
		root2.right=root4;
		
		System.out.println(rightSideView(root));
	}
    public static List<Integer> rightSideView(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(root==null) return res;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	int num=1;
    	for(int i=0;i<num;i++){
    		TreeNode tmp = queue.poll();
    		if(i==0) res.add(tmp.val);
    		
    		if(tmp.right!=null) queue.offer(tmp.right);
    		if(tmp.left!=null) queue.offer(tmp.left);
    		
    		if(i==num-1){
    			num=queue.size();
    			
    			i=-1;
    		}
    	}
    	return res;
    }
}
