/**
 * 
 * No reference is used.
 * 
 */

package LinkedList;


class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

public class RemoveDuplicatesFromSortedLL {

    Node removeDuplicates(Node head)
    {
        
        if(head==null || head.next==null)
            return head;
        
        Node temp = head;
        
        while(temp != null && temp.next!=null)
        {
            if(temp.data == temp.next.data) // if temp.data == temp.next.data then we wont move temp forward but we use another temporary ptr to remove the duplicate node
            {
                Node temp1 = temp.next;
                temp.next=temp1.next;
                
            }
            else    // if temp.data != temp.next.data then we move temp ptr forwardas there is no duplicate node with value in temp .
                temp = temp.next;
            
        }
        return head;
    }
    
}
