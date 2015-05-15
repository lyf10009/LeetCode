package com.math;

public class ReverseBits {

	public static void main(String[] args) {
		int num=1;
		System.out.println(1<<num);
		System.out.println(reverseBits(num));
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.bitCount(num));//统计一个整数 二进制表示时1的个数
	}
	public static int reverseBits(int num){
		String bitNum = Integer.toBinaryString(num);
		
		
		return 1;
	}
}
