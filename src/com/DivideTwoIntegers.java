package com;

public class DivideTwoIntegers {
    /**
     * Divide two integers without using multiplication, division and mod operator.
     */
    public static void main(String[] args) {
        int dividend = -1212312;
        int divisor = -1;
        System.out.println(dividend+" / "+divisor+" = " + divide(dividend,divisor));
    }
    public static int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor == 0) return 0;
        if(divisor == 1) return dividend;
        if(divisor == -1) return 0-dividend;
        
        int res=0;
        long a = Math.abs((long)dividend);//��ֹȡ����ֵʱ���Խ�磬����Ϊlong��
        long b = Math.abs((long)divisor);
        if(b>a) return res;//���������ȳ���С��ֱ�ӷ���0
        
        int count=0;
        long sum=0;
        while(a>=b){
            count = 1;
            sum=b;
            while(sum+sum<=a){
                sum+=sum;
                count+=count;
            }
            a -=sum;
            res+=count;
        }
        
        boolean flag= true;//�жϽ������
        if(dividend>0&&divisor<0 || dividend<0&&divisor>0) flag = false;
        if(!flag){
            res = 0-res;
        }
        return res;
    }

}
