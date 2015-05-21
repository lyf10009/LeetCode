package com.tree;

import java.util.Stack;

import com.bean.TreeNode;

public class BSTIterator {

	public Stack<TreeNode> cur=new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while(!cur.empty()){
        	cur.pop();
        }
        while(root!=null){
        	cur.push(root);
        	root=root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !cur.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = cur.pop();
        int val = tmp.val;
        tmp = tmp.right;
        while(tmp!=null){
        	cur.push(tmp);
        	tmp=tmp.left;
        }
        return val;
    }
}
