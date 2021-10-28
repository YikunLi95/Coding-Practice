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
    
    private void dfs(TreeNode root, int val, int[] count) {
        if (root == null) {
            return;
        }
        if (root.val >= val) {
            count[0]++;
            val = root.val;
        }
        dfs(root.left, val, count);
        dfs(root.right, val, count);
    }
}
// TC: O(n)
// SC: O(n) -> worst case
