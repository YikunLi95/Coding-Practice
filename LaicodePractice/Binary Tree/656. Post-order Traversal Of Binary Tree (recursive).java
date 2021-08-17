/*
Implement a recursive, post-order traversal of a given binary tree, return the list of keys of each node in the tree as it is post-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

Post-order traversal is [1, 4, 3, 11, 8, 5]

Corner Cases
What if the given binary tree is null? Return an empty list in this case.
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
  public List<Integer> postOrder(TreeNode root) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
  }

  private void helper(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    helper(root.left, res);
    helper(root.right, res);
    res.add(root.key);
  }
}
// TC: O(n)
// SC: O(height)
