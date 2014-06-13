package com.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Given an array of integers, find two numbers such that they add up to a specific target
     * number. The function twoSum should return indices of the two numbers such that they add up to
     * the target, where index1 must be less than index2. Please note that your returned answers
     * (both index1 and index2) are not zero-based. You may assume that each input would have
     * exactly one solution. 
     * Input: 
     *    numbers={2, 7, 11, 15}, target=9 
     * Output: 
     *    index1=1, index2=2
     */
    public static void main(String[] args) {
        int target = 1;
        int[] numbers = {0, 1, 2, 3, 4};
        int[] result = twoSum(numbers, target);
        System.out.println("index1=" + result[0] + ",index2=" + result[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        //HashMap用来存放数组的下标和对应的值
        Map<Integer, Integer> ht = new HashMap<Integer, Integer>();
        int[] ret = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (ht.get(target - numbers[i]) != null) {
                ret[0] = ht.get(target - numbers[i]) + 1;
                ret[1] = i + 1;
            } else {
                ht.put(numbers[i], i);
            }
        }
        return ret;
    }

    //升序数组的时候可用
    public static int[] twoSum1(int[] numbers, int target) {
        int[] ret = new int[2];
        int start=0,end=numbers.length-1;
        while(start<end){
            if(numbers[start]+numbers[end]>target){
                end--;
            }else if(numbers[start]+numbers[end]<target){
                start++;
            }else{
                ret[0]=start;
                ret[1]=end;
                return ret;
            }
        }
        return ret;
    }
}
