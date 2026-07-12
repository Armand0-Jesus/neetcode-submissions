// Container With Most Water
class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int output = 0;

        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            output = Math.max(output, area);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return output;
    }
}
