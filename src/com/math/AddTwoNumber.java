package com.math;

public class AddTwoNumber {
    /**
     * 不使用四则运算，计算两个数的和
     */
    public static void main(String[] args) {
        int num1=-123;
        int num2=234;
        System.out.println(add(num1, num2));
    }
    public static int add(int num1,int num2){
        int sum=0,carry=0;
        while(num2!=0){
            sum=num1 ^ num2;
            carry = (num1 & num2) <<1;
            
            num1=sum;
            num2=carry;
        }
        return num1;
    }
}
