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
    
    // 1->2->3->4->5 
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode left = head, right = head;
        int cnt = 0;
        while(cnt++<n){
            right = right.next;
        }
        
        //edge case when 1 or 2 elem 
        if(right == null){
            if(left.next == null){
                return null;
            }else{
                return left.next;
            }
        }   
            
        
        while(right.next != null){
            left = left.next;
            right = right.next;
        }
    
        left.next = left.next.next;
        
        return head;
        
    }
}