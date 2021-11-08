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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        getHeight(root, res);
        return res;
    }
    
    private int getHeight(TreeNode root, List<List<Integer>> res) {
        // base case
        if (root == null) {
            return 0;
        }
        // recursive rule
        // get curr height
        int left = getHeight(root.left, res);
        int right = getHeight(root.right, res);
        int curHeight = Math.max(left, right) + 1;
        // set the right size of the res
        while (res.size() < curHeight) {
            res.add(new ArrayList<>());
        }
        res.get(curHeight - 1).add(root.val);
        return curHeight;
    }
}
// TC: O(n)
// SC: O(n)
