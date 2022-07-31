/**
 * 
 * No reference is referred
 * 
 *  Logic is find mid of the circular list.
 * 
 *  After finding mid, using slow and fast pointers, then fast.next can be same as head or fast.next.next will be same as head.
 *  So, we need to update fast pointer accordingly to poin to last node.
 *  
 *  And change the respecctive ptrs
 * 
 */

package LinkedList;

class Node {
    int data;
     Node next;
     Node(int d)  { data = d;  next = null; }
 }

public class SplitCircularLLInto2Halves {

    void splitList(Node head)
        {
            
             
    	   // Node head = list.head;
    	    
    	    if(head==null)
    	        return ;
    	    
    	    Node slow=head, fast=head;


    	    // find middle node in circular list.
    	    while( fast.next!=head && fast.next.next!=head)
    	    {
    	        slow = slow.next;
    	        fast = fast.next.next;
    	    }
    	    
            // if fast.next.next == head then we need to move fast to point to last node else fast will be pointing to last node
    	    if(fast.next.next == head)
    	    {
    	           fast = fast.next;
    	    }


    	    // update pointers accordingly.
    	    Node mid_next = slow.next;  // this points to node next to middle node.
    	   
    	    slow.next= head;    /// list-1 updation
    	    
    	    fast.next = mid_next;   // list-2 updation
    	    
    	    Node head1=head;
    	    Node head2=mid_next;
    	    
            while(head1!=null)
            {
                System.out.println(head1.data + " ");
                head1 = head1.next;

            }

            while(head2!=null)
            {
                System.out.println(head2.data + " ");
                head2 = head2.next;

            }


            
        }
    
}
