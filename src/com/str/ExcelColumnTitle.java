package com.str;

public class ExcelColumnTitle {

	public static void main(String[] args) {
		int n = 26*2;
		System.out.println(convertToTitle(n));
	}
	
	//10进制 转化为26进制
    public static String convertToTitle(int n) {
        StringBuilder title = new StringBuilder();
    	while(n>0){
    		n--;
    		int c =n%26+65;
    		title.append((char)c);
    		n=n/26;
    	}
    	return title.reverse().toString();
    }
}
