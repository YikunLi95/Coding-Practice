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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int babe = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (l1 != null || l2 != null || babe != 0) {
            if (l1 != null) {
                babe += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                babe += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(babe % 10);
            cur = cur.next;
            babe = babe / 10;
        }
        return dummy.next;
    }
}
// TC: O(max(m, n)) -> m, n represent the lengths of l1 and l2
// SC: O(max(m, n))
