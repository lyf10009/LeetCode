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
    
//    ��˸������⣬˼·�������£�
//    ��ʼ������dp�������Ա��Ϊ1��ÿ�������ȷ���һ���ǹ�
//    �������ұ����������i�����ӱȵ�i-1���ӵȼ��ߣ���dp[i] = dp[i-1] + 1
//    ������������������i�����ӱȵ�i+1���ӵȼ��ߣ������ǹ���i+1�ǹ��٣���dp[i] = dp[i + 1] + 1
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
        System.out.println("�����ң�"+Arrays.toString(dp));
        for (int i = ratings.length - 2; i >= 0; i--) { 
            if (ratings[i] > ratings[i + 1] && dp[i]<=dp[i+1]) {
                dp[i]=dp[i+1]+1;
            }
        }
        System.out.println("���ҵ���"+Arrays.toString(dp));
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res += dp[i];  
        }
        return res; 
    }
}
