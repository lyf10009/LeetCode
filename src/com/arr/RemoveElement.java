package com.arr;

import java.util.Arrays;

public class RemoveElement {

	/**
	 * Given an array and a value, remove all instances of that value in place 
	 * and return the new length.
	 * The order of elements can be changed. It doesn't matter what you leave beyond 
	 * the new length.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A={1,2,1,5,1,6,8,69,98,1};
		int elem=1;
		
		System.out.println("变化前："+Arrays.toString(A));
		System.out.println("new length:"+removeElement(A,elem));
	}
    public static int removeElement(int[] A, int elem) {
        int num=0;
    	for(int i=0;i<A.length;i++){
        	if(A[i]!=elem){
        		A[num]=A[i];
        		num++;
        	}
        }
        System.out.println("变化后："+Arrays.toString(A));
    	return num;
    }
}
