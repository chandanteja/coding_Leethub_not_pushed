/**
 * 
 * We can sort the list using the MIN HEAP data structure.We push first (k+1) nodes to Min-heap. And create a new DLL.
 * 
 *  https://www.geeksforgeeks.org/sort-k-sorted-doubly-linked-list/
 * 
 * T.C : O(n*Logk)
 * S.C : O(k)
 * 
 */

package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

class Node
{
  int data;
  Node next, prev;
  Node(int d)
  {
    data = d;
    next = prev = null;
  }
}

class NodeComparator implements Comparator<Node>
{
    public int compare(Node n1,Node n2)
    {
            return (n1.data - n2.data) ;    // if n1.data < n2.data then (negative number is returned) and if n1.data > n2.data (positive number is returned). So it will be sorted in ascending order.
    }
}

public class SortKSortedDLL {




  
static Node sortAKSortedDLL( Node head, int k)
{
    // if list is empty
    if(head==null)
        return null;

        // priority_queue 'pq' implemented as min heap with the
    // help of 'compare' function in compare Node class
    PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());

    Node newHead = null;
    Node newLast = null;


// Create a Min Heap of first (k+1) elements from
    // input doubly linked list
    for(int i=0; head!=null && i<=k;i++)
    {
        // push the node on to 'pq'
        pq.add(head);
        // move to the next node
        head=head.next;
    }

    while(!pq.isEmpty())
    {
        Node temp = pq.poll();
        
        // place root or top of 'pq' at the end of the
      // result sorted list so far having the first node
      // pointed to by 'newHead'
      // and adjust the required links
        if(newHead == null)
        {
            newHead = temp;

            // 'newLast' points to the last node
        // of the result sorted list so far
            newLast = newHead;
        }
        else
        {
            newLast.next = temp;
            temp.prev = newLast;
            newLast = newLast.next;

        }

        // if there are more nodes left in the input list
        if(head!=null)
        {
            pq.add(head);
            head=head.next;
        }
    }

    // making 'next' of last node point to NULL
    newLast.next = null;

    // new head of the required sorted DLL
    return newHead;
}

  
}
