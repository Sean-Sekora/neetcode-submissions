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
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int carryOver = 0;

        while (l1 != null || l2 != null || carryOver != 0) {
            int v1 = (l1 == null) ? 0 : l1.val;
            int v2 = (l2 == null) ? 0 : l2.val;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            int val = v1 + v2 + carryOver;
            carryOver = val / 10;
            val = val - carryOver * 10;
            node.next = new ListNode(val);
            node = node.next;
        }

        return dummy.next;
    }
}
