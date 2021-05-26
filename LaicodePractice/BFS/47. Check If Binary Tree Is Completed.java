/*
Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.

Examples

        5

      /    \

    3        8

  /   \

1      4

is completed.

        5

      /    \

    3        8

  /   \        \

1      4        11

is not completed.

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
  public boolean isCompleted(TreeNode root) {
    // Write your solution here
    // corner case
    if (root == null) {
      return true;
    }

    Queue<TreeNode> q = new ArrayDeque<>();
    boolean flag = false;
    q.offer(root);
    while (!q.isEmpty()) {
      TreeNode cur = q.poll();
      if (cur.left == null) {
        flag = true;
      } else if (flag) {
        return false;
      } else {
        q.offer(cur.left);
      }

      if (cur.right == null) {
        flag = true;
      } else if (flag) {
        return false;
      } else {
        q.offer(cur.right);
      }
    }
    return true;
  }
}
// TC: O(n) SC: O(n)
