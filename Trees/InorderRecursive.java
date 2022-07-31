/**
 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 * 
 * Logic: visit as  Left-Root(do any operation)-Right.
 * 
 */

package Trees;


class Node {

    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class InorderRecursive {
    
    public static void inorder(Node node)
    {
        if(node == null)
            return ;
        inorder(node.left);
        System.out.print(node.data+ " ");
        inorder(node.right);

    }

    public static void main(String[] args)
    {
        Node tree = new Node(1);
        
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
 
       
        System.out.println( "\nInorder traversal of binary tree is ");
        inorder(tree);
 
        
    }

}
