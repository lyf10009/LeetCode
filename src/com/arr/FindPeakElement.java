package com.arr;

public class FindPeakElement {

	public static void main(String[] args) {
		int[] nums={1,2};
		System.out.println(findPeakElement(nums));
	}
    public static int findPeakElement(int[] nums) {
    	for(int i=0;i<nums.length-1;i++){
    		if(nums[i]>nums[i+1]){
    			return i;
    		}
    	}
    	return nums.length-1;
    }
}
