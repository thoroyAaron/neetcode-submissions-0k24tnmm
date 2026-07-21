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
        List<ListNode> ll = new LinkedList<>();
        ListNode dummy = head;
        int length = 0;
        while(head != null){
            ll.addFirst(head);
            head = head.next;
            length = length + 1;
        }
        for(int i = 0; i < length / 2; i++){
            ListNode removeItem = ll.removeFirst();
            ListNode nextItem = dummy.next;
            dummy.next = removeItem;
            removeItem.next = nextItem;
            dummy = nextItem;
        }
        dummy.next = null;
    }   
}
