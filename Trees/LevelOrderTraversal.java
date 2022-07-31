
/**
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 * https://leetcode.com/problems/binary-tree-level-order-traversal/discuss/1231564/Java-Solution-using-BFS-with-Comments%3A-Faster-than-100
 *  Refer leet code link also.
 * We use queue to print level order of a tree.
 * first we push the first node into queue and we iterate till the queue is empty.
 * If queue is not empty, we pop the front element, print it and push its left and right child if they are not null and repeat the process.
 * 
 */


package Trees;
import java.util.*;

class Node {
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left=right=null;
    }
}

public class LevelOrderTraversal {
    
public static void levelOrderTraversal(Node root)
{
    if(root == null)
        return;
    Queue<Node> q = new LinkedList<>();
    Node curr=root;
    q.add(curr);
    while(!q.isEmpty())
    {
        Node frontEle = q.poll();
        System.out.print(frontEle.data + " ");
        if(frontEle.left!=null)
            q.add(frontEle.left);
        if(frontEle.right!=null)
            q.add(frontEle.right);
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
 
       
        System.out.println( "\n Level Order of binary tree is ");
        levelOrderTraversal(tree);
           
 
        
    }
}
