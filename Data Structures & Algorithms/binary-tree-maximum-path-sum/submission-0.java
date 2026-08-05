/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Binary Tree Maximun=m Path Sum
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
       dfs(root);

       return maxSum;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(dfs(node.left), 0);
        int rightMax = Math.max(dfs(node.right), 0);
     
        int totalPathSum = node.val + leftMax + rightMax;
        maxSum = Math.max(maxSum, totalPathSum);

        return node.val + Math.max(leftMax, rightMax);
    }
}
