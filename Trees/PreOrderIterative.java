/**
 * Logic:
 *  root-left-right.
 * 1. We first push root intp stack.
 * 2. Now, we iterate till stack is not empty;
 * 3. We pop the top element, print data
 * 4. If the popped ptr right is not null, push its right.
 * 5. After step-4 if popped ptr left is not null, push its left.
 * NOTE: We push right first and then left because, we need to visit root-left-right, so when we pop from stack, we get left first and then we get right.
 *  For this reason, we push right and  tthen left.
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

public class PreOrderIterative {

    public static void preOrderIterative(Node root)
    {
        if(root == null)
            return;
        Stack<Node> stk = new Stack<>();
        Node curr = root;

        stk.push(curr);
        while(!stk.isEmpty())
        {
            curr = stk.pop();
            System.out.print(curr.data+" ");
            if(curr.right!=null)
                stk.push(curr.right);
            if(curr.left!=null)
                stk.push(curr.left);
            
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
 
       
        System.out.println( "\n PPreorder traversal of binary tree is ");
        preOrderIterative(tree);
 
        
    }
    
}
