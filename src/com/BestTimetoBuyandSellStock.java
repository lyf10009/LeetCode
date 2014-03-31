package com;

public class BestTimetoBuyandSellStock {

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
     *  design an algorithm to find the maximum profit.
     */
    public static void main(String[] args) {
        int[] prices={2,1,2,1,0,1,2};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int profit=0;
        int min=prices[0];
        for (int i = 1; i < prices.length; i++) {  
            profit = prices[i] - min > profit ? prices[i] - min : profit;  
            min = prices[i] < min ? prices[i] : min;  
        } 
        return profit;
    }
}
