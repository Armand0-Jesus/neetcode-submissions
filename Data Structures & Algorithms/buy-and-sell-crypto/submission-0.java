// Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int bestProfit = 0;

        while (right < prices.length) {
            int profit = prices[right] - prices[left];

            if (prices[right] > prices[left]) {
                bestProfit = Math.max(bestProfit, profit);
            } else {
                left = right;
            }
            right++;
        }
        return bestProfit;
    }
}
