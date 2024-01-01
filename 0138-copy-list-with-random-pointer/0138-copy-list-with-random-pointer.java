/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        // base case
        if(head==null)
            return head;
        
        // insert new nodes in the current linked list
        Node curr=head;  
        while(curr!=null){
           Node temp=new Node(curr.val);
           temp.next=curr.next;
           curr.next=temp;
           curr=temp.next;
        }
        
        //copy random pointers for the modified list
        curr=head;
        while(curr!=null){
            curr.next.random=(curr.random!=null)?curr.random.next:null;    
            curr=curr.next.next;    
        }
        
        // seperate the list into two parts
        curr=head;
        Node nhead=curr.next,ncurr=curr.next;
     
        while(curr != null){
            curr.next = curr.next==null?null:curr.next.next;
            ncurr.next = ncurr.next==null? null:ncurr.next.next;
            curr=curr.next;
            ncurr=ncurr.next;
        }
        
        return nhead;
    }
}