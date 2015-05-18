package com.arr;

import com.util.ArrayUtil;

public class RotateArray {

	public static void main(String[] args) {
		int[] nums = ArrayUtil.generateNums(10);
		ArrayUtil.printArray(nums);
		rotate(nums, 12);
		ArrayUtil.printArray(nums);
	}

    public static void rotate(int[] nums, int k) {
    	if(nums == null || nums.length<1) return;
    	int len = nums.length;
    	k = k % len;
    	reverse(nums, 0, len-k-1);
    	reverse(nums, len-k, len-1);
    	reverse(nums, 0, len-1);
    }
    public static void reverse(int[] nums,int start,int end){
    	while(start<end){
    		int tmp=nums[start];
    		nums[start]=nums[end];
    		nums[end]=tmp;
    		
    		start++;
    		end--;
    	}
    }
}
