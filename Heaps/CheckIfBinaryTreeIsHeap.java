package Heaps;

/**
 *  Approach: We need to check 2 ppties. 1) Complete Binary tree or not. 2)Heap ppty (consider Max-heap)
 *  https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-heap/
 *  
 */

class Node {
    int key;
    Node left, right;
 
    Node(int k)
    {
        key = k;
        left = right = null;
    }
}

public class CheckIfBinaryTreeIsHeap {

    public static boolean isCompleteBT(Node root, int numberOfNodes, int indexOfNode)
    {
        // If node is null then it is complete B.T
        if (root == null)
                return true;
            //  If the numberof nodes in the tree are lesser than the index of current node under consideration, then it doesnt follow complete Binary tree ppty.
            // To understand this, give numbering too all nodes in level-order fashion starting from root and check if indices of all nodes is <= number of nodes in tree.
            // if any node is having index > number of nodes in tree then it voilates complete BT ppty.
            if (indexOfNode >= numberOfNodes)
                     return false;
            // recur on left and right subtrees and left and right subtrees will have index of 2i+1 and 2i+2;
            return isCompleteBT(root.left, numberOfNodes,2 * indexOfNode + 1)&& isCompleteBT(root.right,numberOfNodes,2 * indexOfNode + 2);
    }

    // there will be only  3 types of nodes in heap. 
    // 1) node with 2 children, 2) node with 0-child 3) Node with one child( There will be only one-node of this kind bcz if more than one node has one-child then complete BT ppty is voilated)
    public static boolean isGivenTreeHeap(Node root)
    {
        if (root.left == null && root.right == null)
                 return true; // leaf nodes will satisfy heap ppty
                   
        if (root.right == null) {   // node with only one child will have right as null as the only child will be to left of node
            
                // check if parent value is greater than child value or not.
                return root.key >= root.left.key;

        }   
        
            else
            {
                // if the value at root node is greater than its both children, then we check the heap ppty in both left and right sub trees.
                if (root.key >= root.left.key && root.key >= root.right.key)
                return isGivenTreeHeap(root.left) && isGivenTreeHeap(root.right);
            else
                return false;
    }

}

int countNodes(Node root)
{
    if(root==null)
        return 0;
    return (1+countNodes(root.left)+countNodes(root.right));
}


boolean isHeap(Node root)
    {
        if (root == null)
            return true;
 
        // These two are used
        // in isCompleteBT()
        int node_count = countNodes(root);
 
        if (isCompleteBT(root, 0, node_count) == true
            && isGivenTreeHeap(root) == true)
            return true;
        return false;
    }

    public static void main(String args[])
    {
        CheckIfBinaryTreeIsHeap bt
            = new CheckIfBinaryTreeIsHeap();
 
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(1);
 
        if (bt.isHeap(root) == true)
            System.out.println(
                "Given binary tree is a Heap");
        else
            System.out.println(
                "Given binary tree is not a Heap");
    }
    
}
