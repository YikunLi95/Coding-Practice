/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                cur.next = c1;
                c1 = c1.next;
                cur = cur.next;
            } else if (c1.val > c2.val) {
                cur.next = c2;
                c2 = c2.next;
                cur = cur.next;
            }
        }
        if (c1 == null) {
            cur.next = c2;
        } else if (c2 == null) {
            cur.next = c1;
        }
        return dummy.next;
    }
}
// TC: O(n) 
// SC: O(1)
