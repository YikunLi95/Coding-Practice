/*
Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The merge sort algorithm should be used to solve this problem.

Examples
null, is sorted to null
1 -> null, is sorted to 1 -> null
1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
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
  public ListNode mergeSort(ListNode head) {
    // Write your solution here
    // corner/base case
    if (head == null || head.next == null) {
      return head;
    }
    // recursion rule
    // find middle node and cut half
    ListNode mid = findMid(head);
    ListNode midNext = mid.next;
    mid.next = null;
    // mergeSort left and right
    ListNode leftHead = mergeSort(head);
    ListNode rightHead = mergeSort(midNext);
    // merge two sorted linked list
    return merge(leftHead, rightHead);
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

  private ListNode merge(ListNode one, ListNode two) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    // move the smaller one
    while (one != null && two != null) {
      if (one.value <= two.value) {
        cur.next = one;
        one = one.next;
        cur = cur.next;
      } else {
        cur.next = two;
        two = two.next;
        cur = cur.next;
      }
    }
    // post processing
    while (one != null) {
      cur.next = one;
      one = one.next;
      cur = cur.next;
    }
    while (two != null) {
      cur.next = two;
      two = two.next;
      cur = cur.next;
    }
    return dummy.next;
  }
}
// TC: O(nlogn) SC: O(logn)
