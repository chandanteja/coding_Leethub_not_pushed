/**
 * https://www.geeksforgeeks.org/check-leaves-level/
 * Logic is do level-order traversal, and keep track of the level of first visited node and also other leaf nodes level.
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

public class CheckAllLeafsAreAtSameLevel {

public static boolean checkAllLeafsAtSameLevel(Node root)
{
    if(root == null)
        return true;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    int firstLeafLevel=0;
    int currentLeafLevel=0;

    boolean leafLevel=true; // used to set the level of first leaf node and there after check the level of other leaf nodes too.

    while(!q.isEmpty())
    {
        int size = q.size();
        currentLeafLevel++;
        while(size>0)
        {
            size--;
            Node temp = q.poll();
            // setting level of first leaf node.
            if(temp.left==null && temp.right==null && leafLevel)
            {
                firstLeafLevel=currentLeafLevel;
                leafLevel=false;    // when thsi is changed to false, then we cant set the level of other leaf nodes.
            }

            // checking level of other leaf nodes
            if(temp.left==null && temp.right==null && leafLevel==false)
            {
                if(currentLeafLevel!=firstLeafLevel)
                    return false;
            }
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
            
        }


    }
    return true;
}

public static void main(String[] args)
{
    // Node tree = new Node(1);
    
    // tree.left = new Node(2);
    // tree.right = new Node(3);
    // tree.left.left = new Node(4);
    // tree.left.left.right = new Node(6);
    // tree.left.right = new Node(5);
    // tree.left.right.left = new Node(7);

             Node root = new Node(1);
             root.left = new Node(2);
             root.right = new Node(3);
             root.left.right = new Node(4);
             root.right.left = new Node(5);
             root.right.right = new Node(6);

   
    System.out.println( "\n All leaves at same level or not ");
    boolean ht=checkAllLeafsAtSameLevel(root);
    System.out.println("Res: "+ ht);
    
}

    
}
