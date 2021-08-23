/*
Check if a given binary tree is symmetric.

Examples

        5

      /    \

    3        3

  /   \    /   \

1      4  4      1

is symmetric.

        5

      /    \

    3        3

  /   \    /   \

1      4  1      4

is not symmetric.

Corner Cases
What if the binary tree is null? Return true in this case.
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
  public boolean isSymmetric(TreeNode root) {
    // Write your solution here
    if (root == null) {
      return true;
    }
    return isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode n1, TreeNode n2) {
    if (n1 == null && n2 == null) {
      return true;
    }
    if (n1 == null || n2 == null) {
      return false;
    }
    if (n1.key != n2.key) {
      return false;
    }
    
    return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
  }
}
// TC: O(n)
// SC: O(height)
