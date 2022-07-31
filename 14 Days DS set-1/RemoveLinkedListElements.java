/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * 
 * 
 */


 class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        
        if(head==null)
                return head;
        
        ListNode temp=head;
        
        while(temp!=null && temp.next!=null)
        {
            if(temp.val == val && head==temp)
            {
                temp=temp.next;
                head=head.next;
            }
            else if(temp.next.val==val)
            {
                temp.next = temp.next.next;
            }
            else
                temp = temp.next;
        }
        
        if(temp.next==null && temp.val == val)
            return head.next;
        
        return head;
        

    }
    
}
