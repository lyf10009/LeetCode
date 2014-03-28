package com;

public class PowAndSqrt {

    /**
     * 用其他方法实现pow和sqrt
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(pow(2,4));

    }
    public static double pow(double x, int n) {
        switch (n) {  
            case  0: return 1;  
            case  1: return x;  
            case -1: return 1 / x;  
        }  
        double temp = pow(x, n / 2);  
        return temp * temp * ((n & 1) == 0 ? 1 : (n > 0 ? x : 1 / x));
    }
    
    public static int sqrt(int x) {
        double ans = x;
        while(Math.abs(ans * ans - x) > 0.0001)
        {
            ans = (ans + x / ans) / 2;
        }
        return (int)ans;
    }
}
