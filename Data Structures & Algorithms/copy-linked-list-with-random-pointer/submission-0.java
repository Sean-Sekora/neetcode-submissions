/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        Node node = head;

        while (node != null) {
            if (!map.containsKey(node)) map.put(node, new Node(0));
            map.get(node).val = node.val;

            if (!map.containsKey(node.next)) map.put(node.next, new Node(0));
            map.get(node).next = map.get(node.next);

            if (!map.containsKey(node.random)) map.put(node.random, new Node(0));
            map.get(node).random = map.get(node.random);

            node = node.next;
        }

        return map.get(head);
    }
}
