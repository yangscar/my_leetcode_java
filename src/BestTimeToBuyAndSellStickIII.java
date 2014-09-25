/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;
        int[] profit = new int[prices.length];
        int minPrice = prices[0];
        for (int i=1; i< prices.length; ++i){
            profit[i] = Math.max(profit[i-1], prices[i]-minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        int maxPrice = prices[prices.length-1];
        int maxProfit = profit[prices.length-1];
        for (int i=prices.length-2; i>0;--i){
            maxProfit = Math.max(maxProfit, profit[i-1]+maxPrice-prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }
        return maxProfit;
    }
}
