package com.util;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtil {

	public static int[] generateNums(int length){
		int[] nums = new int[length];
		Random random = new Random();
		for(int i=0;i<length;i++){
			nums[i] = random.nextInt(length * 10);
		}
		return nums;
	}
	
	public static void printArray(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
}
