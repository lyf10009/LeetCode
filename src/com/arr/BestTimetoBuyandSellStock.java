package com.arr;

public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0,2,5};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit3(prices));
    }


    /**
     * Say you have an array for which the ith element is the price of a given stock on day i. If
     * you were only permitted to complete at most one transaction (ie, buy one and sell one share
     * of the stock), design an algorithm to find the maximum profit.
     */
    public static int maxProfit1(int[] prices) {
        if (prices.length < 2) return 0;
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] - min > profit ? prices[i] - min : profit;
            min = prices[i] < min ? prices[i] : min;
        }
        return profit;
    }


    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you
     * like (ie, buy one and sell one share of the stock multiple times). However, you may not
     * engage in multiple transactions at the same time (ie, you must sell the stock before you buy again). 
     * 贪心法，本题和前面的Best Time to Buy and Sell Stock 不同在于，本题可以多次买卖股票，
     * 从而赚取所以的价格差。因此用贪心法，基本思想是锁定一个低价，然后在价格升到局部最高点 （即下一天的价钱就下降了）时候，抛出股票，然后把下一天较低的价钱作为买入，接着计算。
     * 要注意最后要处理最后一次的利润
     */
    public static int maxProfit2(int[] prices) {
        if (prices.length < 2) return 0;
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i-1]) continue;
            profit += prices[i-1] - min;
            min = prices[i];
        }
        profit += prices[prices.length-1]-min;
        return profit;
    }


    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * Note:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * 先分别计算每种分法对应的左右最大盈利存到两个数组里。最后再用一个for循环得到总的最大盈利。这样由于每个循环的复杂度都是O（n），总的复杂度仍然是O（n）.
     */
    public static int maxProfit3(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0];
        int[] left = new int[prices.length];//存放左边的最大盈利
        left[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);//计算[1，i]买卖一次的最大盈利
            min = Math.min(min, prices[i]);
        }
        int max = prices[prices.length - 1];
        int[] right = new int[prices.length];//存放右边的最大盈利
        right[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);//计算[i, prices.length-2]买卖一次的最大盈利
            max = Math.max(max, prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);//计算最大总盈利
        }
        return profit;
    }
}
