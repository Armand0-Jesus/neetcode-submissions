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

// Construct Binary Tree from Preorder and Inorder Traversal
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return splitTree(preorder, inOrderMap, 0, 0, inorder.length - 1);
    }

    public TreeNode splitTree(int[] preorder, Map<Integer, Integer> inOrderMap,
                             int rootIndex, int left, int right) {

        TreeNode root = new TreeNode(preorder[rootIndex]);
        int middle = inOrderMap.get(preorder[rootIndex]);

        if (middle > left) {
            root.left = splitTree(preorder, inOrderMap,
            rootIndex + 1, left, middle - 1);
        } 

        if (middle < right) {
            root.right = splitTree(preorder, inOrderMap,
            rootIndex + middle - left + 1, middle + 1, right);
        }

        return root;
    }
}
