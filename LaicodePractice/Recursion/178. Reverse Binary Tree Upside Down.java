/*
Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left leaf nodes as the root.

Examples

        1

      /    \

    2        5

  /   \

3      4

is reversed to

        3

      /    \

    2        4

  /   \

1      5
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
  public TreeNode reverse(TreeNode root) {
    // Write your solution here
    if (root == null || root.left == null) {
      return root;
    }

    TreeNode newRoot = reverse(root.left);
    root.left.right = root.right;
    root.left.left = root;
    root.left = null;
    root.right = null;
    return newRoot;
  }
}
// TC: O(n) SC: O(height)
