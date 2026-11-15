// Coin Change II
// Coin Change II
class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            memo[i][0] = 1;
        }

        for (int coin = coins.length - 1; coin >= 0; coin--) {
            for (int i = 1; i <= amount; i++) {
                memo[coin][i] = memo[coin + 1][i];

                if (i >= coins[coin]) {
                    memo[coin][i] += memo[coin][i - coins[coin]];
                }
            }
        }

        return memo[0][amount];
    }
}