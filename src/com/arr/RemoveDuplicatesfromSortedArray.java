package com.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesfromSortedArray {
	
	public static void main(String[] args) {
		int[] A={1,2,1,5,1,6,8,69,98,1};
		
//		System.out.println("变化前："+Arrays.toString(A));
//		removeDuplicatesII(A);
//		System.out.println("变化后："+Arrays.toString(A));
		
		int i=123;
		String s1="123abc";
		String s2=i+"ab"+"c";
		
		System.out.println(s1+",");
		System.out.println(s2+",");
		System.out.println(s1==s2);

	}
	/**
	 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	 * Do not allocate extra space for another array, you must do this in place with constant memory.
	 * For example,
	 * Given input array A = [1,1,2],
	 * Your function should return length = 2, and A is now [1,2].
	 * @param A
	 */
    public static int removeDuplicatesI(int[] A) {
    	Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int num=0;
    	for(int i=0;i<A.length;i++){
        	if(map.get(A[i])==null){
        		A[num]=A[i];
        		map.put(A[num],1);
        		num++;
        	}
        }
    	return num;
    }
    /**
     * Follow up for "Remove Duplicates":
     * What if duplicates are allowed at most twice?
     * For example,
     * Given sorted array A = [1,1,1,2,2,3],
     * Your function should return length = 5, and A is now [1,1,2,2,3].
     * @param A
     */
    public static int removeDuplicatesII(int[] A) {
    	Map<Integer,Integer> map = new HashMap<Integer, Integer>();
    	int num=0;
    	for(int i=0;i<A.length;i++){
    		if(map.get(A[i])==null){
    			A[num]=A[i];
    			map.put(A[num],1);
    			num++;
    		}else if(map.get(A[i])==1){
    			A[num]=A[i];
    			map.put(A[num],2);
    			num++;
    		}
    	}
    	return num;
    }
}
