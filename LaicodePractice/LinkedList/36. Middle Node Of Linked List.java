/*
Find the middle node of a given linked list.

Examples
L = null, return null
L = 1 -> null, return 1
L = 1 -> 2 -> null, return 1
L = 1 -> 2 -> 3 -> null, return 2
L = 1 -> 2 -> 3 -> 4 -> null, return 2
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
  public ListNode middleNode(ListNode head) {
    // Write your solution here
    if (head == null || head.next == null) { // order matters, NPE
      return head;
    }
    // two pointers
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) { // order matters, NPE
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}

// TC: O(n) SC: O(1)
