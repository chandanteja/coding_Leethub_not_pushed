/**
 * 
 * Use merge function of merge sort().
 * 
 */

package Amazonlist;

class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

public class Merge2SortedLL {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1==null)
                return l2;
        if(l2==null)
                return l1;
                // here result-head points to a dummy node which we will discard at the end.
                // we do this to avoid null pointer exceptions.
        ListNode result_head = new ListNode(-1),temp=result_head;
        

        while(l1!=null && l2!=null)
        {    
            if(l1.val<=l2.val)
            {
                temp.next=l1;
                temp=temp.next;
                l1=l1.next;
            }
            else
            {
                temp.next=l2;
                l2=l2.next;
                temp = temp.next;
            }
        }
        
        // if end of anyone of the  list is reached end then we add the other list remaining part to new list.
        if(l1!=null)
        {
            temp.next=l1;
            l1=l1.next;
            temp=temp.next;
        }
        
        if(l2!=null)
        {
                temp.next=l2;
                l2=l2.next;
                temp = temp.next;  
        }
        return result_head.next;    // we return result_head.next bcz the first node is dummy node '-1'
    }
    
}
