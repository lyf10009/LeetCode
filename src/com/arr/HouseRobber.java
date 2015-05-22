package com.arr;

import com.util.ArrayUtil;

public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = ArrayUtil.generateNums(5);
		ArrayUtil.printArray(nums);
		System.out.println(rob(nums));
		System.out.println(robII(nums));
	}
	
	public static int rob(int[] nums){
		if(nums == null || nums.length <1) return 0;
		int[] max = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			if(i==0){
				max[i]=nums[i];
			}else if(i==1){
				max[i]=Math.max(nums[i-1], nums[i]);
			}else{
				max[i]=Math.max(max[i-1], max[i-2]+nums[i]);
			}
		}
		return max[nums.length-1];
	}
	
	public static int robII(int[] nums){
		if(nums == null || nums.length <1) return 0;
		if(nums.length==1) return nums[0];
		return Math.max(rob(nums,0,nums.length-1), rob(nums, 1, nums.length));
	}
	public static int rob(int[] nums,int left,int right){
		if(nums == null || nums.length <1) return 0;
		int len = right-left;
		int[] max = new int[len];
		for(int i=0;i<len;i++,left++){
			if(i==0){
				max[i]=nums[left];
			}else if(i==1){
				max[i]=Math.max(nums[left-1], nums[left]);
			}else{
				max[i]=Math.max(max[i-1], max[i-2]+nums[left]);
			}
		}
		return max[len-1];
	}

}
