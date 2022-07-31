
/**
 * 
 * https://www.youtube.com/watch?v=GbA0E5gzxfw
 * https://www.geeksforgeeks.org/bottom-view-binary-tree/
 * Same a top view with just 1 line of modification.
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

public class BottomView {
    
    public static void printTopView(Node root)
    {
        class QueueObj{
            Node node;
            int hd; // horizontal distance. It will be negative to left of root and +ve to right of root node
            QueueObj(Node node, int hd)
            {
                this.node = node;
                this.hd = hd;
            }
        }    

        if(root==null)
            return;
        Queue<QueueObj> q = new LinkedList<>();
        Map<Integer,Node> topViewMap = new TreeMap<>();
       
        q.add(new QueueObj(root,0));    // root node will be at horizontal dist of '0' from itself.
       
        while(!q.isEmpty())
        {
            QueueObj temp = q.poll();
           // if(!topViewMap.containsKey(temp.hd)) --> this check is not needed in bottom view. We just keep on adding elements.
                topViewMap.put(temp.hd, temp.node);
            if(temp.node.left!=null)
                q.add(new QueueObj(temp.node.left,temp.hd-1));  // temp.hd-1 bcz we go left of root
            if(temp.node.right!=null)
                q.add(new QueueObj(temp.node.right, temp.hd+1));    // +1 as we go right of root.
        }

        for(Map.Entry<Integer,Node> entry: topViewMap.entrySet())
        {
            System.out.print(entry.getValue().data + " ");
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
       
        System.out.println( "\n Bottom view of binary tree is ");
        printTopView(root);
 
        
    }
    
}
