/**
 * 
 * https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/  --> refer slow and fast pointer method.
 * 
 */

package LinkedList;

public class LoopDetectionInLL {

    public static boolean detectLoop(Node head){
        
        if(head==null || head.next==null)
            return false;
        
        Node fast,slow;
        fast=slow = head;
        
        while(fast!=null)
        {
            fast = fast.next;
            slow= slow.next;
            
            if(fast!=null)
                fast=fast.next;
            
            if(fast==slow)
                return true;
        }
        return false;
        
    }
    
}
