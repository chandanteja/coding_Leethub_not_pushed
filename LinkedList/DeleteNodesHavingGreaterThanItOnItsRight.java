/**
 * 
 * Logic is reverse the given list first.
 * Now check if next nodes value is lessthan current nodes value then delete that next node.
 * Again reverse the list and return value.
 * 
 * No reference is used.
 * 
 * 
 * 
 */

package LinkedList;


class Node {
    int data;
    Node next;
 
   Node(int data) {
       this.data = data;
   }
 }

public class DeleteNodesHavingGreaterThanItOnItsRight {

    // reverse LL.
    Node reverseList(Node head)
    {
        if(head==null)
            return head;
        Node prev=null,next=null,curr=head;
        
        while(curr!=null)
        {
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    
    Node compute(Node head)
    {
        Node reversed = reverseList(head);  // delete node which has greater value to right == delete nodes which have smaller values to right in revered list.
        // so reverse the list first.
        Node temp = reversed;       // to keep track of first node.
        
        while(temp!=null)
        {
            if(temp.next!= null  && temp.data > temp.next.data)
            // if reversed next is not null and reversed next is smaller than reversed then delete reversed next.
            {
                temp.next = temp.next.next;
            }
            else
            // otherwise move reversed.
                temp = temp.next;
        }
        
        reversed = reverseList(reversed);   // reverse it again for output.
        return reversed;    // return headRef.
    }
    
}
