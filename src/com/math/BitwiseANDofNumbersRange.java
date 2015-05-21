package com.math;

public class BitwiseANDofNumbersRange {

	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5, 7));
	}

	// 返回m、n之间所有数的位与结果
	public static int rangeBitwiseAnd(int m, int n) {
		int res = m;
		for (int i = m + 1; i <= n; i++) {
			res &= i;
		}
		return res;
	}

	public static int rangeBitwiseAnd1(int m, int n) {
		int offset = 0;
		while (m != 0 && n != 0) {
			if (m == n) {
				return m << offset;
			}
			m >>= 1;
			n >>= 1;
			offset++;
		}
		return 0;
	}
}
