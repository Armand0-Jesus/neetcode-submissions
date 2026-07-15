// Longest Repeating Character Replacement
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int longestRepeat = 0;

        while (right < s.length()) {
            count[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);
            int windowSize = right - left + 1;

            if (windowSize - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            windowSize = right - left + 1;
            longestRepeat = Math.max(longestRepeat, windowSize);
            right++;
        }
        return longestRepeat;
    }
}
