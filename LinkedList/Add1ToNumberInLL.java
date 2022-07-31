/**
 * 
 * No reference is used.
 * 
 * Logic is first reverse the LL and add 1 to the reversed LL head node and again reverse the LL and return the list back.
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

public class Add1ToNumberInLL {

    static Node reverse(Node head)
    {
        if(head==null || head.next==null)
            return head;
        Node rem = reverse(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return rem;
    }
    
    public static Node addOne(Node head) 
    { 
        head = reverse(head);
        Node temp = head;
        int carry = 1;  // this is same as the '1' we shuld add to given LL.
        
        while(temp.next!=null)
        {
            if(temp.data < 9)   // if temp.data == 8 then temp.data+carry == 9 ==> carry will become 0.
            {
                temp.data = temp.data + carry;
                carry=0;
            }
            else if(temp.data == 9 && carry==1)  // here we need both checks as if temp.data==9 and carry==0 then the steps inside shuld not execute
            {
                // after adding '1' temp.data becomes 10, and hence '0' is stored in temp.data and '1' in carry.
               temp.data = 0;
                carry=1;  
            }
            temp=temp.next;
        }
        
        
        // Last node is taken care here as we dont update last node in above loop.
        if(temp.data < 9)   // if last nodes data is < 9 then add carry thats it.
        {
            temp.data=temp.data+carry;
            
        }
        else if(temp.data ==9 && carry==1)  // if last nodes data is '9' and also carry=1 then we need to do as below.
        {
            temp.data = 0;
            Node t1 = new Node(1);
            temp.next = t1;
        }
        
        head = reverse(head);   // at last reverse again the LL.
        return head;
    }
    
}
