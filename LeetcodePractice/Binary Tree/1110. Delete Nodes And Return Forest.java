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
    private boolean[] hash = new boolean[1001];
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i : to_delete) {
            hash[i] = true;
        }
        List<TreeNode> res = new ArrayList<>();
        if (!hash[root.val]) {
            res.add(root);
        }
        helper(root, res);
        return res;
    }
    
    private TreeNode helper(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return null;
        }
        root.left = helper(root.left, res);
        root.right = helper(root.right, res);
        if (hash[root.val]) {
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
            root = null;
        }
        return root;
    }
}
// TC: O(n)
// SC: O(n)
