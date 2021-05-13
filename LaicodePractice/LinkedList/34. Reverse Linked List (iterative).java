/*
Reverse a singly-linked list iteratively.

Examples
L = null, return null
L = 1 -> null, return 1 -> null
L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
*/

/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode reverse(ListNode head) {
    // Write your solution here
    // corner case
    if (head == null || head.next == null) { // order matters, in case NPE
      return head;
    }
    // reverse
    // initialization
    ListNode pre = null;
    ListNode nxt = null;
    ListNode cur = head;

    while (cur != null) {
      nxt = cur.next; // assign nxt 1st to avoid dereferencing nxt
      cur.next = pre; // reverse cur node
      pre = cur;
      cur = nxt;
    }
    return pre;
  }
}

// TC: O(n) SC: O(1)
