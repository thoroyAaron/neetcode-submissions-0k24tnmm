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
        if(head == null) return null;
        Node dummy = head;
        Node dummy1 = head;

        while(head != null){
            Node temp = new Node(head.val);
            Node next = head.next;
            head.next = temp;
            temp.next = next;
            head = next;
        }

        Node head_new = dummy.next;
        Node prev = null;
        while(dummy != null){
            Node random = dummy.random;
            // 添加random
            if(random == null){
                dummy.random = null; 
            } else {
                dummy.next.random = random.next;
            }
            // 删除多余节点
            if(prev == null){
                prev = dummy.next;
                dummy = dummy.next.next;
            } else {
                prev.next = dummy.next;
                prev = dummy.next;
                dummy = dummy.next.next;
            }
        }
        
        dummy1.next = null;

        return head_new;
    }
}
