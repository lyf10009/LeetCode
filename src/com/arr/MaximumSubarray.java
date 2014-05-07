package com.arr;

public class MaximumSubarray {

    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
     * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     * @param args
     */
    public static void main(String[] args) {
        int[] A={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(A));
    }
    
    //动态规划
    public static int maxSubArray(int[] A) {
        int sum = A[0], max = A[0];  
        for (int i = 1; i < A.length; i++) {  
            sum = sum < 0 ? A[i] : sum + A[i];  
            max = sum > max ? sum : max;  
        }  
        return max;  
    }
}
