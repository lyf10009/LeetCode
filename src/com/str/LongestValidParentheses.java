package com.str;

import java.util.Stack;

public class LongestValidParentheses {
    /**
     * Given a string containing just the characters '(' and ')', find the length of the longest
     * valid (well-formed) parentheses substring. For "(()", the longest valid parentheses substring
     * is "()", which has length = 2. Another example is ")()())", where the longest valid
     * parentheses substring is "()()", which has length = 4.
     */
    public static void main(String[] args) {
        String s = ")(())())()()()()((()()";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int maxLen = 0, last = -1;
        Stack<Integer> lefts = new Stack<Integer>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                lefts.push(i);
            } else {
                if (lefts.isEmpty()) {
                    // no matching left
                    last = i;
                } else {
                    // find a matching pair
                    lefts.pop();
                    if (lefts.isEmpty()) {//有一个完整的valid的group。计算该group的长度
                        maxLen = Math.max(maxLen, i - last);
                    } else {
                        //栈内还有‘(',一个最外层完整的group还没有匹配完成，
                        //但是通过查询下一个即将匹配还未匹配的"("的index来更新maxLen。
                        maxLen = Math.max(maxLen, i - lefts.peek());
                    }
                }
            }
        }
        return maxLen;
    }
}
