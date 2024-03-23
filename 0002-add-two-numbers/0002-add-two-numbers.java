/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         int carry = 0, sum = 0;
         ListNode dummy = new ListNode();
         ListNode thead = dummy;
        
         while(l1 != null || l2 != null){
             sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
             carry = sum / 10;
             thead.next = new ListNode(sum % 10);
             thead = thead.next;
             
             if(l1 != null) l1 = l1.next;
             if(l2 != null) l2 = l2.next;
         }
        
         if(carry != 0) thead.next = new ListNode(carry);
        
        return dummy.next;  
    }
    
}