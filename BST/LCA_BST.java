
/**
 * https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
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

public class LCA_BST {
    
    static Node LCA(Node root,int n1,int n2)
    {
        if(root==null)  
            return root;

        // recurr in left subtree.
        if(n1< root.data && n2<root.data )
            return LCA(root.left,n1,n2);

            // recur in right subtree.
        if(n1> root.data && n2>root.data)
            return LCA(root.right,n1,n2);

        return root;
        
    }

}
