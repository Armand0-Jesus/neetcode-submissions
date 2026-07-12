class Solution {
    public int maxArea(int[] heights) {
        int output = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int area = (right - left) * Math.min(heights[left], heights[right]);
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
