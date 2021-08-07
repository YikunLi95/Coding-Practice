/*
Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any node (the start node and the end node can be the same). 

Assumptions

The root of the given binary tree is not null

Examples

   -1

  /    \

2      11

     /    \

    6    -14

one example of paths could be -14 -> 11 -> -1 -> 2

another example could be the node 11 itself

The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18
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
    // step 1: ask lchild and rchild for single path
    int left = DFS(root.left, max);
    int right = DFS(root.right, max);
    // step 2: deal with current level
    // cut the negative sum
    left = left < 0 ? 0 : left;
    right = right < 0 ? 0 : right;
    // maintain a globla max of path sum
    max[0] = Math.max(root.key + left + right, max[0]);
    // step 3: return a single path sum to the parent
    return root.key + Math.max(left, right);
  }
}
// TC: O(n) -> n represents the # of tree nodes
// SC: O(height)
