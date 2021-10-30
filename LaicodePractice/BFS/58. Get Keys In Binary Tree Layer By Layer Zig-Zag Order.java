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
  public List<Integer> zigZag(TreeNode root) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.offerLast(root);
    int layer = 0;
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        if (layer % 2 == 0) {
          TreeNode curr = deque.pollLast();
          res.add(curr.key);
          if (curr.right != null) {
            deque.offerFirst(curr.right);
          }
          if (curr.left != null) {
            deque.offerFirst(curr.left);
          }
        } else {
          TreeNode curr = deque.pollFirst();
          res.add(curr.key);
          if (curr.left != null) {
            deque.offerLast(curr.left);
          }
          if (curr.right != null) {
            deque.offerLast(curr.right);
          }
        }
      }
      layer++;
    }
    return res;
  }
}
// TC: O(n)
// SC: O(n)
