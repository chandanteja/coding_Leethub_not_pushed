/**
 * 
 * https://www.geeksforgeeks.org/quicksort-on-singly-linked-list/       ---> partition function is refered from here
 * 
 * https://ide.geeksforgeeks.org/rafXuG055R     --> refer this for sort logic.
 * 
 * 
 * In partition(), we consider last element as pivot. 
 * We traverse through the current list and if a node has value greater than pivot, we move it after tail. 
 * If the node has smaller value, we keep it at its current position. 
 * 
 * 
 * 
 */

package LinkedList;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}

public class QuickSortOnLL {

    static Node partition(Node start,Node end)
    {
      if (start == end || start == null || end == null)
           return start;

       Node pivot_prev = start;
       Node curr = start;
       int pivot = end.data;

      
       while (start != end) {
           if (start.data < pivot) {
               // keep tracks of last modified item
               pivot_prev = curr;
               int temp = curr.data;
               curr.data = start.data;
               start.data = temp;
               curr = curr.next;
           }
           start = start.next;
       }

       
       int temp = curr.data;
       curr.data = pivot;
       end.data = temp;

       return pivot_prev;
   }
   
   // this below code of sorting is same as quicksort.
   
   static void quickSortrec(Node head,Node tail)
   {

     if(head==tail || tail== null || head==null) 
            return;
     
     Node pivot=partition(head,tail);
     
     // recurring on lists before pivot (elements <= pivot) and afer piovt (elements greater than  pivot).
     quickSortrec(head,pivot);
     quickSortrec(pivot.next,tail);

   }
   
   public static Node quickSort(Node node)
   {
       if(node == null || node.next == null)
           return node;
       
      Node tail=node,head=node;
      
      // to call sort(), we need start and end of list. So, we are traversing for this reason.
      while(tail.next!=null)
            tail=tail.next;
      quickSortrec(head,tail);
      return node;
   }

    
}
