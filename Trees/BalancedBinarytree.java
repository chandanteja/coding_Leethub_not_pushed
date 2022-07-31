
/**
 * Check if the given tree is balanced or not.
 * 
 * Check complete interview preparation video for clear understanding.
 * 
 *  Logic, we maintain two values for every node.
 *  one is height of the node and other is balance factor (b.f) of the node.
 *  b.f = height of left subtree - height of right subtree.
 *  the value of b.f shuld be {-1,0,1}.
 *  if b.f voilates above ppty, then we return false else we return true.
 *  For every node, we caalculate its height and its b.f from left and right subtree heights.
 * 
 * NOTE: height of a tree will be greater than or equal to 0. WIll never be negative.
 */

package Trees;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left=right = null;
    }
}

public class BalancedBinarytree {

    static int height(Node root)
    {
        if(root == null)    // means reached a node which doesnt have any tree. So, ht is 0
            return 0;
        int leftHeight = height(root.left);
        if(leftHeight==-1)
            return -1;      // means somewhere in the left subtree of a node there is imbalance.So, return -1
        int rightHeight = height(root.right);
        if(rightHeight ==-1)   // means somewhere in the right subtree of a node there is imbalance.So, return -1
            return -1;
        int ht = 1+Math.max(leftHeight,rightHeight);
        int bf = leftHeight-rightHeight;
        if( Math.abs(bf)<1 )
            return -1;
        else    
            return ht;

    }

    static boolean isBalanced(Node root)
    {
        int balanced = height(root);
        if(balanced==-1)
            return false;
        return true;
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
 
        if(isBalanced(tree))
            System.out.println("Tree is balanced");
        else
        System.out.println("Tree is not balanced");
 
        
    }
    
}
