
/**
 * https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/ --> recursive
 * Logic, is
 *  Height of a tree is either number  of nodes OR edges in longest pathe from root to any of the leaves.
 * SO, to find height of tree, we find height of tree recursively in left and right subtrees and take mas among them bcz height of tree is root to leaves which has longest length.
 * So, height of tree = 1+ max(ht of left subree, ht of right sub tree)
 */

package Trees;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left=right=null;
    }
}

public class HeightOfTreeRecursive {
    
    public static int heightRecursive(Node root)
    {
        if(root == null)
            return 0;
        return 1+Math.max(heightRecursive(root.left),heightRecursive(root.right));
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
 
       
        System.out.println( "\n Height of binary tree is ");
        int ht=heightRecursive(tree);
            System.out.println("Ht: "+ ht);
 
        
    }

}
