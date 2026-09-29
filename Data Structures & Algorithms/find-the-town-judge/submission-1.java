// Find the Town Judge
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] outgoing = new int[n + 1];
        int[] incoming = new int[n + 1];

        for (int[] relation : trust) {
            outgoing[relation[0]]++;
            incoming[relation[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (outgoing[i] == 0 && incoming[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}