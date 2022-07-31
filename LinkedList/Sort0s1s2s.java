/**
 * 
 * https://www.geeksforgeeks.org/sort-linked-list-0s-1s-2s-changing-links/      --> refer this logic.
 * 
 * 
 */

package LinkedList;

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
    }
}

public class Sort0s1s2s {

    static Node segregate(Node head)
    {
        // these point to dummies before corresponding list starts.
        Node zeroD = new Node(0);
        Node oneD = new Node(0);
        Node twoD = new Node(0);


        Node one=oneD,two=twoD,zero=zeroD;  // these point to current 0th, 1th, 2th node.
        
        while(head!=null)
        {
            if(head.data ==0)   // if the current data is 0.
            {
                // update zero pointer to this node.
                // move zero
                // move current.
                zero.next = head;
                head=head.next;
                zero=zero.next;
            }
            // similarly update one and two pointers.
            else if(head.data ==1)
            {
               one.next = head;
                head=head.next;
                one=one.next; 
            }
            else 
            {
               two.next = head;
                head=head.next;
                two=two.next; 
            }
           
        }

        // if 1's list is empty then last zero elt shud point to two list start.
        // if 2s list is also empty then it shud be null.
        // if 1s list is not empty then make it point to 1s list head i.e. oneRef->next. as oneRef is pointing to 0 (dummy node).
        // if 1s list is empty and 2s list is not empty
        // then make it point to 2s list head i.e. twoRef->next. as twoRef is pointing to 0 (dummy node).
        
        zero.next = oneD.next!=null ? oneD.next : twoD.next;

        // end of 1s node must point to 2s list starting. 
        // so twoRef->next.
        one.next = twoD.next;
        two.next=null;
        // 2s list end mustnt point to anything so make it NULL.
        
        return zeroD.next;
    }
    
}
