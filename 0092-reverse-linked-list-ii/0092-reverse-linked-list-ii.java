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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head.next==null){
            return head;
        }
        
        ListNode curr = head;
        ListNode prev = null;
        
        ListNode l=null;
        ListNode r=null;
        ListNode prevL = null;
        ListNode rightNext = null;
        
        for(int i=1;i<=right;i++){
            if(i==left){
                l = curr;
                prevL = prev;
            }
            if(i==right){
                r = curr;
                rightNext = r.next;
            }
            prev = curr;
            curr = curr.next;
            
        }
        
    
        ListNode rev=reverse(l,r);
        l.next = rightNext;
        
        if(prevL == null){
           head = rev;    
        }else{
            prevL.next = rev;
        }
        
        return head;
    }
    
    ListNode reverse(ListNode left, ListNode right){
        ListNode curr= left;
        ListNode prev =null;
        ListNode next = null;
        
        while(curr!= null && curr != right){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        curr.next = prev;
        return curr;
    }
    
    
    
}