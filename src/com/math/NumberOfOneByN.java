package com.math;

public class NumberOfOneByN {
    /**
     * ����һ������n�����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ���
     * ��������12,1--12������1��������1��10��11��12��һ����5��1.
     * ���Է���5
     */
    public static void main(String[] args) {
        int n=21345;
        System.out.println(getNumberOfOne(n));
    }
    /**
     * n=21345���Ƚ����ֳַ�����1-1345,1346-21345
     * ���ȷ���1���������λ(��λ)����1346-21345�У�10000-19999��1��������е���λ�У�1�ܹ�����10000��(10��4�η�)
     *     ע������λ��1ʱ(����12345)��1ֻ������10000-12345����λ��ֻ��2345+1��
     * Ȼ�������λ������1346-21345��20000�������к�4λ�г���1�Ĵ�����  2 * 1000�� * 4=8000��
     *     1346-21345��Ϊ1346-11345(4000��)��11346-21345(4000��)��
     *     ȷ��һλ������4Ϊ������0-9������10��3�η�(1000��)
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
