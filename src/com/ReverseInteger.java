package com;

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
}
