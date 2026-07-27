// Minimum Window Substring
class Solution {
    public String minWindow(String s, String t) {
        int [] mapS = new int[256];
        int[] mapT = new int[256];

        for (char c : t.toCharArray()) {
            mapT[c]++;
        }

        int left = 0;
        int right = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            mapS[s.charAt(right)]++;

            while (contains(mapS, mapT)) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                mapS[s.charAt(left++)]--;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    private boolean contains(int[] mapS, int[] mapT) {
        for (int i = 0; i < 256; i++) {
            if (mapS[i] < mapT[i]) {
                return false;
            }
        }
        return true;
    }
 }
