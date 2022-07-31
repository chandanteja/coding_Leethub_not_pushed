/**
 * 
 * https://www.geeksforgeeks.org/multiply-two-numbers-represented-linked-lists-third-list/      ---> another method and important method. Study this later.
 * https://www.geeksforgeeks.org/multiply-two-numbers-represented-linked-lists/
 * 
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
        this.next = null;
    }
}

/*
        Below approach is first convert the 2 LLs into numbers and multiply them and return the result.

        This is not the accurate method. So, refer the above link for another method.
*/

public class MultiplyTwoLL {

    public long multiplyTwoLists(Node first,Node second){
        long N = 1000000007;
     long num1 = 0, num2 = 0;   // n1 - number representing l1. n2 - number representing l2

     while (first != null || second !=  null){
          
         if(first != null){
             num1 = ((num1)*10)%N + first.data;     // *10 + node's data.
             first = first.next;
         }
          
         if(second != null)
         {
             num2 = ((num2)*10)%N + second.data;    // *10 + node's data.
             second = second.next;
         }
          
     }
     return ((num1%N)*(num2%N))%N;   // %mod because long long might overflow.
}
    
}
