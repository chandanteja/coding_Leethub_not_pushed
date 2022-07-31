/**
 * 
 * https://cs.stackexchange.com/questions/10360/floyds-cycle-detection-algorithm-determining-the-starting-point-of-cycle    --> proof of correctness of Floyd cycle detection algo. 
 * 
 * https://www.youtube.com/watch?v=aIR0s1tY2Vk
 * 
 * https://www.youtube.com/watch?v=Cs3KwAsqqn4  --> proof of correctness of Floyd cycle detection algo.      
 * 
 */

package LinkedList;

public class RemoveLoopInLL {

    public static void removeLoop(Node head){
        
        if(head==null || head.next==null)
           return;
       
       Node fast=head;
       Node slow = head;
       
       while(fast!=null)
       {
           fast = fast.next;
           slow=slow.next;
           
           if(fast!=null)
               fast=fast.next;
           
           if(fast==slow)
               break;
           
       }
       
       /**
        * 
        *   This case where slow == head is needed for cases like below

                1->2->3->4->5 -> 1  (cycle is from 5-1 i.e from 5 to 1 cycle is there) , then the else if() case wont work.
        */

       if(slow==head)
       {
           while(fast.next!=slow)
               fast = fast.next;
           fast.next = null;
       }

       // we first do cycle detection check, if cycle is present then if the case in if() is not the case we are in, then we proceed with below case.
       // we move one pointer to start and we keep other ptr at point where both ptrs met and move both ptrs at same speed and check if (fast.next != slow.next)
             
       else if(fast==slow)
       {
       // now move either fast or slow to start of linked list and move both ptrs at same speed.
           fast = head;
           while(fast.next!=slow.next)
           {
               fast = fast.next;
               slow = slow.next;
           }
           
           slow.next=null;
       }
   }
    
}
