/**
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * Process:    
 * 1. First check if root is null
 * 2. Now create a stack to hold nodes.
 * 3. initialize current pointer same as root pointer.
 * 4. push current pointer on stack and keep moving left till we encounter null.
 * 5. WHen we encounter null while going left, pop the top node, print and move to right from there.
 * Repeat from step-4
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

public class InorderIterative {

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
 
       
        System.out.println( "\nInorder traversal of binary tree is ");
        inorderIterative(tree);
 
        
    }
    
}
