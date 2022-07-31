/**
 * 
 * 
 * One method is use hashtable and store all nodes of one of the Linkedlist and traverse the other list and check if any node of 2nd list is present in hashtable. 
 * If present then intersection found
 * 
 * T.c : O(n+m)
 * S.c : Min(n,m)
 * 
 * optimized Method (Space only):
 * 
 * Observe that while list A and list B could be different lengths, that the shared "tail" following the intersection has to be the same length.

Imagine that we have two linked lists, A and B, and we know that their lengths are NN and MM respectively (these can be calculated with O(1)O(1) space and in time proportional to the length of the list). We'll imagine that N = 5 and M=8.
 * 
 * 
 * In code, we could write this algorithm with 4 loops, one after the other, each doing the following:

Calculate NN; the length of list A.
Calculate MM; the length of list B.
Set the start pointer for the longer list.
Step the pointers through the list together.    
 * 
 * 
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 */

package MorganStanleyList;



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class IntersectionOf2LL {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int c1=0;
        int c2=0;
        
        ListNode ptr1=headA,ptr2=headB;
        
        while(ptr1!=null)
        {
            c1++;
            ptr1=ptr1.next;
                
        }
        
        while(ptr2!=null)
        {
            c2++;
            ptr2=ptr2.next;
                
        }
        
        int diff = Math.abs(c1-c2);
        
        ptr1=headA;
        ptr2=headB;
        
        if(c1>c2)
        {
            for(int i=0;i<diff;i++)
            {
                ptr1=ptr1.next;
            }
            
        }
        else
        {
            for(int i=0;i<diff;i++)
            {
                ptr2=ptr2.next;
            }
        }
        
        while(ptr1!=ptr2)
        {
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        
        return ptr1==ptr2 ? ptr1 : null;
        
        
        
    }
    
}
