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
        this.data=data;
        left=right=null;
    }
}

public class InsertionIntoBST {

    public static Node insert(Node root,int key)
    {
        if(root==null)  // if root==null means we reached a place where there is no node and reached end of path, so, we need to create a new node and insert.
        {
            Node temp = new Node(key);
            return temp;
        }
        if(key<root.data)   // if key is < current node data, we shuld go left of current node for insertion.
            root.left=insert(root.left,key);    // if a new node is created in above (root==null)-case, then we need to put that in left of current node, if this case is satisfied.
                                                // so we assign to left of node.
        else if(key>root.data)      // if key is > current node data, we shuld go right of current node for insertion.
            root.right=insert(root.right,key);  // if a new node is created in above (root==null)-case, then we need to put that in right of current node, if this case is satisfied.
                                                // so we assign to right of node.
        return root;
    }
    
    static void inorder(Node root)
    {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data+ " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args)
    {
        Node root =null;
        
      root= insert(root,50);
      root=  insert(root,30);
      root=  insert(root,20);
      root=  insert(root,40);
      root=  insert(root,70);
      root=  insert(root,60);
      root=  insert(root,80);
 
        // print inorder traversal of the BST
        inorder(root);
    }

}
