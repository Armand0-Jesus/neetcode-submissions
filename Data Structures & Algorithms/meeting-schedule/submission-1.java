/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

// Meeting Rooms
class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(index -> index.start));

        for (int index = 1; index < intervals.size(); index++) {
            Interval firstInterval = intervals.get(index - 1);
            Interval secondInterval = intervals.get(index);

            if (secondInterval.start < firstInterval.end) {
                return false;
            }
        }

        return true;
    }
}
