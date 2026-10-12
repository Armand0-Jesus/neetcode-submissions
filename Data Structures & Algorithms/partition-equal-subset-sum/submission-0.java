// Partition Equal Subset Sum
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int remaining = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][remaining + 1];
        return dfs(nums, 0, remaining, dp);
    }

     private boolean dfs(int[] nums, int index, int remaining, Boolean[][] dp) {
        if (remaining == 0) {
            return true;
        }

        if (remaining < 0 || index == nums.length) {
            return false;
        }

        if (dp[index][remaining] != null) {
            return dp[index][remaining];
        }

        boolean take = dfs(nums, index + 1, remaining - nums[index], dp);
        boolean skip = dfs(nums, index + 1, remaining, dp);
        return dp[index][remaining] = take || skip;
     }
}
