package com;

import java.util.Stack;

public class MinStack {
	
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> min = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if(min.empty()){
        	min.push(x);
        }else{
        	min.push(Math.min(min.peek(), x));
        }
    }

    public void pop() {
    	stack.pop();
    	min.pop();
        
    }

    public int top() {
    	return stack.peek();
    }

    public int getMin() {
    	return min.peek();
    }
}
