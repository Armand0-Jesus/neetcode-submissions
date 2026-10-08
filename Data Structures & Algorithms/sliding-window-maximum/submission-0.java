// Sliding Window Maximum
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        int right = 0;
        int left = 0;

        while (right < nums.length) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[right]) {
                queue.removeLast();
            }

            queue.addLast(right);

            if (left > queue.getFirst()) {
                queue.removeFirst();
            }

            if ((right + 1) >= k) {
                res[left] = nums[queue.getFirst()];
                left++;
            }

            right++;
        }

        return res;
    }
}
