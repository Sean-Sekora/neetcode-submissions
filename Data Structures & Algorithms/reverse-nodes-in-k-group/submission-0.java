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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrevious = dummy;

        while (true) {
            ListNode kth = getKth(groupPrevious, k);
            if (kth == null) {
                break;
            }
            ListNode groupNext = kth.next;

            ListNode previous = kth.next;
            ListNode current = groupPrevious.next;
            while (current != groupNext) {
                ListNode tmp = current.next;
                current.next = previous;
                previous = current;
                current = tmp;
            }

            ListNode tmp = groupPrevious.next;
            groupPrevious.next = kth;
            groupPrevious = tmp;

        }

        return dummy.next;
    }

    private ListNode getKth(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
}
