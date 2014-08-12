package com.arr;

public class JumpGameII {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Your goal is to reach the last index in the minimum number of jumps.
     * For example:
     * Given array A = [2,3,1,1,4]
     * The minimum number of jumps to reach the last index is 2.
     *  (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
     * @param args
     */
    public static void main(String[] args) {
        int[] num={2,3,1,1,4};
        System.out.println(jump(num));
    }
    
    public static int jump(int[] A){
        if (A == null || A.length == 0) return 0;
        int maxcover = 0;
        int step = 0;
        int lastcover = 0;
        for (int i = 0; i <= maxcover && i < A.length; i++) {
            if (i > lastcover) {
                step++;
                lastcover = maxcover;
            }
            if (A[i] + i > maxcover) maxcover = A[i] + i;
        }
        if (maxcover < A.length - 1) return 0;
        return step;
    }
}
