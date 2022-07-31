/**
 * 
 *  1. If a loop is found, initialize a slow pointer to head, let fast pointer be at its position. 
    2. Move both slow and fast pointers one node at a time. 
    3. The point at which they meet is the start of the loop.


    https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/
 * 
 */

package LinkedList;

public class FindStartPointOfLoop {

    public static Node removeLoop(Node head)
    {
        
        if(head==null || head.next==null)
           return null;
       
       Node fast=head;
       Node slow = head;
       
       while(fast!=null)
       {
           fast = fast.next;
           slow=slow.next;
           
           if(fast!=null)
               fast=fast.next;
           
           if(fast==slow)
               break;
           
       }

       // If loop does not exist
    if (slow != fast)
        return null;

    // If loop exists. Start slow from
    // head and fast from meeting point.
        slow = head;
        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    
}
