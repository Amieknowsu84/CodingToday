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
          
    // 1-> 2-> 3 -> 3 <- 2 <- 1
    // 1->2<-1
    // 1 -> 2 -> next -> 2 -> 1
    // 1 -> 1
    
    
    public boolean isPalindrome(ListNode head) {
        
        if(head.next == null){
            return true;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //System.out.println("second half start"+slow.val);
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf  = head;
        ListNode reverse = secondHalf;
        

        while(secondHalf != null){
            //System.out.println(firstHalf.val+" "+secondHalf.val);
            if(secondHalf.val != firstHalf.val){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true;
    }
    
    
    // null<-1 <-2 <- 3
    ListNode reverse(ListNode head){
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null)
            next = next.next;
        }
        
        return prev;
    }
}