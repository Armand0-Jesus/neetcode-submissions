// House Robber II
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int firstChoice = robHelper(nums, 0, nums.length - 2);
        int secondChoice = robHelper(nums, 1, nums.length - 1);

        return Math.max(firstChoice, secondChoice);
    }

    public int robHelper(int[] nums, int start, int end) {
        int house1 = 0;
        int house2 = 0;
            
        for (int i = start; i <= end; i++) {
            int temp = Math.max(house2, house1 + nums[i]);
            house1 = house2;
            house2 = temp;
        }

        return house2;
    }
}
