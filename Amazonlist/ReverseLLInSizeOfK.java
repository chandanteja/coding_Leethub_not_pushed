/**
 * 
 * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/    --> refer this.
 * 
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 */

package Amazonlist;


 class ListNode 
{
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

public class ReverseLLInSizeOfK {

    public ListNode reverseKGroup(ListNode head, int k) {   
       if(checkLength(head,k))
              return head;           // This size-check is needed only in Leetcode
        int count = 0;
        ListNode current = head;
        ListNode next=null,prev=null;
        //usual linked list reversal
        
          /* Reverse first k nodes of linked list */
        while(current!=null && count<k){
            next = current.next;
            current.next=prev;
            prev = current;
            current = next;
            count++;
        }
        //the head of the original list will now be the tail of the reversed linked list of size k
        // and the next of that head is recursively assigned to what the function returns (temp2)
          /* next/curr is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node 
           
           I/P: 1->2->3->4->5 , K=2
           O/P : 2->1->4->3->5 --> here if we see the head in input pointed to '1' but after reversing first list of 'k' ele, head.next will be the next reversed list.

           */
        if(current!=null){
            ListNode temp = reverseKGroup(current,k);
            head.next = temp;
        }
        return prev;
    }
    // a helper function to check if the size of the remaining list is less than k
    // we need this to check whether we need to reverse the list or not

    public boolean checkLength(ListNode head,int k){
        ListNode start = head;
        int size = 0;
        while(start!=null){
            start = start.next;
            size++;
        }
        return size<k;
    }
    
}
