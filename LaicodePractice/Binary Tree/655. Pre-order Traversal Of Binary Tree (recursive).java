/*
Implement a recursive, pre-order traversal of a given binary tree, return the list of keys of each node in the tree as it is pre-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

Pre-order traversal is [5, 3, 1, 4, 8, 11]

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
  public List<Integer> preOrder(TreeNode root) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    preOrder(root, res);
    return res;
  }

  private void preOrder(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }

    res.add(root.key);
    preOrder(root.left, res);
    preOrder(root.right, res);
  }
}
// TC: O(n) n represents the number of nodes in the recursion tree
// SC: O(h) h represents the height of the recurtion tree
