package com.arr;

public class MajorityElement {

	public static void main(String[] args) {
		
	}
	
    public static int majorityElement(int[] nums) {
        int res = nums[0];
        int times=1;
        
        for(int i=1;i<nums.length;i++){
        	if(times==0){
        		res = nums[i];
        		times++;
        	}else if(res == nums[i]){
        		times++;
        	}else{
        		times--;
        	}
        }
        return res;
    }

}
