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

// Binary Tree Postorder Traversal
class Solution {
    List<Integer> output = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postTraversal(root);
        return output;
    }

    public void postTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        postTraversal(node.left);
        postTraversal(node.right);
        output.add(node.val);
    }
}