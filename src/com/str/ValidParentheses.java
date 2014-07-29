package com.str;

import java.util.Stack;

public class ValidParentheses {
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */

    public static void main(String[] args) {
        String str = "([(";
        System.out.println(isValid(str));
    }
    public static boolean isValid(String s) {
        int len = s.length();
        if(len%2!=0) return false;
        Stack<Character> stack = new Stack<Character>();
        for(char c :s.toCharArray()){
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else{
                if(stack.empty()) return false;
                char tmp = stack.pop();
                if(!(c==')' && tmp=='(' || c==']' && tmp=='[' || c=='}' && tmp=='{')){
                  return false;  
                }
            }
        }
        if(stack.empty()){
            return true;
        }else{
            return false;
        }
    }
}
