/**
 * 
 * https://www.youtube.com/watch?v=lunWlOjj0Cg&t=41s
 * 
 * https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
 * 
 * Traverse lst1 and list2 and count lengths respectively.
 * Find difference of lengths and initialize both poitners to start of lists and move the longest length list for dist of difference of lengths
 * 
 * 
 */

package LinkedList;


class Node {
    int data;
     Node next;
     Node(int d)  { data = d;  next = null; }
 }

public class IntersectionOfTwoLists {

    int intersectPoint(Node head1, Node head2)
	{
         Node ptr1=head1,ptr2=head2;
         
         int c1=0,c2=0;
         
          if(head1== null || head2==null)
                return -1;
            
         
         while(ptr1!=null)
         {
             c1++;
             ptr1 = ptr1.next;
            
         }
         
          while(ptr2!=null)
         {
             c2++;
             ptr2 = ptr2.next;
            
         }
         
         int diff = Math.abs(c1-c2);
         ptr1=head1;
         ptr2=head2;
         
         if(c1>c2)
         {
             for(int i=0;i<diff;i++)
                ptr1=ptr1.next;
         }
         else if(c2>c1)
         {
             for(int i=0;i<diff;i++)
                ptr2=ptr2.next;
         }
         
            while(ptr1!=ptr2)
          {
            ptr1=ptr1.next;
            ptr2=ptr2.next;
          }
        
        if(ptr1!=null && ptr2!=null)
                return ptr1.data;
        return -1;
         
	}
    
}
