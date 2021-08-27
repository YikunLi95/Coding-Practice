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
    public int count = 0;
    
    public int goodNodes(TreeNode root) {
        DFS(root, Integer.MIN_VALUE);
        return count;
    }
    
    private void DFS(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            count++;
        }
        DFS(root.left, Math.max(max, root.val));
        DFS(root.right, Math.max(max, root.val));
    }
}
// TC: O(n)
// SC: O(height)
