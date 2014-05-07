package com;

public class ClimbingStairs {

    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * 分析后，应该是求斐波那契数列
     * F(n)=      n         (n<=2)
     *       F(n-1)+F(n-2)  (n>2)
     * @param args
     */
    public static void main(String[] args) {
        for(int i=1;i<7;i++){
            System.out.println(climbStairs2(i));
        }
    }
    
    //递归实现   超时
    public static int climbStairs1(int n) {
        if(n<=2) return n;       
        return climbStairs1(n-1)+climbStairs1(n-2);
    }

    
    //迭代实现
    public static int climbStairs2(int n) {
        if(n<=2) return n;
        int prePreNum=1,preNum=2;
        for(int i=3;i<n;i++){
            int tmp=prePreNum+preNum;
            prePreNum=preNum;
            preNum=tmp;
        }
        return preNum+prePreNum;
    }
}
