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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return sort(lists,0,lists.length-1);
    }
    
    private ListNode sort(ListNode[] lists, int lo, int hi) {
        if(lo == hi){
            return lists[lo];
        }
        int mid = lo + (hi-lo)/2;
        ListNode left = sort(lists,lo,mid);
        ListNode right = sort(lists,mid+1,hi);
        
        return merge(left,right);
    }
    
    ListNode merge(ListNode left,ListNode right){
        
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
         
         ListNode thead = null,head = null;
        
         if(left.val <= right.val){
             thead = left;
             head =left;
             left = left.next;
         }else{
             thead = right;
             head = right;
             right = head.next;
         }
        
        while(left!=null || right!=null){
            if((right == null)|| (left!=null && left.val <= right.val)){
                thead.next = left;
                left = left.next;
                thead = thead.next;
            }else{
                thead.next = right;
                right = right.next;
                thead = thead.next;
            }
        }
        
        return head;
        
    }
}