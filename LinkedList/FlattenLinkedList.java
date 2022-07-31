/**
 * 
 * https://www.youtube.com/watch?v=97rrJF7qYTo&t=607s      --> watch this video.
 * 
 * 
 */

package LinkedList;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}

public class FlattenLinkedList {

    // merge is same as we do merge of 2-sorted LinkedList in merge sort.

    Node merge(Node list1, Node list2)      // this is basic merge function of merge sort, this can be done iteratively also.
    {
        if(list1==null) // if list1 is empty, return list2 (even when list2 is empty)
            return list2;
        if(list2==null) // if list1 is not empty and list2 is empty the return list1.
            return list1;
            
        Node result;
        
        if(list1.data <=list2.data) // when list1 node has smaller data than list2 node
        {
            result = list1;     // take list1 node.
            result.bottom = merge(list1.bottom,list2);      // proceed to bottom node in list1 and recursively call list2.
        }
        else        // when list2 node has smaller data than list1 node
        {
            result = list2;     // take list2 node.
            result.bottom = merge(list1,list2.bottom);  // proceed to bottom node in list2 and recursively call list1.
        }
        result.next = null; // the next node of the result will be null as bottom will contain flattened LL.
        return result;
        
    }
    
    Node flatten(Node root)
    {
	    if(root==null || root.next==null)
	        return root;
	    return merge(root,flatten(root.next));  // recursively merge 2-2 lists, from last to first.
        // list is considered as node to its bottom most node. (vertically)
    }
    
}
