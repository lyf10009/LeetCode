package com.arr;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class MaximumGap {

	public static void main(String[] args) {
        Set<Integer> ssSet = new TreeSet<Integer>(new Comparator<Integer>() {
            public int compare(Integer s1, Integer s2) {
                return s1.compareTo(s2);
            }
        });
        ssSet.add(1);
        ssSet.add(2);
        ssSet.add(3);
        ssSet.add(4);
        ssSet.add(10);
        ssSet.add(11);
        
        System.out.println(ssSet);
	}
    public static int maximumGap(int[] nums) {
        if(nums==null || nums.length<2) return 0;
    	Arrays.sort(nums);//ÅÅĞò
        int max=0;
    	for(int i=0;i<nums.length-1;i++){
    		max=max>nums[i+1]-nums[i]?max:nums[i+1]-nums[i];
    	}
    	return max;
    }
}
