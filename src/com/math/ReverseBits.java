package com.math;

public class ReverseBits {

	public static void main(String[] args) {
		int num=1;
		System.out.println(1<<num);
		System.out.println(reverseBits(num));
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.bitCount(num));//ͳ��һ������ �����Ʊ�ʾʱ1�ĸ���
	}
	public static int reverseBits(int num){
		String bitNum = Integer.toBinaryString(num);
		
		
		return 1;
	}
}
