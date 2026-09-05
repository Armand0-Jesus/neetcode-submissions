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

// Binary Tree Inorder Traversal
class Solution {
    List<Integer> output = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inTraversal(root);
        return output;
    }

    public void inTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inTraversal(node.left);
        output.add(node.val);
        inTraversal(node.right);
    }
}