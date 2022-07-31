
/**
 * https://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/
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

public class MinAndMaxInBST {

    public static int minElement(Node root)
    {
        if(root==null)
            return -1;
        if(root.left==null)
            return root.data;
        return minElement(root.left);
    }
    public static int maxElement(Node root)
    {
        if(root==null)
            return -1;
        if(root.right==null)
            return root.data;
        return maxElement(root.right);
    }

    public static void main(String[] args) {
        
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(10);
       
  
        System.out.println("Minimum value of BST is " + minElement(root));
        System.out.println("Max value of BST is " + maxElement(root));
    }
    
}
