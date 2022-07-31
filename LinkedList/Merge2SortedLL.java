/**
 * 
 * No reference is used.
 * Logic is same as Merging 2-sorted LL. So use merge() of merge sort.
 * 
 */

package LinkedList;


class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

public class Merge2SortedLL {

    Node sortedMerge(Node head1, Node head2) {
     
        Node result = new Node(-1);    // initializing with dummy value for ease of updation
        Node temp = result;
        
        while(head1!=null && head2!=null)
        {
            if(head1.data<=head2.data)
            {
                temp.next = head1;
                head1= head1.next;
            }
            else
            {
                temp.next = head2;
                head2= head2.next;
            }
            temp = temp.next;
            
        }
        
        // if end of anyone of the  list is reached then we add the other list  remaining part to new list.
        if(head1!=null)
        {
            temp.next= head1;
            temp = temp.next;
            head1 = head1.next;
            
        }
        else
        {
            temp.next= head2;
            temp = temp.next;
            head2 = head2.next;
        }
        
        return result.next;
      } 
    
}
