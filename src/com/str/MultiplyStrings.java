package com.str;

public class MultiplyStrings {
    /**
     * Given two numbers represented as strings, return multiplication of the numbers as a string.
     * Note: The numbers can be arbitrarily large and are non-negative.
     * ´óÊıÏà³Ë
     * @param args
     */
    public static void main(String[] args) {
        String num1="12",num2="234";
        System.out.println(multiply(num1, num2));
    }
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int len1=num1.length();
        int len2=num2.length();
        int[] arr1=new int[len1];
        int[] arr2=new int[len2];
        int[] res=new int[len1+len2];
        
        for(int i=0;i<len1;i++){
            arr1[i]=num1.charAt(i)-'0';
        }
        for(int i=0;i<len2;i++){
            arr2[i]=num2.charAt(i)-'0';
        }
        
        for(int i=0; i<len1; ++i){  
            for (int j=0; j<len2; ++j){  
                res[i+j+1] += arr1[i]*arr2[j];
            }
        }
        
        String ss = "";  
        for (int k=len1+len2-1; k>=0; --k){  
            if(k>0) res[k-1] += res[k]/10;  
            res[k] %= 10;  
            ss = res[k]+ss;  
        }  
        ss = ss.charAt(0)=='0'? ss.substring(1):ss;  
        return ss;
    }
}
