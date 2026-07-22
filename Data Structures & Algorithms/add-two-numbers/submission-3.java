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
        ListNode res = new ListNode();
        boolean one_flag = false;
        ListNode dummy = res;
        while(l1 != null && l2 != null){
            int temp = 0;
            if(one_flag){
                temp = l1.val + l2.val + 1;
            } else {
                temp = l1.val + l2.val;
            }
            if(temp >= 10) {
                one_flag = true;
                temp = temp - 10;
            } else {
                one_flag = false;
            }
            res.next = new ListNode(temp);
            l1 = l1.next;
            l2 = l2.next;
            res = res.next;
        }
        if(l1 != null){
            while(l1 != null){
                int temp = 0;
                if(one_flag){
                    temp = l1.val + 1;
                } else {
                    temp = l1.val ;
                }
                if(temp >= 10) {
                    one_flag = true;
                    temp = temp - 10;
                } else {
                    one_flag = false;
                }
                res.next = new ListNode(temp);
                l1 = l1.next;
                res = res.next;
            }
        } else {
            while(l2 != null){
                int temp = 0;
                if(one_flag){
                    temp = l2.val + 1;
                } else {
                    temp = l2.val ;
                }
                if(temp >= 10) {
                    one_flag = true;
                    temp = temp - 10;
                } else {
                    one_flag = false;
                }
                res.next = new ListNode(temp);
                l2 = l2.next;
                res = res.next;
            }
        }
        if(one_flag){
            res.next = new ListNode(1);
        }
        return dummy.next;
    }
}
