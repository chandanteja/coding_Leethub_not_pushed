/**
 * https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/ --> refer this link
 * 
 * Since inorder traversal of BST is always a sorted array, the problem can be reduced to a problem where two elements of a sorted array are swapped. There are two cases that we need to handle:
        1. The swapped nodes are not adjacent in the inorder traversal of the BST. 
        
        2. The swapped nodes are adjacent in the inorder traversal of BST.

        We will maintain three-pointers, first, middle, and last. 
        When we find the first point where the current node value is smaller than the previous node value, we update the first with the previous node & the middle with the current node.
        When we find the second point where the current node value is smaller than the previous node value, we update the last with the current node. In the case of #2, we will never find the second point.
         So, the last pointer will not be updated. 

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

public class RecoverBST {
    
    static Node first, middle, last, prev;

    // middle helps in keeping track of case where two nodes are adjacent. If two nodes are adjacent then only first and middle are set and last will be null.
     // Else last will contain the 2nd voilation.
    // This function does inorder traversal
    // to find out the two swapped nodes.
    // It sets three pointers, first, middle
    // and last. If the swapped nodes are
    // adjacent to each other, then first
    // and middle contain the resultant nodes
    // Else, first and last contain the
    // resultant nodes
    static void correctBSTUtil( Node root)
    {
        if( root != null )
        {
            // Recur for the left subtree
            correctBSTUtil( root.left);
 
            // If this node is smaller than
            // the previous node, it's
            // violating the BST rule.
            if (prev != null && root.data < prev.data)
            {
                // If this is first violation,
                // mark these two nodes as
                // 'first' and 'middle'
                if (first == null)
                {
                    first = prev;
                    middle = root;
                }
 
                // If this is second violation,
                // mark this node as last
                else
                    last = root;
            }
 
            // Mark this node as previous
            prev = root;
 
            // Recur for the right subtree
            correctBSTUtil( root.right);
        }
    }


    // A function to fix a given BST where
    // two nodes are swapped. This function
    // uses correctBSTUtil() to find out
    // two nodes and swaps the nodes to
    // fix the BST
    static void correctBST( Node root )
    {
        // Initialize pointers needed for correctBSTUtil()
        first = middle = last = prev = null;
 
        // Set the pointers to find out two nodes
        correctBSTUtil( root );
 
        // Fix (or correct) the tree. If first and last are set, it means 2 nodes swapped are not adjacent
        if( first != null && last != null )
        {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        // Adjacent nodes swapped. bcz last wont be set and only first and middle contains nodes to be swapped.
        else if( first != null && middle != null )
        {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
 
        // else nodes have not been swapped,
        // passed tree is really BST.
    }

    static void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(" " + node.data);
        printInorder(node.right);
    }

    public static void main (String[] args)
    {
 
        Node root = new Node(6);
        root.left = new Node(10);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(12);
        root.right.left = new Node(7);
 
        System.out.println("Inorder Traversal"+ " of the original tree");
        
        printInorder(root);
 
        correctBST(root);
 
        System.out.println("\nInorder Traversal"+ " of the fixed tree");
        printInorder(root);
    }

}
