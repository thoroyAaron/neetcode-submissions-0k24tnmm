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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode prev = head;
        ListNode now = null;
        if(head.next != null) now = head.next;
        ListNode next = null;
        while(now != null){
            next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }
        head.next = null;

        return prev;
    }
}
