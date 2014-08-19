package com;

import java.util.ArrayList;

public class GrayCode {

    /**
     * The gray code is a binary numeral system where two successive values differ in only one bit.
     * Given a non-negative integer n representing the total number of bits in the code, 
     * print the sequence of gray code. A gray code sequence must begin with 0.
     * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
     * 00 - 0
     * 01 - 1
     * 11 - 3
     * 10 - 2
     * Note:
     * For a given n, a gray code sequence is not uniquely defined.
     * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
     * @param args
     */
    public static void main(String[] args) {
        int n=0;
        System.out.println(grayCode(n));
        System.out.println(grayCode1(n));
    }
    
    //迭代
    public static ArrayList<Integer> grayCode1(int n) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        int size=1<<n;//当n=0时，返回 1 !!!
        for(int i=0;i<size;i++){
            int gCode = i^(i>>1);
            res.add(gCode);
        }
        return res;
    }
    
    /**
     * 递归生成码表
     * 这种方法基于格雷码是反射码的事实，利用递归的如下规则来构造：
     * 1,1位格雷码有两个码字
     * 2,(n+1)位格雷码中的前2n个码字等于n位格雷码的码字，按顺序书写，加前缀0
     * 3,(n+1)位格雷码中的后2n个码字等于n位格雷码的码字，按逆序书写，加前缀1
     * @param n
     * @return
     */
    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        
        if(n==0) {
            res.add(0);
            return res;
        }
        
        grayCode(n, res);
        return res;
    }
    public static void grayCode(int n,ArrayList<Integer> res) {
        if(n==1){
            res.add(0);
            res.add(1);
        }else{
            res.addAll(grayCode(n-1));
            int plus=1<<(n-1);
            for(int i=plus-1;i>=0;i--){
                res.add(res.get(i)+plus);
            }
        }
    }
}
