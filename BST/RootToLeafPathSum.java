/**
 * https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 * https://www.interviewbit.com/problems/path-sum/
 * 
 * Objective is : check if there exists a path sum with given sum.
 * 
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

public class RootToLeafPathSum {
    
    /*
     Given a tree and a sum, return true if there is a path from the root down to a leaf, such that adding up all the values along the path equals the given sum.
 
     Strategy: subtract the node value from the sum when recurring down, and check to see if the sum is 0 when you run out of tree.
     */

    public int hasPathSum(Node root, int sum) {
        
    if(root==null) // if root is null it means we can't get the given sum from node which is null.
            return 0;
    if(root.data==sum && root.left==null && root.right==null)   // if we are at end of tree i.e path ic completed, i.e leaf node and if sum is going to be 0 if we subtract root data from current value of sum and if its 0 then returnn true.
         return 1;
    
         // while recurring, we need to decrease the sum with current node value, and call the hasPathSum().
    if(hasPathSum(root.left,sum-root.data)==1)  // recurr in left sub tree and if we find such path in left sub tree then we will return true.
        return 1;
    return hasPathSum(root.right,sum-root.data);
        
            
     }

}
