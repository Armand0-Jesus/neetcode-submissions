// Jump Game
class Solution {
    public boolean canJump(int[] nums) {
        int position = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= position) {
                position = i;
            }
        }

        return position == 0;
    }
}
