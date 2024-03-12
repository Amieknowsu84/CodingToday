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
    public ListNode removeZeroSumSublists(ListNode head) {
       ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode current = dummy;
        
        while (current != null && current.next != null) {
            ListNode temp = current.next;
            int sum = 0;
            while (temp != null) {
                sum += temp.val;
                if (sum == 0) {
                    current.next = temp.next;
                    break;
                }
                temp = temp.next;
            }
            if (sum != 0) {
                current = current.next;
            }
        }
        
        return dummy.next;
    }
}