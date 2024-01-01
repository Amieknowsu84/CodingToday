/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int carry;
    int sum;
    ListNode thead,head;
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         carry = 0; sum = 0;
         int val = 0;
         int l1Val = 0, l2Val = 0;
        
        while(l1 != null || l2 != null){
            l1Val = 0;
            l2Val = 0;
            
            if(l1 != null){
                l1Val = l1.val;
                 l1 = l1.next;
            }
            if(l2 != null){
                l2Val = l2.val;
                l2 = l2.next;
            }
            
            val = (l1Val + l2Val + carry);
            sum = val % 10; 
            carry = val / 10 ; 
            if(head == null){
                thead = new ListNode(sum);
                head = thead;
            }else{
                thead.next = new ListNode(sum);
                thead = thead.next;
            }
        }
        
        while(carry != 0){
            thead.next = new ListNode(carry);
            carry = carry/10;
        }
        
      return head;  
    }
    
}