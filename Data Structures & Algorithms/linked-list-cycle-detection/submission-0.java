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
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p1 != null && p2 != null) {
            if (p1.val == p2.val) return true;
            if (p2.next == null) return false;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return false;
    }
}
