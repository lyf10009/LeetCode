package com.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappyNumber(2));

	}
	public static boolean isHappyNumber(int num){
		if(num<1) return false;
		if(num==1) return true;
//		Set<Integer> set = new HashSet<Integer>();
		
		while(num<Integer.MAX_VALUE){
//			if(set.contains(num)){
//				return false;
//			}else{
//				set.add(num);
//			}
			
			//在当前数小于6的情况下结束while循环，然后判断当前数是否是1
			if(num<6){
				if(num==1){
					return true;
				}else{
					return false;
				}
			}
			int sum=0;
			while(num!=0) {  
	            sum += Math.pow(num%10, 2);  
	            num /= 10;  
	        }
			num=sum;
			if(num==1)return true;
		}
		return false;
	}
}
