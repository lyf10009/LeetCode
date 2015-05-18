package com.str;

public class TitleToNumber {

	public static void main(String[] args) {
		String s="ABC";
		System.out.println(titleToNumber(s));
	}
    public static int titleToNumber(String s) {
    	int len = s.length();
    	double sum=0;
    	for(int i=0;i<len;i++){
    		double num=(s.charAt(i)-64)*Math.pow(26, len-i-1);
    		sum+=num;
    	}
        
    	return (int)sum;
    }
}
