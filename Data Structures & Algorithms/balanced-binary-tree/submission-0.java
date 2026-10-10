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

// Balanced Binary Tree
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

     public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (right == -1 || left == -1 || Math.abs(right - left) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}
