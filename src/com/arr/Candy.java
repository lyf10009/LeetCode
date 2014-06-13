package com.arr;

import java.util.Arrays;

public class Candy {

    public static void main(String[] args) {
        int[] ratings={5,2,1,2,3,5,4,3,3,1,5,5,6};
        System.out.println(candy(ratings));
    }
    /**
     * There are N children standing in a line. Each child is assigned a rating value.
     * You are giving candies to these children subjected to the following requirements:
     * Each child must have at least one candy.
     * Children with a higher rating get more candies than their neighbors.
     * What is the minimum candies you must give?
     */
    
//    因此根据题意，思路可以如下：
//    初始化数组dp，数组成员均为1，每个孩子先分配一个糖果
//    从左向右遍历，如果第i个孩子比第i-1孩子等级高，则dp[i] = dp[i-1] + 1
//    从右向左遍历，如果第i个孩子比第i+1孩子等级高，并且糖果比i+1糖果少，则dp[i] = dp[i + 1] + 1
    public static int candy(int[] ratings){
        if (ratings == null || ratings.length == 0)  return 0;      
        int[] dp = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++){
            dp[i]=1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i]=dp[i-1]+1;
            }
        }
        System.out.println("从左到右："+Arrays.toString(dp));
        for (int i = ratings.length - 2; i >= 0; i--) { 
            if (ratings[i] > ratings[i + 1] && dp[i]<=dp[i+1]) {
                dp[i]=dp[i+1]+1;
            }
        }
        System.out.println("从右到左："+Arrays.toString(dp));
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res += dp[i];  
        }
        return res; 
    }
}
