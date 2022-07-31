
/**
 * https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
 * 
 * https://leetcode.com/problems/maximum-width-of-binary-tree/  --> this is different from gfg. Have a look at this once.
 * 
 * We need to keep track of indexes of children of a node.
 * https://leetcode.com/problems/maximum-width-of-binary-tree/discuss/1239920/BFS-Without-using-Map-or-another-queue-or-making-a-new-class
 * 
 * Width of a Binary tree is number of nodes in a level.
 * Max width is width which is max among all widths of a given binary tree. 
 * We can do level order traversal and keep track of width of each level.
 * 
 * T.C : O(n)
 * S.C : O(w) w-width of tree.
 * 
 */
package Trees;

import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data= data;
        left=right=null;
    }
}

public class MaxWidthOfBinaryTree {

    public static int getMaxWidth(Node root)
    {
        if(root == null)
            return 0;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        int maxWidth=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            if(maxWidth<size)
                maxWidth=size;
            while(size>0)
            {
                size--;
                Node temp = q.poll();
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
                
            } 
        }
        return maxWidth;
    }
    
    public static void main(String args[])
    {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(8);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);
  
        // Function call
        System.out.println("Maximum width is " + getMaxWidth(root));
    }
}
