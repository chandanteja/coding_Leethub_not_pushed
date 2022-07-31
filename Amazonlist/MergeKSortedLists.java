/**
 *  https://www.geeksforgeeks.org/merge-k-sorted-linked-lists-set-2-using-min-heap/
 *  
 * 
 */
package Amazonlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next=null;
        }
    }
    public static Node mergeKSortedLists(Node arr[],int k)
    {
        Node head,last; // head points to the starting node of resultant list and last points to last node of resultant list. last is useful in adding new ele at the last of resultant LL.
        head=last=null; // Also last is useful in moving forward in the linked list we create.

        // priority_queue 'pq' implemeted as min heap with the help of 'compare' function
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){

            @Override
            public int compare(Node o1, Node o2) {
                if(o1.data < o2.data)
                    return -1; 
                if(o1.data > o2.data)
                    return 1;
                return 0;
            }

            /*
                public int compare(Node o1, Node o2) {
                
                    return o1.data-o2.data;
            }
            */
        });
        
        // push the head(first) nodes of all the k lists into 'pq'
        for(int i=0;i<k;i++)
        {
            if(arr[i]!=null)        // to avoid null ptr exception. like there can be lists like [[]]
                  pq.add(arr[i]);
        }
        // loop till 'pq' is not empty
        while(!pq.isEmpty())
        {
            Node top = pq.poll();

            // check if there is a node next to the 'top' node in the list of which 'top' node is a member
            if(top.next!=null)
                pq.add(top.next);  // push the next node in 'pq'

                if(head==null)  // head and last points to final sorted list. So, if head is null, we initialize head with first node.
                {
                    head=top;
                    last=top;
                }
                else
                {   // if head is not null, it means there are nodes already in list. So, using last, we will iterate in list. 
                    // insert 'top' at the end of the merged list so far 
                    last.next=top;
                    last=last.next; // update the 'last' pointer
                }
        }
        return head;
    }

    public static void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
 
    public static void main(String args[])
    {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list
 
        // an array of pointers storing the head nodes
        // of the linked lists
        Node arr[] = new Node[k];
 
        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);
 
        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);
 
        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);
 
        // Merge all lists
        Node head = mergeKSortedLists(arr, k);
        printList(head);
    }
    
}
