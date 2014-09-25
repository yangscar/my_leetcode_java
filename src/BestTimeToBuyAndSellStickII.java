public class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        for (int i=1;i<prices.length;i++){
           int diff= prices[i]-prices[i-1];
           max_profit += diff > 0? diff : 0;
        }
        return max_profit;
    }
}
