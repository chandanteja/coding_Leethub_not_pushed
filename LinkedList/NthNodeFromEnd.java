/**
 * 
 * https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
 * 
 * Maintain two pointers – reference pointer and main pointer. Initialize both reference and main pointers to head. 
 * First, move the reference pointer to n nodes from head. Now move both pointers one by one until the reference pointer reaches the end. 
 * Now the main pointer will point to nth node from the end. 
 * Return the main pointer.
 * 
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/1263295/Java-0ms-faster-than-100                  --> leetcode variant solution
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/1269850/C%2B%2B-Java-or-Two-Pointer-or-One-pass   --> leetcode variant see java soln
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/1247659/Java-Solution                             --> another soln 
 * 
 * 
 * 
 */

package LinkedList;

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

public class NthNodeFromEnd {

    int getNthFromLast(Node head, int n)
    {
        if(head==null)
            return -1;
    	Node ptr1=head,ptr2=head;
    	int ctr=0;
    	
	while(ctr<n)
	{
	    if(ptr1==null)
	    {
	        return -1;
	    }
	    ptr1=ptr1.next;
	    ctr++;
	}
    	
    while(ptr1!=null) 
     { 
            ptr1=ptr1.next;
    	    ptr2=ptr2.next;
     } 
    return ptr2.data;
    
    }
    
}
