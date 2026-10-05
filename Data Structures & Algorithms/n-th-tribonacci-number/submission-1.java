// N-th Tribonacci Number
class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int[] values = new int[n + 1];
        values[1] = 1;
        values[2] = 1;

        for (int i = 3; i <= n; i++) {
            values[i] = values[i - 1] + values[i - 2] + values[i - 3];
        }

        return values[n];
    }
}