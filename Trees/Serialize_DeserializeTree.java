/**
 * 
 * Refer GFG self paced DSA --> Trees
 * 
 * We do post order traversal and store in given array list --> serialize
 * 
 * Deserialize:
 * ------------
 * We take and index and fetch element at index-i from array list and if its null we return null else we create a node and recur on its left and right.
 * 
 * 
 */
package Trees;

import java.util.*;

public class Serialize_DeserializeTree {

    static final int EMPTY = -1;
    int index=0;
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    if(root==null)
	    {
	        A.add(EMPTY);
	        return;
	    }
	    A.add(root.data);
	    serialize(root.left,A);
	    serialize(root.right,A);
	}
	
	
    public Node deSerialize(ArrayList<Integer> A)
    {
        if(index==A.size())
        {
            return null;
        }
        
        int val = A.get(index);
        index++;
        
        if(val==EMPTY)
            return null;
        Node temp = new Node(val);
        temp.left= deSerialize(A);
        temp.right=deSerialize(A);
        return temp;
    }
    
}
