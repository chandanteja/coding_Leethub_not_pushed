/**
 * 
 * https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/       --> refer this.
 * 
 * Reverse given lists and add them and again reverse the result list.
 * 
 */

package LinkedList;



 class Node {
 
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}

public class AddTwoNumbersLL {

    static Node reverse(Node head)
    {
        if(head==null)
            return head;
        Node prev=null,next=null,curr=head;
        
        while(curr!=null)
        {
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    
    static Node addTwoLists(Node first, Node second){
        
        // res is head node of the resultant list
        Node res=null,temp=null,res_prev=null;
        int sum=0,carry=0;
        
        first=reverse(first);
        second = reverse(second);
        
        // while both lists exist
        while(first!=null || second !=null)
        {
            // Calculate value of next
            // digit in resultant list.
            // The next digit is sum
            // of following things
            // (i)  Carry
            // (ii) Next digit of first
            // list (if there is a next digit)
            // (ii) Next digit of second
            // list (if there is a next digit)
            sum = carry+(first!=null ? first.data:0)+(second!=null ? second.data:0);
            
            // update carry for next calulation
            carry = (sum>9) ? 1:0;
            sum = sum%10;        // update sum if it is greater than 10
            
            temp = new Node(sum);       // Create a new node with sum as data
            

            // if this is the first node then set
            // it as head of the resultant list
            if (res == null) {
                res = temp;
            }
 
            // If this is not the first
            // node then connect it to the rest.
            else {
                res_prev.next = temp;
            }

            // Set prev for next insertion i.e move prev forward.
            res_prev=temp;
            
            // Move first and second pointers
            // to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }
        if (carry > 0) {
            temp.next = new Node(carry);
        }
 
        res = reverse(res);
        return res;
    }
    
}
