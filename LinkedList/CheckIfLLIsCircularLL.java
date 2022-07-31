/**
 * 
 * No reference is used.
 * 
 */

package LinkedList;

class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

public class CheckIfLLIsCircularLL {

    boolean isCircular(Node head)
    {
	    if(head==null)
	        return true;
	   if(head.next==head)
	        return true;
	        
	   
	   Node temp = head.next;
	   
	   while(temp!=null && temp!=head)
	   {
	       temp = temp.next;
	   }
	   if(temp==null)
	    return false;
	   else
	    return true;
	    
    }
    
}
