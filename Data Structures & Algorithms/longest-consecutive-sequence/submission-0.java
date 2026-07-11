// Longest Consecutive Sequence
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 1;

        if (nums.length == 0) return 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            else {
                int currentNumber = num;
                int subsequence = 1;
                while(set.contains(currentNumber + 1)) {
                    currentNumber++;
                    subsequence++;
                }
                longest = Math.max(longest, subsequence);
            }
        }
        return longest;
    }
}
