

/**
 * 
 * For two ptr approach notes refer Srivastava DS T.B page No-72.
 * 
 */

package LinkedList;

class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class ReverseDLL {

public static Node reverseDLL(Node  head)
{
    if(head==null || head.next==null)
        return head;
        
    Node prev=head;
    Node curr=prev.next;
    
    prev.next=null;
    prev.prev=curr;
    
    while(curr!=null)
    {
        curr.prev=curr.next;
        curr.next=prev;
        prev=curr;
        curr=curr.prev;
    }
    return prev;
}
    
}
