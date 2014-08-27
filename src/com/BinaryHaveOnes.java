package com;

public class BinaryHaveOnes {
    /**
     * 判断一个数的二进制数中包含多少个"1"
     */
    public static void main(String[] args) {
        int n=1024;
        System.out.println(numberOfOne1(n));
        System.out.println(numberOfOne2(n));
    }
    //检查输入数字每位上是否是1，若是则count加1.
    //为了防止负数移位时的错误，设置一个flag数，每次将flag左移，与输入数比较
    private static int numberOfOne1(int n){
        int count=0;
        int flag=1;
        while(flag!=0){
            if((n & flag)!=0){
                count++;
            }
            flag=flag<<1;
        }
        return count;
    }
    
    //n &(n-1)：将一个数的最后一个"1"变成"0"
    private static int numberOfOne2(int n){
        int count=0;
        while(n!=0){
            ++count;
          //重点
            n=(n-1) & n;
        }
        return count;
    }
}
