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

// Binary Tree Level Order Traversal
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> treeQueue = new ArrayDeque<>();
        treeQueue.add(root);

        while(!treeQueue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            
            for (int i = treeQueue.size(); i > 0; i--) {
                TreeNode node = treeQueue.poll();
                level.add(node.val);

                if (node.left != null) {
                    treeQueue.add(node.left);
                } 
                if (node.right != null) {
                    treeQueue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
        
    }
}
