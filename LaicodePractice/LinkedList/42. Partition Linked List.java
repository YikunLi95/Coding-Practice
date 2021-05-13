/*
Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes larger than or equal to target value T. The original relative order of the nodes in each of the two partitions should be preserved.

Examples
L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
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
  public ListNode partition(ListNode head, int target) {
    // Write your solution here
    // corner case
    if (head == null) {
      return head;
    }

    ListNode dummySmall = new ListNode(0);
    ListNode dummyLarge = new ListNode(0);
    ListNode smallTail = dummySmall;
    ListNode largeTail = dummyLarge;
    ListNode cur = head;

    while (cur != null) {
      if (cur.value < target) {
        smallTail.next = cur;
        smallTail = smallTail.next;
      } else {
        largeTail.next = cur;
        largeTail = largeTail.next;
      }
      cur = cur.next;
    }
    smallTail.next = dummyLarge.next;
    largeTail.next = null;
    return dummySmall.next;
  }
}

// TC: O(n) SC: O(1)
