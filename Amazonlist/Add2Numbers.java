/**
 * 
 * https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/       --> refer this.
 * 
 */

package Amazonlist;

 public class ListNode 
 {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Add2Numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1==null)    // if l1 is null then l2 will be result
                return l2;
        if(l2==null)    // if l2 is null l1 will be result.
                return l1;
        
        int sum=0,carry=0;
        ListNode res_head=null,res_temp=null;   // for resultant list.
        // res_head points to head of result list and res_temp points to last node of result list
        
        // loop till any list is not empty.
        while(l1!=null || l2!=null)
        {
            // if l1 is null then 0 is added else l1.val is added and same for l2.
            sum = carry+(l1!=null ? l1.val:0)+(l2!=null ? l2.val:0);
            
            carry = (sum>9)? 1:0;   // update carry if sum>9-->1 else 0

            sum = sum%10;       // if sum>=10 then we need to truncate it below 10 as we can ony store 1 digit
            
            ListNode temp = new ListNode(sum);  // creating result list node
            
            
            if(res_head==null)
            {
                res_head=temp;
            }
            else
            {
                res_temp.next=temp;
            }
            res_temp=temp;  // update the res_temp so that it will point to last node in result list
            
            // moving l1 and l2 forward 
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
                
        
        }
        
        // after completion of both lists, if carray is '1' then we need to create a new node and add it to result list.
        if(carry>0)
        {
            res_temp.next = new ListNode(carry);
        } 
        
        return res_head;
        
    }
    
}
