// Non-overlapping Intervals
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(index -> index[1]));
        int count = 0;
        int prevInterval = intervals[0][1];

        for (int index = 1; index < intervals.length; index++) {
            int start = intervals[index][0];
            int end = intervals[index][1];

            if (start < prevInterval) {
                count++;
            } else {
                prevInterval = end;
            }
        }

        return count;
    }
}
