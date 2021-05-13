/*
Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

Examples
L = null, is reordered to null
L = 1 -> null, is reordered to 1 -> null
L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
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
  public ListNode reorder(ListNode head) {
    // Write your solution here
    // corner case
    if (head == null || head.next == null) {
      return head;
    }

    // find mid node of linked list
    ListNode mid = findMid(head);
    ListNode midNext = mid.next;
    mid.next = null; // cut the original linkedlist from mid node

    // reverse second half
    ListNode subHead = reverse(midNext);

    // merge two linked list
    return merge(head, subHead);
  }

  private ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) { // even or odd number of ListNodes, order matters, NPE
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

  private ListNode merge(ListNode c1, ListNode c2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (c1 != null && c2 != null) {
      cur.next = c1;
      c1 = c1.next;
      cur = cur.next;
      cur.next = c2;
      c2 = c2.next;
      cur = cur.next;
    }
    while (c1 != null) {
      cur.next = c1;
      c1 = c1.next;
      cur = cur.next;
    }
    while (c2 != null) {
      cur.next = c2;
      c2 = c2.next;
      cur = cur.next;
    }
    return dummy.next;
  }
}

// TC: O(n) SC: O(1)
