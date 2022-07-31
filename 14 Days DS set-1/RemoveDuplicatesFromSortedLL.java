/**
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 */

public class RemoveDuplicatesFromSortedLL {

    public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null)
                return head;
        ListNode curr = head,next;
        
        while(curr.next!=null)
        {
            next = curr.next;   // points to next node of node pointed by curr node.
            if(curr.next.val == curr.val)
            {
                curr.next = next.next;
            }
            else
                curr =curr.next;
                
        }
        return head;
        
    }
    
}
