package com.math;

import com.util.ArrayUtil;

public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = ArrayUtil.generateNums(5);
		ArrayUtil.printArray(nums);
		System.out.println(rob(nums));
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

}
