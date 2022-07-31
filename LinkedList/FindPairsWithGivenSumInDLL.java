/**
 * 
 * https://www.geeksforgeeks.org/find-pairs-given-sum-doubly-linked-list/
 * 
 *  We will be given sorted DLL.    
 * 
 */

package LinkedList;

public class FindPairsWithGivenSumInDLL {

static class Node
{
    int data;
    Node next, prev;
};

static void pairSum( Node head, int x)
{
    // Set two pointers, first
    // to the beginning of DLL
    // and last to the end of DLL.
    Node first = head;
    Node last = head;
    while (last.next != null)
        last = last.next;
 
    // To track if we find a pair or not
    boolean found = false;
 
    // The loop terminates when 
    // they cross each other (last.next
    // == first), or they become same
    // (first == last)
    while ( first != last && last.next != first)
    {
        // pair found --> we will move both pointers i.e we move both first and last
        if ((first.data + last.data) == x)
        {
            found = true;
            System.out.println( "(" + first.data +", "+ last.data + ")" );
 
            // move first in forward direction
            first = first.next;
 
            // move last in backward direction
            last = last.prev;
        }
        else    // if adding first.data and last.data is < x it means the smaller nmber is not contributing sufficiently, so we move first ptr
        {
            if ((first.data + last.data) < x)
                first = first.next;
            else        // if adding first.data and last.data is > x it means the larger nmber is  contributing more than needed, so we move last ptr
                last = last.prev;
        }
    }
 
    // if pair is not present
    if (found == false)
        System.out.println("No pair found");
}

static Node insert(Node head, int data)
{
    Node temp = new Node();
    temp.data = data;
    temp.next = temp.prev = null;
    if (head == null)
        (head) = temp;
    else
    {
        temp.next = head;
        (head).prev = temp;
        (head) = temp;
    }
    return temp;
}
 
// Driver Code
public static void main(String args[])
{
    Node head = null;
    head = insert(head, 9);
    head = insert(head, 8);
    head = insert(head, 6);
    head = insert(head, 5);
    head = insert(head, 4);
    head = insert(head, 2);
    head = insert(head, 1);
    int x = 7;
 
    pairSum(head, x);
}
    
}
