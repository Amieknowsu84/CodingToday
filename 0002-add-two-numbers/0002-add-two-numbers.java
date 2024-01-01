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
        
        while(l1 != null && l2 != null){
            val = (l1.val + l2.val + carry);
            sum = val % 10; 
            carry = val / 10 ; 
            if(head == null){
                thead = new ListNode(sum);
                head = thead;
            }else{
                thead.next = new ListNode(sum);
                thead = thead.next;
            }
            l1 = l1.next;
            l2 = l2.next;
            
        }
        
        if(l1 != null){
            copyRemaining(l1);
        }
        
        if(l2 != null){
            copyRemaining(l2);
        }
        
        while(carry != 0){
            thead.next = new ListNode(carry);
            carry = carry/10;
        }
        
      return head;  
    }
    
    
    void copyRemaining(ListNode l1){
         int val = 0;
         while(l1 != null){
            val = (l1.val + carry);
            carry = val/10;    
            thead.next = new ListNode(val%10);
            l1 = l1.next;
            thead = thead.next; 
        }
    }
    
}