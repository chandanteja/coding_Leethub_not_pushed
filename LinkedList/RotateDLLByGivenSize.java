/**
 * 
 * https://www.geeksforgeeks.org/rotate-doubly-linked-list-n-nodes/
 * 
 *  To rotate the Doubly linked list, we need to change next of Nth node to NULL, next of last node to previous head node, and prev of head node to last node and finally change head to (N+1)th node and prev of new head node to NULL (Prev of Head node in doubly linked list is NULL) 
    So we need to get hold of three nodes: Nth node, (N+1)th node and last node. Traverse the list from beginning and stop at Nth node. 
    Store pointer to Nth node. We can get (N+1)th node using NthNode->next. Keep traversing till end and store pointer to last node also.
 * 
 */

package LinkedList;

 class Node
{
    char data;
    Node prev;
    Node next;
}

public class RotateDLLByGivenSize {

    Node rotateP (Node head, int p){
        Node last = head;
        
        while(last.next!=null)
             last = last.next;
         
         while(p!=0)
         {
             last.next=head;
             head.prev=last;
             
             Node temp = head;
             head=head.next;
             temp.next=null;
             head.prev=null;
             last = last.next;
             
             p--;
             
         }
         return head;
         
     }
    
}
