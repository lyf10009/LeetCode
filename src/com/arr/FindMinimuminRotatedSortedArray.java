package com.arr;

public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums={4,5,6,7,0,2,3};
		System.out.println(findMin(nums));
		System.out.println(findMin1(nums));
		System.out.println(findMinII(nums));
	}
    public static int findMin(int[] nums) {
    	for(int i=0;i<nums.length-1;i++){
    		if(nums[i]>nums[i+1]){
    			return nums[i+1];
    		}
    	}
    	return nums[0];
    }
    public static int findMin1(int[] nums) {
    	int len = nums.length;  
        int left = 0;  
        int right = len-1;  
        while(left<right){  
            if(nums[right]>=nums[left]){  
                break;  
            }  
            int mid = (left+right)/2;  
            if(nums[mid]<nums[left]){  
            	right = mid;  
            }  
            else{  
            	left = mid+1;  
            }  
        }  
        return nums[left];  
    }
    
    /**  允许数组中的元素重复  **/
    public static int findMinII(int[] nums) {
    	int len = nums.length;  
    	int left = 0;  
    	int right = len-1;  
    	while(left<right){  
    		if(nums[left]==nums[right]){
    			left++;
    			continue;
    		}
    		if(nums[right]>=nums[left]){  
    			break;  
    		}  
    		int mid = (left+right)/2;  
    		if(nums[mid]<nums[left]){  
    			right = mid;  
    		}  
    		else{  
    			left = mid+1;  
    		}  
    	}  
    	return nums[left];  
    }
}
