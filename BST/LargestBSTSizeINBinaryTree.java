/**
 * https://www.youtube.com/watch?v=4fiDs7CCxkc
 * https://www.geeksforgeeks.org/largest-bst-binary-tree-set-2/
 * 
 * T.C : O(n)
 * 
 * The idea is based on post-order traversal as we need to explore left subtree and right subtrees first before verifying the root node.
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



public class LargestBSTSizeINBinaryTree {

    static class BSTNodeData
    {
    
        int size; // Size of subtree
        int max; // Min value in subtree
        int min; // Max value in subtree
        int ans; // Size of largest BST which is subtree of current node i.e subtree size which is largest subtree for current node.
        boolean isBST; // If subtree is BST or not.
    
        BSTNodeData(){}   // empty constructor
    
        BSTNodeData(int size, int max, int min, int ans, boolean isBST)
        {
        this.size = size;
        this.max = max;
        this.min = min;
        this.ans = ans;
        this.isBST = isBST;
        }
    }

    static int MAX = Integer.MAX_VALUE;
    static int MIN = Integer.MIN_VALUE;
 

    public static BSTNodeData findLargestBSTSize(Node root)
    {
        // Base cases : When tree is empty or it has
         // one child.
        if(root==null)
            return new BSTNodeData(0,MIN,MAX,0,true);   // while creating node, we need to be careful, For max-> we need to send min value.
                                                        // for min--> we need to send max value.
        if(root.left==null && root.right==null)
                return new BSTNodeData(1,root.data,root.data,1,true);

        // Recur for left subtree and right subtrees
        BSTNodeData left = findLargestBSTSize(root.left);
        BSTNodeData right = findLargestBSTSize(root.right);

        // This is for currentNode, which has got responses from left and right subtrees, and checking bst ppty at current Node.
        BSTNodeData currNode = new BSTNodeData();   // this is current node at which we are checking bst ppty.
        currNode.size = 1+ left.size+right.size;    // if current node also satisfies, BST ppty then current node also can be included in max bst size.

            // If whole tree rooted under current root is BST, then we shuld update current nodes min,max,size and is bst ppty.
        if(left.isBST && right.isBST && left.max < root.data && right.min > root.data)
        {
            currNode.min = Math.min(Math.min(left.min, right.min), root.data);      // this is minimum of lst, rst and current node value.     
            currNode.max = Math.max(Math.max(left.max, right.max), root.data);      // this is max of lst, rst and current node value.
 
            // Update answer for tree rooted under
            // current 'root'.
            currNode.ans = currNode.size;       // updating the answer for current node.
            currNode.isBST = true;          // setting that current node will also be a BST as if-condition is satisfied.
            return currNode;
        }

        // If whole tree is not BST, return maximum
        // of left and right subtrees.
        currNode.ans = Math.max(left.ans, right.ans);
        currNode.isBST = false;
        return currNode;
        
    }

    static int largestBst(Node root)
    {
      return findLargestBSTSize(root).ans;
    }

    public static void main (String[] args)
    {
      Node node = new Node(60);
      node.left = new Node(65);
      node.right = new Node(70);
      node.left.left = new Node(50);
   
      System.out.println("Size of the largest BST is " + largestBst(node)+ "\n");
   
    }
    
}
