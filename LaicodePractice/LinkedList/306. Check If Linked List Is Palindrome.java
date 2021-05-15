/*
Given a linked list, check whether it is a palindrome.

Examples:
Input:   1 -> 2 -> 3 -> 2 -> 1 -> null
output: true.
Input:   1 -> 2 -> 3 -> null  
output: false.

Requirements:
Space complexity must be O(1)
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
  public boolean isPalindrome(ListNode head) {
    // Write your solution here
    // corner case
    if (head == null || head.next == null) {
      return true;
    }

    ListNode mid = findMid(head);
    ListNode tail = reverse(mid.next);
    while (tail != null) {
      if (head.value == tail.value) {
        head = head.next;
        tail = tail.next;
      } else {
        return false;
      }
    }
    return true;
  }

  private ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) { 
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode reverse(ListNode head) {
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
