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
    public ListNode mergeNodes(ListNode head) {
        ListNode current = head;
        ListNode prev = head;
        int sum = 0;
        while(current != null){
            sum+=current.val;
            
            if(prev!=current && current.val == 0){
                prev.val = sum;
                prev.next = current;
                if(current.next != null)
                prev = current;
                sum = 0;
            }
            

            current = current.next;
            
        }
        prev.next = null;
        
        
        return head;
    }
}