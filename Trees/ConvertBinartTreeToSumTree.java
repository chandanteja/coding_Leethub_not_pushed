/**
 * https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/ 
 * Logic, we first go to end of binary tree and if we encounter child node, we will replacce the node value with 0 and return the previous node value to parent.
 * Now at parent, we will have sums from both left and right children, we now calculate the sum at the node , replace with respective value and return sum to parent node.
 * 
 */

package Trees;

import java.util.Stack;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left=right=null;
    }

}

public class ConvertBinartTreeToSumTree {

    public static int sumTree(Node node)
    {
        if(node==null)  // base case if we reach a leaf node.
            return 0;
        if(node.left == null && node.right==null)   // when we reached leaf node, we will replace node value with '0' and return prev. value
        {
            int temp=node.data;
            node.data =0;
            return temp;
        }
        // we recurse in both left and right subtrees of a node.
        int lstVal = sumTree(node.left);    
        int rstVal = sumTree(node.right);
      
        // after returning from recursion, we will calculate the sum at that node using values that we have got from left and right children. 
        int sum = lstVal+rstVal;
        // We need to return a value to parent node, that value is sum of of all values in  the left subtree of parent node. So, we will calculate,
        // we calculate the sum value obtained at current node and the value the current node has before replacing.
        int temp = sum+node.data;   
        
        // value at a node will be sum of values from left and right children.
        node.data = sum;
        return temp;
    }

    public static void inorderIterative(Node root)
    {
            if(root == null)
                return;
          
           Stack<Node> stk = new Stack<>();
            Node curr;      // points to current node
           
            curr = root;
            while(curr!= null || !stk.empty())      // we proceed if either curr ptr is not null or stack is not empty.
            {
                while(curr!=null)   // we move left till we encounter null node on left. After that we pop the top ele, print and move right for that ele.
                {
                    stk.push(curr);
                    curr= curr.left;
                }
                curr = stk.pop();
                System.out.print(curr.data + " ");
                curr=curr.right;
            }

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
 
       
        System.out.println( "\nInorder traversal of binary tree before sum tree conversion is ");
        inorderIterative(tree);
        sumTree(tree);
        
        System.out.println( "\nInorder traversal of binary tree After sum tree conversion is ");
        inorderIterative(tree);
        
        
    }
    
}
