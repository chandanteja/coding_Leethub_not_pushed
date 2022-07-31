/**
 * 
 * https://www.youtube.com/watch?v=3cLRaWPiIxo  --> watch this for clarity.
 * 
 *  Two pointer approach.
 * 
 * 
 */

package LinkedList;


class Node {
    int data;
     Node next;
     Node(int d)  { data = d;  next = null; }
 }

public class IntersectionOfTwoSortedLL {

    public static Node findIntersection(Node head1, Node head2)
    {
        if(head1==null || head2==null)
            return null;
        
        Node temp1=head1;
        Node temp2= head2;
        Node head = null;
        Node curr = null;
        
        while(temp1!=null && temp2!=null)
        {
            if(temp1.data == temp2.data)
            {
                if(head==null)
                {
                    Node temp = new Node(temp1.data);
                    head=temp;
                    curr=temp;
                }
                else
                {
                    curr.next = new Node(temp1.data);
                    curr = curr.next;
                }
                temp1 = temp1.next;
                temp2=temp2.next;
                
            }
            else if(temp1.data < temp2.data)
            {
                temp1 = temp1.next;
            }
            else 
                temp2=temp2.next;
            
        }
        return head;

    }
    
}
