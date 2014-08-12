package com.arr;

import java.util.Stack;

public class JumpGame {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Determine if you are able to reach the last index.
     * For example:
     * A = [2,3,1,1,4], return true.
     * A = [3,2,1,0,4], return false.
     */
    public static void main(String[] args) {
        int[] num={2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,
                   4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,
                   4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7};
        System.out.println(canJump2(num));
    }
    public static boolean canJump1(int[] A) {
        int maxJump = 0;
        int lastJump = 0;
        int i = 0;
        int len = A.length;
        while (maxJump < len-1)
        {
            if (i+A[i] > maxJump) maxJump = i+A[i];
            if (i >= lastJump)
            {
                if (maxJump <= lastJump) return false;
                lastJump = maxJump;
            }
            i++;
        }
        return true;
    }
    public static boolean canJump2(int[] A) {  
        if (A.length <= 1)  return true;  
        int maxLen = 0;  
        int index = 0;  
        while (index <= maxLen) {  
            int a = A[index];  
            if (index + a > maxLen) {  
                maxLen = index + a;  
            }  
            if (maxLen >= A.length - 1) {  
                return true;  
            }  
            index++;  
        }  
        return false;  
    }  
    
    //³¬Ê±
    public static boolean canJumpTimeOut(int[] A) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        while(!stack.isEmpty()){
            int i = stack.pop();
            if(i==A.length) return true;
            int len = A[i];
            if(len+i+1>=A.length) return true;
            for(int j=1;j<=len;j++){
                stack.push(i+j);
            }
        }
        return false;
    }
}
