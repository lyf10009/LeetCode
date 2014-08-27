package com;

public class BinaryHaveOnes {
    /**
     * �ж�һ�����Ķ��������а������ٸ�"1"
     */
    public static void main(String[] args) {
        int n=1024;
        System.out.println(numberOfOne1(n));
        System.out.println(numberOfOne2(n));
    }
    //�����������ÿλ���Ƿ���1��������count��1.
    //Ϊ�˷�ֹ������λʱ�Ĵ�������һ��flag����ÿ�ν�flag���ƣ����������Ƚ�
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
    
    //n &(n-1)����һ���������һ��"1"���"0"
    private static int numberOfOne2(int n){
        int count=0;
        while(n!=0){
            ++count;
          //�ص�
            n=(n-1) & n;
        }
        return count;
    }
}
