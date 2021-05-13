/*
Insert a value in a sorted linked list.

Examples
L = null, insert 1, return 1 -> null
L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null
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
  public ListNode insert(ListNode head, int value) {
    // Write your solution here
    ListNode newNode = new ListNode(value);
    // case 1: insert before head
    if (head == null || head.value >= newNode.value) {
      newNode.next = head;
      return newNode;
    }

    // case 2: insert to the middle or after tail, add target node to the right position of cur node
    ListNode cur = head;
    while (cur.next != null && cur.next.value < value) {
      cur = cur.next;
    }
    newNode.next = cur.next;
    cur.next = newNode;
    return head;
  }
}

// TC: O(n) SC: O(1)
