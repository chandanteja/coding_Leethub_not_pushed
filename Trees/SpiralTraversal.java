/**
 * This is same as zig-zag traversal of tree.
 * 
 * https://ide.geeksforgeeks.org/YY5ZIZVZlS
 * 
 * Watch GFG course video for clear understanding.
 * We take 2-stacks, we push alternate levels into different stacks.
 * Let 2 stacks be s1,s2.
 * 1. Push root on to s1.
 * 2. While any of the 2 stacks is not empty loop
 *      1. while s1 is not empty
 *          a)Take out the node and print it.
 *          b)push children of popped node into stack s2 i.e push left child first then right child.
 *      2. while s2 is not emppty,
 *          a)take out node and print it.
 *          b)push children of taken out node into s1 in reverse order i.e right child first then left child
 * 
 */

package Trees;

import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

public class SpiralTraversal {

    public static void spiralOrderTraversal(Node root)
    {
        if (root == null) 
          return;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);      // push root node first into s1, so that we can get started.

        // loop if any of the stack is not empty
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            while(!s1.isEmpty())
            {
                Node temp = s1.pop();
                System.out.print(temp.data+" ");

                // for an element popped in s1, we push popped ele's children to s2 as left,right order
                if(temp.left!=null)
                    s2.push(temp.left);
                if(temp.right!=null)
                    s2.push(temp.right);
            }
            while(!s2.isEmpty())
            {
                Node temp = s2.pop();
                System.out.print(temp.data+" ");

                 // for an element popped in s2, we push popped ele's children to s1 as right,left order
                if(temp.right!=null)
                    s1.push(temp.right);
                if(temp.left!=null)
                    s1.push(temp.left);
            }
        }

    }

    public static void main(String args[]) 
    { 
        Node root=new Node(1);
    	root.left=new Node(2);
    	root.right=new Node(3);
    	root.left.left=new Node(4);
    	root.left.right=new Node(5);
    	root.right.left=new Node(6);
    	root.right.right=new Node(7);
    	
        spiralOrderTraversal(root);
    } 

    
}
