/**
 * https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
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

public class DeletionInBST {

    Node deleteRec(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;
 
        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
 
        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child. If we want to remove a node having only one child, the we remove the node and attach its only child to parent.
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.data = findSuccessor(root.right);
 
            // Delete the inorder successor value by moving right
            root.right = deleteRec(root.right, root.data);
        }
 
        return root;
    }

    static int findSuccessor(Node root) // we get the node after moving right for one time (we get this from caller point).
    {
        // so now we can move all left only.
        Node temp =root;
        while(temp.left!=null)
            temp=temp.left;
        return temp.data;
    }
    
}
