/**
 * T.C = O(n)
 * S.C = O(n)
 * https://www.youtube.com/watch?v=LhXPvhrhcIk&t=316s   --> see this video for idea.
 * https://www.youtube.com/watch?v=myPeo_AIZp0 --> watch this for different method.
 * Logic is we use queue to traverse diagonally and we store the left node of any node while traversing in queue.
 */

package Trees;

import java.util.*;

class Node
{
    int data;
    Node left,right;

    Node(int data)
    {
        this.data = data;
        left=right=null;
    }
}


public class DiagonalTraversal
{
    public static void diagonalTraversal(Node node)
    {
        if(node == null)
            return ;

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty())
        {
            Node temp = q.poll();
            while(temp!=null)
            {
                if(temp.left!=null)
                    q.add(temp.left);
                System.out.print(temp.data+" ");
                temp=temp.right;
            }
        }
    }

    public static void main(String[] args)
    {
         
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
         
        diagonalTraversal(root);
    }
}