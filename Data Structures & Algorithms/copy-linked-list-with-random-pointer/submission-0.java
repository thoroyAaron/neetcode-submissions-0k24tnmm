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
        Map<Node, Node> m = new HashMap<>();
        Node dummy = head;

        while(head != null){
            m.put(head, new Node(head.val));
            head = head.next;
        }

        Node dummy1 = dummy;
        while(dummy != null){
            Node now = m.get(dummy);
            Node next = m.get(dummy.next);
            Node random = dummy.random == null ? null : m.get(dummy.random);

            now.next = next;
            now.random = random;
            dummy = dummy.next;
        }

        return m.get(dummy1);
    }
}
