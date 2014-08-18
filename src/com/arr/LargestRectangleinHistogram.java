package com.arr;

import java.util.Stack;

public class LargestRectangleinHistogram {
    /**
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
     *    find the area of largest rectangle in the histogram.
     * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
     * The largest rectangle is shown in the shaded area, which has area = 10 unit.
     * For example,
     * Given height = [2,1,5,6,2,3],
     * return 10.
     */
    public static void main(String[] args) {
        int[] height={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(height));
    }
    //如果有当前的条比前一个小,那么让比这个柱子高的都出栈，同时比较出栈所有条形的最大面积。
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; ++i) {
            //如果高度递增，那么一次入栈。
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i);
            }
            //如果当前柱比栈顶的低，那么把栈顶的拿出来，计算所有已经出栈的最大面积。
            else {
                int start = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans = Math.max(ans, height[start] * width);
                --i;
            }
        }
         
        //循环过后栈中是递增的条目，计算在栈中递增条目的最大面积。
        while (!stack.isEmpty()) {
            int start = stack.pop();
            int width = stack.isEmpty() ? height.length : height.length - stack.peek() - 1;
            ans = Math.max(ans, height[start] * width);
        }
        return ans;
    }
}
