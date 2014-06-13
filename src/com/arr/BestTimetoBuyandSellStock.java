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
     * ̰�ķ��������ǰ���Best Time to Buy and Sell Stock ��ͬ���ڣ�������Զ��������Ʊ��
     * �Ӷ�׬ȡ���Եļ۸������̰�ķ�������˼��������һ���ͼۣ�Ȼ���ڼ۸������ֲ���ߵ� ������һ��ļ�Ǯ���½��ˣ�ʱ���׳���Ʊ��Ȼ�����һ��ϵ͵ļ�Ǯ��Ϊ���룬���ż��㡣
     * Ҫע�����Ҫ�������һ�ε�����
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
     * �ȷֱ����ÿ�ַַ���Ӧ���������ӯ���浽����������������һ��forѭ���õ��ܵ����ӯ������������ÿ��ѭ���ĸ��Ӷȶ���O��n�����ܵĸ��Ӷ���Ȼ��O��n��.
     */
    public static int maxProfit3(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0];
        int[] left = new int[prices.length];//�����ߵ����ӯ��
        left[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);//����[1��i]����һ�ε����ӯ��
            min = Math.min(min, prices[i]);
        }
        int max = prices[prices.length - 1];
        int[] right = new int[prices.length];//����ұߵ����ӯ��
        right[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);//����[i, prices.length-2]����һ�ε����ӯ��
            max = Math.max(max, prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);//���������ӯ��
        }
        return profit;
    }
}
