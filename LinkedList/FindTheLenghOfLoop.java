/**
 * 
 * https://www.geeksforgeeks.org/find-length-of-loop-in-linked-list/
 * 
 * 
 */

package LinkedList;

public class FindTheLenghOfLoop {

    static int countNodesinLoop(Node head)
    {
        if(head==null)
            return 0;
        if(head.next==null)
            return 1;
        
        Node fast = head,slow=head;
        
        while(fast!=null)
        {
            fast=fast.next;
            slow=slow.next;
            
            if(fast!=null)
                fast=fast.next;

                /* If slow_p and fast_p meet at some point
        then there is a loop */
            if(fast==slow)
            {
              return countNodes(slow);
            }
        }
        return 0;   /* Return 0 to indeciate that ther is no loop*/
        
    }
    
    // Returns count of nodes present in loop.
    static int countNodes(Node slow)
    {
        int cycle_len=0;
        
        Node temp = slow;
        
        slow=slow.next;
        cycle_len++;
        
        while(slow!=temp)
        {
            
            slow=slow.next;
            cycle_len++;
            
            
        }
        return cycle_len;
    }
    
}
