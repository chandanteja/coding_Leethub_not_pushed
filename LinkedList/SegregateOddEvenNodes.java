/**
 * 
 * https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/  --> 2nd method is followed here.
 * 
 * We take 2 separate lists to maintain odd and even nodes of given list separately.
 * 
 * 
 * 
 */

package LinkedList;


class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}

public class SegregateOddEvenNodes {

    Node divide(int N, Node head){
        if(head==null)
            return head;
        
        Node evenHead=null,even=null,oddHead=null,odd=null;
        
       
        while(head!=null)
        {
            if(head.data %2==0)
            {
                if(evenHead==null)
                {
                    even = head;
                    evenHead=even;
                }
                else
                {
                    even.next = head;
                    even = even.next;
                }
                
            }
            else
            {
                if(oddHead==null)
                {
                    odd = head;
                    oddHead=odd;
                }
                else
                {
                    odd.next = head;
                    odd = odd.next;
                }
                
            }
            head = head.next;
        }
        
        if(oddHead == null && evenHead == null) {
            return null;
        }
        
        if(evenHead==null)
            return oddHead;
        if(oddHead==null)
            return evenHead;
    
        odd.next = null;
        even.next = oddHead;
        
        return evenHead;
    }
    
}
