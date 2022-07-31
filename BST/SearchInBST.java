
/**
 * https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 * 
 */

package BST;

class Node{
    int data;
    Node left,right;

    Node(int data)
    {
        this.data = data;
        left=right=null;
    }
}

public class SearchInBST {
    public static boolean search(Node root,int key)
    {
        if(root==null)
            return false;
        if(root.data == key)    
            return true;
        if(key<root.data)
            return search(root.left,key);
        else    // when key > root.data
            return search(root.right,key);

    }


    
}
