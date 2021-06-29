/*
In a binary search tree, find the node containing the largest number smaller than the given target number.

If there is no such number, return -2^31.

Assumptions:

The given root is not null.
There are no duplicate keys in the binary search tree.
Examples

    5

  /    \

2      11

     /    \

    6     14

largest number smaller than 1 is Integer.MIN_VALUE(Java) or INT_MIN(c++)

largest number smaller than 10 is 6

largest number smaller than 6 is 5
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
  public int largestSmaller(TreeNode root, int target) {
    // Write your solution here
    int res = Integer.MIN_VALUE;
    while (root != null) {
      if (root.key >= target) {
        root = root.left;
      } else {
        res = root.key;
        root = root.right;
      }
    }
    return res;
  }
}
