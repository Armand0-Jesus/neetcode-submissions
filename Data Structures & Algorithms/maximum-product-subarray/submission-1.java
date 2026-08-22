// Maximun Product Subarray
class Solution {
    public int maxProduct(int[] nums) {
        int leftProduct = 1;
        int rightProduct = 1;
        int res = nums[0];

        for (int i = 0; i < nums.length; i++) {
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[nums.length - 1 - i];
            
            res = Math.max(Math.max(leftProduct, rightProduct), res);
        }

        return res;
    }
}
