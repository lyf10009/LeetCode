package com.math;

public class ReverseInteger {

    /**
     * ��תһ��int������
     * δ����������
     */
    public static void main(String[] args) {
        reverse(-2147447412);
    }
    public static int reverse(int x) {
        System.out.println("��ʼֵ��"+x);
        int res=0;
        while(x!=0){
            res=res*10+x%10;
            x=x/10;
        }
        System.out.println("��ת��"+res);
        return res;
    }
    public static int reverse1(int x) {
        String s=Integer.toString(x);
        StringBuilder sBuilder=new StringBuilder();
        if(s.startsWith("-")){
        	String[] arr=s.split("");//ע�⣺���ֺ󣬵�һ���ַ�ʱ""����������
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
