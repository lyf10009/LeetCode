package com.math;

public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		int n = 25;
		System.out.println(trailingZeroes(n));
	}
	public static int trailingZeroes(int n) {
        int num=0;
        int dep = 5;
        while(n>0){
        	num+=n/dep;
        	n/=5;
        }
		
		return num;
    }
}
