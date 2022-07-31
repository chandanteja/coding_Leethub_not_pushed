/**
 * 
 * Refer DS in Depth by Srivasthava T.B
 * 
 * This is iterative version.
 * 
 * Logic is we take 3-pointers prev,curr,next.
 * 
 * Prev -- points to previous node of the node which is currently being reversed.
 * curr -- points to current node which is currently being reversed.
 * next -- points to next node of the node which is ccurrently being reversed.
 *  We update pointers accordingly. 
 *
 * 
 * https://www.geeksforgeeks.org/reverse-a-linked-list/
 * 
 */

package LinkedList;

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

public class ReverseALinkedList {

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
    
}
