package com.str;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		String version1 = "1";
		String version2 = "1.0";
		System.out.println(compareVersion(version1, version2));
		System.out.println(compareVersion1(version1, version2));
	}

	public static int compareVersion(String version1, String version2) {
		String[] vs1 = version1.split("\\.");
		String[] vs2 = version2.split("\\.");
		int len1 = vs1.length;
		int len2 = vs2.length;
		int len = Math.max(len1, len2);
		for (int i = 0; i < len; i++) {
			int num1 = i < len1 ? Integer.valueOf(vs1[i]) : 0;
			int num2 = i < len2 ? Integer.valueOf(vs2[i]) : 0;
			if (num1 > num2) {
				return 1;
			} else if (num1 < num2) {
				return -1;
			}
		}
		return 0;

	}

	public static int compareVersion1(String version1, String version2) {
		int val1, val2;
		int idx1 = 0, idx2 = 0;
		while (idx1 < version1.length() || idx2 < version2.length()) {
			val1 = 0;
			while (idx1 < version1.length()) {
				if (version1.charAt(idx1) == '.') {
					++idx1;
					break;
				}
				val1 = val1 * 10 + (version1.charAt(idx1) - '0');
				++idx1;
			}
			val2 = 0;
			while (idx2 < version2.length()) {
				if (version2.charAt(idx2) == '.') {
					++idx2;
					break;
				}
				val2 = val2 * 10 + (version2.charAt(idx2) - '0');
				++idx2;
			}
			if (val1 > val2)  return 1;
			if (val1 < val2)  return -1;
		}
		return 0;
	}
}
