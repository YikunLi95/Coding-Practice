/*
Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf node to another leaf node. If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).

Examples

  -15

  /    \

2      11

     /    \

    6     14

The maximum path sum is 6 + 11 + 14 = 31.
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
  public int maxPathSum(TreeNode root) {
    // Write your solution here
    int[] max = new int[] {Integer.MIN_VALUE};
    DFS(root, max);
    return max[0];
  }

  private int DFS(TreeNode root, int[] max) {
    if (root == null) {
      return 0;
    }
    // case 1: current node is leaf
    if (root.left == null && root.right == null) {
      return root.key;
    }
    // step 1: ask next level
    int left = DFS(root.left, max);
    int right = DFS(root.right, max);
    // case 2 + step 2: current node has two subtrees and deal with current level
    if (root.left != null && root.right != null) {
      max[0] = Math.max(root.key + left + right, max[0]);
      return root.key + Math.max(left, right);
    }
    // case 3: current node has only one subtree
    return root.left == null ? root.key + right : root.key + left;
  }
}
// TC: O(n) -> n represents the # of nodes
// SC: O(height) 
