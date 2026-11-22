// Contains Duplicate II
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        int subtraction = 0;

        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(nums[i])) {
                subtraction = Math.abs(i - seen.get(nums[i]));

                if (subtraction <= k) {
                    return true;
                }
            }

            seen.put(nums[i], i);
        }

        return false;
    }
}