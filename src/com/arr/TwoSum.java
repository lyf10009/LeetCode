package com.arr;

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
}
