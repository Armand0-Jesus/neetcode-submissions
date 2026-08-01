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

// Lowest Common Ancestor in Binary Search Tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode curr = root;

        if (p.val > root.val && q.val > root.val) {
            curr = lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            curr = lowestCommonAncestor(root.left, p, q);
        } else {
            return curr;
        }
        return curr;
    }
}
