package com;

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
}
