// Decode Ways
class Solution {
    public int numDecodings(String s) {
        int prev2 = 1;
        int prev1 = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int curr = 0;
            int oneDigit = s.charAt(i - 1) - '0';
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + oneDigit;

            if (oneDigit >= 1) {
                curr += prev1;
            }

            if (twoDigits >= 10 && twoDigits <= 26) {
                curr += prev2;
            }

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
