/**
 * 
 * https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
 * 
 * Used Hashset for storing values so, S.C: O(n).
 * 
 */

package LinkedList;

import java.util.HashSet;

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}

public class RemoveDuplicatesFromUnsortedLL {

    public Node removeDuplicates(Node head) 
    {
         if(head==null || head.next == null)
            return head;
        HashSet<Integer> hm = new HashSet<>();
        
        Node ptr = head;
        Node prev =null;
        
        while(ptr!=null)
        {
            if(!hm.contains(ptr.data))
            {
                hm.add(ptr.data);
                prev=ptr;
                
            }
            else
            {
                prev.next=ptr.next;
                
            }
            
            ptr = ptr.next;
        
        }
        return head;
    }
    
}
