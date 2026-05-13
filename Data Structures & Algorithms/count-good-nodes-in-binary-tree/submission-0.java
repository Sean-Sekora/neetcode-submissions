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

class Solution {
    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        dfs(root, root.val, count);
        return count[0];
    }

    private void dfs(TreeNode node, int max, int[] count) {
        if (node == null) return;

        if (node.val >= max) {
            max = node.val;
            count[0]++;
        }
        dfs(node.left, max, count);
        dfs(node.right, max, count);
    }
}
