/**
 * https://www.geeksforgeeks.org/simple-recursive-solution-check-whether-bst-contains-dead-end/
 * 
 * First of all, it is given that it is a BST and nodes are greater than zero, 
 * root node can be in the range [1, ∞] and if root val is say, val, then left sub-tree can have the value in the range [1, val-1] and right sub-tree the value in range [val+1, ∞]. 
 * 
 * when the the min and max value of range coincided it means that we cannot add any node further in the tree. 
 * Hence we encounter a dead end.
 */

package BST;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left= right = null;
    }
}

public class CheckBSTHasDeadEnd {
    
// Returns true if tree with given root contains
// dead end or not. min and max indicate range
// of allowed values for current node. Initially
// these values are full range
   static boolean deadEnd(Node root, int min, int max)
    {
        // if the root is null or the recursion moves
        // after leaf node it will return false bcz there is a chance of inserting new node.
        // i.e no dead end.
        if (root==null)
            return false;
    
        // if this occurs means dead end is present.
        if (min == max)
            return true;
    
        // heart of the recursion lies here.
        return deadEnd(root.left, min, root.data - 1)||
                    deadEnd(root.right, root.data + 1, max);
    }

    public static void main(String args[])
    {

        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left= new Node(2);
        root.right=new Node(11);
        root.left.right= new Node(7);
        root.left.left.right= new Node(3);

        root.left.left.right.right= new Node(4);

        if (deadEnd(root ,1 ,Integer.MAX_VALUE) == true)    // as the nodes lie between (1,INFINITY), (zero wont be there), so we will call the function with 1,max_val.
 
            System.out.println("Yes ");
        else
            System.out.println("No " );
    }

}
