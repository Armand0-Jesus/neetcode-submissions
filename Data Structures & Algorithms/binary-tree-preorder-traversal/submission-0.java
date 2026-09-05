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

 // Binary Tree Preorder Traversal
class Solution {
    List<Integer> output = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preTraversal(root);
        return output;
    }

    public void preTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        output.add(node.val);
        preTraversal(node.left);
        preTraversal(node.right);
    }
}