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

// SubTree of Another Tree
class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (treeValidation(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean treeValidation(TreeNode tree, TreeNode subTree) {
        if (tree == null && subTree == null) {
            return true;
        }
        if (tree == null || subTree == null) {
            return false;
        }
        if (tree.val != subTree.val) {
            return false;
        }

        return treeValidation(tree.left, subTree.left) && treeValidation(tree.right, subTree.right);
    }
}
