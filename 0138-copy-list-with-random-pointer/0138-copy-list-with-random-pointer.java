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
        
        if(head==null)
            return head;
        
        Node curr=head;  
        while(curr!=null){
            
           Node temp=new Node(curr.val);
           temp.next=curr.next;
           curr.next=temp;
           curr=temp.next;
            
        }
        
        curr=head;
        while(curr!=null){
         
            curr.next.random=(curr.random!=null)?curr.random.next:null;    
            curr=curr.next.next;    
        }
        
        curr=head;
        Node nhead=curr.next,ncurr=curr.next;
     
        while(curr!=null){
            //System.out.println(curr.val+" "+curr.next.val);
            curr.next=curr.next.next;
            ncurr.next=curr.next==null?null:curr.next.next;
            curr=curr.next;
            ncurr=curr==null?null:curr.next;
        }
        
        return nhead;
        
    }
}