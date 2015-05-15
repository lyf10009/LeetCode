package com.math;

public class NumberOfOneByN {
    /**
     * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数
     * 例，输入12,1--12包含“1”的数有1、10、11、12，一共有5个1.
     * 所以返回5
     */
    public static void main(String[] args) {
        int n=21345;
        System.out.println(getNumberOfOne(n));
    }
    /**
     * n=21345，先将数字分成两段1-1345,1346-21345
     * 首先分析1出现在最高位(万位)，在1346-21345中，10000-19999这1万个数字中的万位中，1总共出现10000次(10的4次方)
     *     注，当万位是1时(例如12345)，1只出现在10000-12345的万位，只有2345+1个
     * 然后分析低位，例如1346-21345这20000个数字中后4位中出现1的次数是  2 * 1000次 * 4=8000。
     *     1346-21345分为1346-11345(4000次)，11346-21345(4000次)。
     *     确定一位，其他4为可以是0-9，就是10的3次方(1000次)
     */
    public static int getNumberOfOne(int n){
        if(n<=0) return 0;
        String strN=Integer.toString(n);
        int res2=numberOfOne(strN);
        return res2;
    }
    private static int numberOfOne(String strN){
        int first = strN.charAt(0)-'0';
        int len=strN.length();
        if(len==1 && first==0) return 0;
        if(len==1 && first>0) return 1;
        
        int numFirstDigit = 0;
        if(first>1){
            numFirstDigit=powerBase(len-1);
        }else if(first==1){
            String str=strN.substring(1, len);
            numFirstDigit = Integer.parseInt(str)+1;
        }
        int numOtherDigits=first * (len-1) *powerBase(len-2);
        int numRec = numberOfOne(strN.substring(1, len));
        System.out.println(numFirstDigit +"\t"+ numOtherDigits +"\t"+ numRec);
        return numFirstDigit + numOtherDigits + numRec;
    }
    private static int powerBase(int n){
        int res=1;
        for(int i=0;i<n;i++){
            res*=10;
        }
        return res;
    }
}
