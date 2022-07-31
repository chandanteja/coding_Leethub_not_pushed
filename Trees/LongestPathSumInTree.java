/**
 * https://www.geeksforgeeks.org/sum-nodes-longest-path-root-leaf-node/
 * 
 * Logic : we take 4-variables--> sum,maxSum, height,maxheight
 * Awhen the control reaches any null node i.e node below leaf node where root==null, then we check if height of this path is greater than max height , if so, we update maxsum
 *  if height is same and if maxSum is < sum in this path then we updatemaxsum.
 * 
 * T.C = O(n)
 * 
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

public class LongestPathSumInTree {

    static int maxSum;
    static int maxHt;

    public static void longestPathSum(Node root, int sum,int ht)// sum and ht keeps track of height of current path and sum in current path
    { // function to find the sum of nodes on the longest path from root to leaf node
        if(root == null)   // if true, then we have traversed a  root to leaf path
        {
            // update maximum length and maximum sum
            // according to the given conditions
            if(maxHt<ht)        
            {
                maxSum = sum;
                maxHt = ht;
            }
            else if(maxHt == ht && maxSum<sum)
            {
                maxSum = sum;
            }
            return;
        }
        // recur for  subtrees
        longestPathSum(root.left, sum+root.data, ht+1);
        longestPathSum(root.right, sum+root.data, ht+1);

    }


    public static int longestPathSumUtil(Node root)
    {
        if(root==null)
            return 0;
        maxSum= Integer.MIN_VALUE;
        maxHt=0;
        longestPathSum(root, 0,0);
        return maxSum;
    }

    public static void main(String args[])
    {
        // binary tree formation
        Node root = new Node(4);         
        root.left = new Node(2);         
        root.right = new Node(5);        
        root.left.left = new Node(7);    
        root.left.right = new Node(1);   
        root.right.left = new Node(2);   
        root.right.right = new Node(3);  
        root.left.right.left = new Node(6);
       
        System.out.println( "Sum = "
             + longestPathSumUtil(root));
    }

    
}
