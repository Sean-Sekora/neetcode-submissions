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
    public void reorderList(ListNode head) {
        // Create a list of the nodes and use left/right pointers
        ListNode slow = head;
        ListNode fast = head.next;

        // Find the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode second = slow.next;
        slow.next = null;
        ListNode previous = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = previous;
            previous = second;
            second = tmp;
        }
        second = previous;

        // Merge two halves
        ListNode first = head;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}
