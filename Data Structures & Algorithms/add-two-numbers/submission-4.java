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
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 == null) {
                val = l2.val + carryOver;
                l2 = l2.next;
            } else if (l2 == null) {
                val = l1.val + carryOver;
                l1 = l1.next;
            } else {
                val = l1.val + l2.val + carryOver;
                l1 = l1.next;
                l2 = l2.next;
            }
            carryOver = val / 10;
            val = val - carryOver * 10;
            node.next = new ListNode(val);
            node = node.next;
        }
        if (carryOver > 0) node.next = new ListNode(carryOver);
        return dummy.next;
    }
}
