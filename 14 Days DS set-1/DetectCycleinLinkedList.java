/**
 * 
 * https://leetcode.com/problems/linked-list-cycle/ 
 * 
 */

class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
public class DetectCycleinLinkedList {
    public boolean hasCycle(ListNode head) {
        
        if(head==null || head.next==null)
            return false;
        
        ListNode slow=head, fast=head.next;
        
        while(fast.next!=null)
        {
            
            if(fast==slow)
                return true;
            
            fast=fast.next;
            slow=slow.next;
            if(fast.next!=null)
                fast=fast.next;
            
            
        }
        return false;
    }
    
}
