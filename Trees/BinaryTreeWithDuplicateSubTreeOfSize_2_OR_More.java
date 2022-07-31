/**
 * https://www.youtube.com/watch?v=_j7yb_nWFO8
 * 
 * https://www.geeksforgeeks.org/check-binary-tree-contains-duplicate-subtrees-size-2/
 * 
 * Logic is we store the subtree along which we travel as a string in a map and increment the counter if we encounter same string again.
 * To distinguish between different cases, we also use a de-limiter.
 * The idea is to serialize subtrees as strings and store the strings in hash table. Once we find a serialized tree (which is not a leaf) already existing in hash-table, we return true. 
 * 
 */

package Trees;

import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node left,right;
    Node(int data)
    {
        this.data=data;
    }
};

public class BinaryTreeWithDuplicateSubTreeOfSize_2_OR_More {

  static  Map<String,Integer> map = new HashMap<>();

   static String findDuplicateSubtree(Node root)
    {
        if(root==null)
            return "#";     // to differentiate between some cases, we use this delimitter when we send back when null is encountered.
        String s = "";
        if(root.left == null && root.right==null)
            {
                s= String.valueOf(root.data);
                return s;
            }
            // logic is we create a string of subtree we traverse and store in a map.
            s= s+ String.valueOf(root.data);    
            s=s+ findDuplicateSubtree(root.left);
            s=s+ findDuplicateSubtree(root.right);
            
            if(!map.containsKey(s)) // if map doesnt contain key, we store it.
                map.put(s,1);
            else        // if map contains the key, we increase its value.
            {
                int val = map.get(s);
                map.replace(s,++val);
            }
            return s;
            
    }
        
       static int dupSub(Node root) 
        {
           map.clear(); // as map is static, we need to clear everytime.
           findDuplicateSubtree(root);
           for(Map.Entry<String,Integer> entry: map.entrySet())
           {
              // System.out.println(entry.getValue()+" ");
               
             if(entry.getValue()>=2)    // if any string representation of subtree is having occurrence greater than-1 then its is duplicate.
                 return 1;      // contains subtree of size>=2
           }    
           return 0;    // doesnt contain subtree of size>=2
        }


        public static void main(String args[])
        {
            Node root = new Node('A');
            root.left = new Node('B');
            root.right = new Node('C');
            root.left.left = new Node('D');
            root.left.right = new Node('E');
            root.right.right = new Node('B');
            root.right.right.right = new Node('E');
            root.right.right.left= new Node('D');
            int str = dupSub(root);
            if(str==1)
                System.out.print(" Yes ");
            else   
                System.out.print(" No ");
        }
}
