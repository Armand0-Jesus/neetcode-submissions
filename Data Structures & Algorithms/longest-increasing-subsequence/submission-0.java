// Longest Increasing Subsequence
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int answer = 1;

        for (int i = 0; i < nums.length; i++) {
            lis[i] = 1;

            for (int left = 0; left < i; left++) {
                if (nums[left] < nums[i]) {
                    if (lis[left] + 1 > lis[i]) {
                        lis[i] = lis[left] + 1;
                    }
                }
            }
            answer = Math.max(answer, lis[i]);
        }

        return answer;
    }
}
