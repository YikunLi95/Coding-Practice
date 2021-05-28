/*
Implement a recursive, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

In-order traversal is [1, 3, 4, 5, 8, 11]

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
  public List<Integer> inOrder(TreeNode root) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    inOrder(root, res);
    return res;
  }

  private void inOrder(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }

    inOrder(root.left, res);
    res.add(root.key);
    inOrder(root.right, res);
  }
}
// TC: O(n) SC: O(height)
