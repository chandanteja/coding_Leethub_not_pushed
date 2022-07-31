/**
 * Watch GFG video from Complete placement prep track. ---> https://practice.geeksforgeeks.org/tracks/P100-Tree/?batchId=238
 * Diameter is the length of the longest path b/w any 2 nodes in tree. Longest path will be mostly from 2-leaf nodes.
 * The diameter can pass from the root of tree or need not pass from root of tree.
 * So, As diameter is length of longest path ,we can use height method to find height of tree, but as the diameter need not pass thru toor node, We find height for every node.
 * We calculate diameter as below.
 * 1. Find height of every node,diameter for left subtree and right subtrees rooted at that node.
 * 2. We take the maximum of these 3 values.
 * 3. We also maintain a global variable , to track of maximum see so far, which at the end gives us diameter.
 */

package Trees;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

public class DiameterOfBinaryTree {

   static int diameter=0;
    public static int height(Node root)
    {
        if(root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        diameter = Math.max(diameter, 1+leftHeight+rightHeight);
        return 1+Math.max(leftHeight, rightHeight);

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
 
       
        System.out.println( "\n Diameter of binary tree is ");
        height(tree);
        System.out.println("diameter: "+ diameter);
 
        
    }
    
}
