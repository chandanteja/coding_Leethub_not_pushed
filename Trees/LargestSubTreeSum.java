/**
 * 
 * https://www.youtube.com/watch?v=zm5CykXlxaA
 * https://www.geeksforgeeks.org/find-largest-subtree-sum-tree/
 * 
 * T.c = O(n)
 * S.c = O(n)
 * 
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

public class LargestSubTreeSum {

    static int maxSum=Integer.MIN_VALUE;

   public static int largestSubtreeSum(Node root)
    {
        if(root==null)
            return 0;
        int leftSum = largestSubtreeSum(root.left);
        int rightSum = largestSubtreeSum(root.right);
        maxSum = Math.max(maxSum,leftSum+rightSum+root.data);
        return leftSum+rightSum+root.data;
    }

    public static void main(String args[])
{ 
    
  
    Node root = new Node(1); 
    root.left = new Node(-2); 
    root.right = new Node(3); 
    root.left.left = new Node(4); 
    root.left.right = new Node(5); 
    root.right.left = new Node(-6); 
    root.right.right = new Node(2); 
  
    System.out.println(largestSubtreeSum(root)); 
} 
}
