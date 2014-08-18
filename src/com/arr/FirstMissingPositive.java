package com.arr;

public class FirstMissingPositive {
    /**
     * Given an unsorted integer array, find the first missing positive integer.
     * For example,
     * Given [1,2,0] return 3,
     * and [3,4,-1,1] return 2.
     * Your algorithm should run in O(n) time and uses constant space.
     */
    public static void main(String[] args) {
        int[] A={1};//{},{1},{2},{1,1}
        System.out.println(firstMissingPositive(A));
    }
    /**
     * 思路：交换数组元素，使得数组中第i位存放数值(i+1)。
     * 最后遍历数组，寻找第一个不符合此要求的元素，返回其下标。整个过程需要遍历两次数组，复杂度为O(n)。
     */
    public static int firstMissingPositive(int[] A) {
        if(A==null ||A.length<1) return 1;
        for(int i=0;i<A.length;){
            if(A[i]>0){
                if(A[i]!=i+1 && A[i]<A.length && A[A[i]-1]!=A[i]){
                    int tmp=A[i];
                    A[i]=A[tmp-1];
                    A[tmp-1]=tmp;
                }else{
                    i++;
                }
            }else{
                i++;
            }
        }
        for(int i=0;i<A.length;i++){
            if(A[i]!=i+1)  return i+1;
        }
        return A.length+1;
    }
}
