package com.arr;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		int s=11;
		System.out.println(minSubArrayLen(s, nums));
		System.out.println(minSubArrayLen1(s, nums));
	}
	//找出最小的相等的子数组
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums ==null || nums.length <1) return 0;
    	int len = nums.length,minLen = Integer.MAX_VALUE;
        int left=0,right=0,sum = nums[0];
    	while(left<=right && right<=len-1){
    		if(nums[right]==s){
    			return 1;
    		}else if(nums[right]>s){
    			right++;
    			left=right;
    			sum=nums[right];
    		}else{
    			if(sum<s){
    				right++;
    				if(right>len-1) break;
    				sum+=nums[right];
    			}else if(sum>s){
    				sum-=nums[left];
    				left++;
    			}else{
    				minLen=Math.min(minLen, right-left+1);
    				left++;
    				if(left>right) break;
    				sum-=nums[left-1];
    			}
    		}
    	}
    	return minLen==Integer.MAX_VALUE?0:minLen;
    }
    
    //找出>=s的最小子数组
    public static int minSubArrayLen1(int s, int[] nums) {
    	int start = 0;  
        int end = 0;  
        int sum = 0;  
        int min = Integer.MAX_VALUE;  
        while(start<nums.length && end<nums.length) {  
            while(sum<s && end<nums.length) {  
                sum += nums[end++];  
            }  
            while(sum>=s && start<=end) {  
                min = Math.min(min, end-start);  
                sum -= nums[start++];  
            }  
        }  
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}
