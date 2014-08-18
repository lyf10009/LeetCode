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
    //����е�ǰ������ǰһ��С,��ô�ñ�������ӸߵĶ���ջ��ͬʱ�Ƚϳ�ջ�������ε���������
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; ++i) {
            //����߶ȵ�������ôһ����ջ��
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i);
            }
            //�����ǰ����ջ���ĵͣ���ô��ջ�����ó��������������Ѿ���ջ����������
            else {
                int start = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans = Math.max(ans, height[start] * width);
                --i;
            }
        }
         
        //ѭ������ջ���ǵ�������Ŀ��������ջ�е�����Ŀ����������
        while (!stack.isEmpty()) {
            int start = stack.pop();
            int width = stack.isEmpty() ? height.length : height.length - stack.peek() - 1;
            ans = Math.max(ans, height[start] * width);
        }
        return ans;
    }
}
