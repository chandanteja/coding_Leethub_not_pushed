/**
 * 
 * https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
 * 
 * Use fast and slow pointer approach.
 * 
 */

package LinkedList;


class Node {
    int data;
     Node next;
     Node(int d)  { data = d;  next = null; }
 }


 // This is another way of finding middle element. For other way refer MergeSortOnLL.java
public class FindMiddleOfLL {

    int getMiddle(Node head)
    {
         if(head==null)
            return -1;
            
            Node fast = head,slow=head;
            
            while( fast!=null && fast.next!=null )
            {
                fast=fast.next;
                slow=slow.next;
                
                if(fast.next!=null)
                    fast=fast.next;
                
            }
            return slow.data;
    }


    
}
