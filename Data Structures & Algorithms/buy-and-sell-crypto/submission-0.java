class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int profit = 0;
        int minBuy = prices[0];

        for (int price : prices) {
            profit = Math.max(profit, price - minBuy);
            minBuy = Math.min(minBuy, price);
        }

        return profit;
    }
}
