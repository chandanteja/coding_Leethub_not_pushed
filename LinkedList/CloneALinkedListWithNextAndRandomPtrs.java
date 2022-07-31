/**
 * 
 * https://www.youtube.com/watch?v=_v8O9TZwKSU      --> watch this video.
 * 
 * https://www.geeksforgeeks.org/clone-linked-list-next-random-pointer-o1-space/
 * 
 * Below is the Algorithm: 
 

 Create the copy of node 1 and insert it between node 1 & node 2 in the original Linked List, create a copy of 2 and insert it between 2 & 3.
 Continue in this fashion, add the copy of N after the Nth node 
 
 Now copy the random link in this fashion  as  original->next->random= original->random->next;

 This works because original->next is nothing but a copy of the original and Original->random->next is nothing but a copy of the random. 
 Now restore the original and copy linked lists in this fashion in a single loop. 

 T.c: O(n) and space: O(1).

 * 
 */

package LinkedList;


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CloneALinkedListWithNextAndRandomPtrs {

    public Node copyRandomList(Node head) {
        
        Node curr,temp;
        curr=head;      // curr points to current node whose next link will be modified and temp //                         //points to next node of curr node which was previously there.
        
        // here we are creating a copy node of curr node and inserting b/w curr node and curr.next node.
        while(curr!=null)
        {
            temp=curr.next; // temp points to next node of curr node
            curr.next = new Node(curr.val); // now we create a copy node with same value of 'curr'                             //node and inser in b/w curr node and previous next node of curr node.
            curr.next.next = temp;  // we update the next of copy node to point to next of previous curr node.
            curr=temp;        // updated the curr to next (which was next before adding copy ele)
        }
        
        curr=head;
        
        // now update random pointers of copy nodes with help of random pointers of original nodes.
        while(curr!=null)
        {
            curr.next.random = (curr.random!=null) ? curr.random.next : curr.random;
            curr = curr.next.next;
        }
        
        Node original = head;
        Node copy = (head!=null) ? head.next : head;
        temp = copy;
        

        // separating original and copy linked lists
        while(original!=null && copy!=null)
        {
            original.next = original.next.next;
            copy.next = (copy.next!=null) ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
        
        
    }
    
}
