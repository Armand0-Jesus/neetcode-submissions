// Best Time to Buy and Sell Stock with Cooldown
class Solution {
    int[][] memo;

    public int maxProfit(int[] prices) {
        memo = new int[prices.length][2];
        
        for (int[] price : memo) {
            Arrays.fill(price, -1);
        }

        return dfs(prices, 0, 1);
    }

    public int dfs(int[] prices, int index, int canBuy) {
        if (index >= prices.length) {
            return 0;
        }

        if (memo[index][canBuy] != -1) {
            return memo[index][canBuy];
        }

        int skip = dfs(prices, index + 1, canBuy);
        int action;

        if (canBuy == 1) {
            action = dfs(prices, index + 1, 0) - prices[index];
        } else {
            action = dfs(prices, index + 2, 1) + prices[index];
        }

        return memo[index][canBuy] = Math.max(skip, action);
    }
}
