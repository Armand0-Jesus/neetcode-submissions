// Longest Palindromic Substring
class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = checkPalindrome(s, i, i);
            int len2 = checkPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > right - left) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }

        return s.substring(left, right + 1);
    }

    public int checkPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
