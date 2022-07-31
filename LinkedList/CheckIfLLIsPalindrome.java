/**
 * 
 *  Logic is, Reverse the 2nd half of the linked list and compare the first half of LL with 2nd half.
 * 
 */

package LinkedList;

class Node
    {
    	int data;
    	Node next;
    	
    	Node(int d)
    	{
    		data = d;
    		next = null;
    	}
    }

public class CheckIfLLIsPalindrome {

    boolean isPalindrome(Node head) 
    {
        if(head==null || head.next == null)
            return true;
            
       Node fast=head,slow=head;
       Node second_list = null;
       
       
       while(fast.next !=null && fast.next.next!=null)
       {
           
           slow=slow.next;
           fast=fast.next.next;
       }
       
       second_list = slow.next;
       slow.next = null;
       
       second_list = reverse(second_list);  // if 1->2->1 is LL, then 2 will be included in 1st list.
       
       int palin =  compare(head,second_list);
       
       if(palin==1)
        return true;
       else
        return false;
       
    }  
    
    int compare(Node head1,Node head2)
    {
        Node temp1 = head1;
        Node temp2 = head2;
        
        while(temp1!=null && temp2!=null)
        {
            if(temp1.data != temp2.data)
            {
                break;
            }
            else
            {
                temp1 = temp1.next;
                temp2= temp2.next;
            }
        }
        
        if(temp1==null && temp2==null)
            return 1;
            
            // this check is for odd lengh lists and 1st list will have length 1 more than length of 2nd list.
        if(temp2==null && temp1.next==null) // as temp2 pointed list will be shorter in case of odd length list as mid element will be distributed to 1st list.
            return 1;
        
        return 0;
        
    }
    
    Node reverse(Node head)
    {
        Node prev=null,curr=head,next=null;
        
        while(curr!=null)
        {
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        
        }
        return prev;
    }
    
}
