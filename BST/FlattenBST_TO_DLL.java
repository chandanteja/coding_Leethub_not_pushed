/**
 * Same as converting binary tree to DLL. We follow inorder traversal  here.
 * Refer convert Binary tree tO DLL file.
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


public class FlattenBST_TO_DLL {
 
    static Node prev = null;
    public static Node convertBSTTODLL(Node root)
    {
        if(root==null)
            return null;
        Node head = convertBSTTODLL(root.left);

        if(prev==null)
            head=root;  // we are setting head bcz, if we have reached leftmost end, it means this is the start of DLL/List, so we set head only one time.
        else
        {   //prev points to previous node i.e node in prev iteration, and root points to current node.
            // So prev.nexxt will be current node (root) and current node left will be previous node.
            root.left = prev;
            prev.right = root;
        }
        prev=root;
        convertBSTTODLL(root.right);
        return head;    // returning the head of DLL created.
    }

    static void printlist(Node root)
    {
        while (root != null)
        {
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    public static void main(String[] args)
    {
       Node root = new Node(50);
       root.left = new Node(30);
       root.left.left = new Node(20);
       root.left.right = new Node(40);
       root.right = new Node(70);
       root.right.left = new Node(60);
       root.right.right = new Node(80);

       Node head = convertBSTTODLL(root);
    printlist(head);

    }
    
}
