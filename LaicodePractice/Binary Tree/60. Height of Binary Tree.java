/*
Find the height of binary tree.

Examples:

        5

      /    \

    3        8

  /   \        \

1      4        11

The height of above binary tree is 3.
*/

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public int findHeight(TreeNode root) {
    // Write your solution here
    if (root == null) {
      return 0;
    }

    int leftHeight = findHeight(root.left);
    int rightHeight = findHeight(root.right);
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
// TC: O(n) SC: O(height)
