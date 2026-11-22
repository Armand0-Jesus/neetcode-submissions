// Majority Element
class Solution {
    public int majorityElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle = left + (right - left) / 2;

        Arrays.sort(nums);

        return nums[middle];
    }
}