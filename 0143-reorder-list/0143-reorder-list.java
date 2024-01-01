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
    
    // L0 → L1 → … → Ln - 1 → Ln
    
//     1->2->3->4
        
//     1->2->3
  
        
//    1->2->3->4
   
//    4->3->null     
        
//    middle = 2;
//    reverseHead = 2
//    thead = 2  /  
//    next = 2
//    prev =  3   
       
//    1->2->3   
//    3->2  
//    1->3->2   
   
    public void reorderList(ListNode head) {
       if(head == null || head.next == null || head.next.next == null)
           return ;
        
       int cnt = noOfNodes(head); 
       ListNode middle = findMiddle(head);
       ListNode reverseHead = reverse(middle);
       ListNode thead = head,next = null, prev = null;
        
       while(thead != middle){
           next = thead.next;
           thead.next = reverseHead;
           prev = reverseHead;
           reverseHead = reverseHead.next;
           thead = next;
           prev.next = thead;
       } 
       //System.out.println(prev.next.val);
       if(cnt%2 ==0) 
         prev.next = null;
        
    }
    
    int noOfNodes(ListNode head){
        int cnt = 0;
        while(head!=null){
            head=head.next;
            cnt++;
        }
        return cnt;
    }
    
    // 1->2->3->4
    ListNode findMiddle(ListNode head){
        if(head == null)
            return null;
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    
    // curr = null
    // pev = 4
    // next = null;
    // 1-> 2-> 3-> 4
    // 4->3->2-> 1-> null       
    ListNode reverse(ListNode head){
        if(head == null)
            return null;
        ListNode prev = null, curr = head, next=head.next;
        
        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null)
              next = next.next;
        }
        
        return prev;  
    }
    
    
    
    
}