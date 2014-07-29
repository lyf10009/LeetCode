package com.arr;

public class TrappingRainWater {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     *  compute how much water it is able to trap after raining.
     *  For example,
     *  Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     */
    public static void main(String[] args) {
        int[] A={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(A));
    }
    public static int trap(int[] A) {
        // special case
        if (A == null || A.length == 0) return 0;
        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int i;
        // from left to right  
        int max = Integer.MIN_VALUE;
        for(i=0;i<len;i++){
            max=A[i]>max?A[i]:max;
            left[i]=max;
        }
        // from right to left
        max=A[len-1];
        for (i = len - 1; i >= 0; i--) {
            max=max>A[i]?max:A[i];
            right[i]=max;
        }
        // trapped water 
        int volume;
        for (volume = 0, i = 1; i <= len - 2; i++) {
            int tmp = Math.min(left[i], right[i]) - A[i];
            if (tmp > 0) {  
                volume += tmp;  
            }  
        }  
        return volume;  
    }
}
