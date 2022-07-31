/**
 * https://www.youtube.com/watch?v=t6IwIr8mPz0  --> refer this video.
 * Process is same as level order traversal, but instead of pushing left node first then right, now push right node first and then left.
 * Afer completion of traversal, now reverse the list so that we get our result.
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
public class ReverseLevelOrder {

    public static ArrayList<Integer> reverseLevelOrderTraversal(Node root)
    {
        if(root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty())
        {
            Node curr = q.poll();
            res.add(curr.data);
            if(curr.right!=null)
                q.add(curr.right);
            if(curr.left!=null)
                q.add(curr.left);
            
        }
        Collections.reverse(res);
        return res;
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
 
       
        System.out.println( "\nReverse level order traversal of binary tree is ");
        ArrayList<Integer> res =reverseLevelOrderTraversal(tree);
        for(int i:res)
        {
            System.out.print(i+ " ");
        }
 
        
    }

    
}
