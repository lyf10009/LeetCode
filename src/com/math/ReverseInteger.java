package com.math;

public class ReverseInteger {

    /**
     * 翻转一个int型数字
     * 未考虑溢出情况
     */
    public static void main(String[] args) {
        reverse(-2147447412);
    }
    public static int reverse(int x) {
        System.out.println("初始值："+x);
        int res=0;
        while(x!=0){
            res=res*10+x%10;
            x=x/10;
        }
        System.out.println("翻转后："+res);
        return res;
    }
    public static int reverse1(int x) {
        String s=Integer.toString(x);
        StringBuilder sBuilder=new StringBuilder();
        if(s.startsWith("-")){
        	String[] arr=s.split("");//注意：划分后，第一个字符时""！！！！！
        	for(int i=arr.length-1;i>1;i--){
        		sBuilder.append(arr[i]);
        	}
        	System.out.println(sBuilder.toString());
        	
        	return 0-Integer.valueOf(sBuilder.toString());
        }else{
        	String[] arr=s.split("");
        	for(int i=arr.length-1;i>0;i--){
        		sBuilder.append(arr[i]);
        	}
        	return Integer.valueOf(sBuilder.toString()); 
        }
    }
}
