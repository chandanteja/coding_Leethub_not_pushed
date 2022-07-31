/**
 * https://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/
 * Logic is, we do level order style traversal of tree,and count nodes in each level.
 * if any node have level count of nodes as 0 then we return height.
 */

package Trees;
import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left=right=null;
    }
}

public class HeightOfTreeIterative {

    public static int heightOfTree(Node root)
    {
        if(root==null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        Node curr= root;
        q.add(curr);    // we take a queue to do level order style of traversal, so we push first node into q.
        int height=0;   

        while(!q.isEmpty()) // we iterate till queue is not empty;
        {
            int size = q.size();    // getting queue current size
            while(size>0)       // we traverse thru the node at front of queue and check for its left and right child and if they are not null, we push them.
            {
                size--;
                Node temp = q.poll();
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            height++;       // incrementing height as +1 for the node popped in inner loop.

        }
        return height;

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
        int ht=heightOfTree(tree);
        System.out.println("Ht: "+ ht);
 
        
    }

    
    
}
