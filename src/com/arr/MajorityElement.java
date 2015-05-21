package com.arr;

/**
 * 得到数组中个数超过一半的元素
 * @author fluo
 *
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] nums ={1,2,1,2,2,2,1};
		System.out.println(majorityElement(nums));
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
