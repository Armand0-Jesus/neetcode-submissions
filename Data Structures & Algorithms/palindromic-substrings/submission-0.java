// Palindromic Substrings
class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int count1 = palindromeCount(s, i, i);
            int count2 = palindromeCount(s, i, i + 1);
            count += count1 + count2;
        }

        return count;
    }

    public int palindromeCount(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
