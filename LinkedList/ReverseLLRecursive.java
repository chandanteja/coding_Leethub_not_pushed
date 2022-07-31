/**
 * 
 * https://www.geeksforgeeks.org/reverse-a-linked-list/
 * 
 *      trace on     1->2->3->4->5
 */

package LinkedList;

public class ReverseLLRecursive {

    static Node reverse(Node head)
    {
        if (head == null || head.next == null)
            return head;
 
        /* reverse the rest of the list and put
        the first element at the end */
        Node revListHead = reverse(head.next); // revListHead point to head of reversed list
        head.next.next = head;  // we will do all modification using head poinnter only, revListHead is only for pointing to head node of reversed list.
 
        head.next = null;
 
        /* fix the head pointer */
        return revListHead;
    }
 
    
}
