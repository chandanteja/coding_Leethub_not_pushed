/**
 * 
 * https://www.geeksforgeeks.org/merge-sort-for-linked-list/        --> java code here.
 * 
 * https://www.youtube.com/watch?v=EXPY4SNCbhQ      --> see this only for logic 
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
        this.data = key;
        next = null;
    }
}

public class MergeSortOnLL {

    static Node mergeSort(Node head)
    {
        // either no node or 1-node.
        if(head==null || head.next==null)
            return head;


        Node left = null,right=null;    // left and right lists
        Node middle,middlenext; // points to middle and next-to-middle elements
        
        
        middle = findMiddle(head);
        middlenext =  middle.next;
        
        middle.next=null;   // we are detaching lists from start-to-middle and middle_next-to-end
        
        // we recur on 1st list(start-to-middle) and 2nd list(middle_next-to-end)
        left = mergeSort(head);
        right = mergeSort(middlenext);
        
        return merge(left,right);
        
    }
    
    //There is iterative version of merge of 2 sorted LL, refer Merge2SortedLL.java
    static Node merge(Node list1,Node list2)
    {
        Node result_list=null;
        
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        
        if(list1.data<=list2.data)
        {
            result_list = list1;
            result_list.next = merge(list1.next,list2);
        }
        else
        {
            result_list = list2;
            result_list.next = merge(list1,list2.next);
            
        }
        return result_list;
    }
    
    
    // This is another way of finding middle element. For other way refer FindMiddleOfLL.java

    static Node findMiddle(Node head)
    {
        if(head==null)
            return head;
        
        Node fast=head,slow=head;
        
         while (fast.next != null && fast.next.next != null) 
         {
            slow = slow.next;
            fast = fast.next.next;
         }
        
        return slow;
        
    }

    // Here merge is done iteratively in LL.

    /*
        Merge is doe iteratively.    

        Node *merge(Node *head1, Node *head2)
    {
        Node *merged=new Node(-1); // points to head of merged list.
        Node *temp=merged; // to update.
        
        while(head1!=NULL && head2!=NULL) // when head1 and head2 are not null
        {
            if(head1->data<head2->data) // if head1 data is less than head2 data 
            // so insert it
            {
                temp->next=head1;
                head1=head1->next;
            }
            else// if head2 data is less than head1 data 
            // so insert it
            {
                temp->next=head2;
                head2=head2->next;
            }
            temp=temp->next; // move temp.
        }
        
        while(head1!=NULL)
        {
            temp->next=head1;
            head1=head1->next;
            temp=temp->next;
        }
        while(head2!=NULL)
        {
            temp->next=head2;
            head2=head2->next;
            temp=temp->next;
        }
        
        return merged->next; // return start of this node.
    }
    
    Node* mergeSort(Node* head) {
        // your code here
        if(head->next==NULL)
            return head;
            
        Node *left=midElement(head); // finding left and right parts. so finding mid.
        Node *right=left->next; // find right part. 
        left->next=NULL; // break the list.
        
        Node *head1=mergeSort(head); // recursive mergeSort for left part.
        Node *head2=mergeSort(right); // recursive mergeSort for right part.
        Node *merged = merge(head1, head2); // combining left and right parts.
        
        return merged;
    }
    */
    
    
}
