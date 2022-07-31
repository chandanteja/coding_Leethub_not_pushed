/**
 * postorder: left-right-root
 */

package Trees;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data=data;
        left=right=null;
    }
}

public class PostOrderRecursive {

    public static void postorder(Node root)
    {
        if(root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void main(String[] args)
    {
        Node tree = new Node(1);
        
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.left.right = new Node(6);
        tree.left.right = new Node(5);
        tree.left.right.left = new Node(7);
 
       
        System.out.println( "\nInorder traversal of binary tree is ");
        postorder(tree);
 
        
    }
    
}
