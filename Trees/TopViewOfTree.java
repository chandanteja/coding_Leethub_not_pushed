/**
 * https://www.youtube.com/watch?v=EBTku_aIPXk
 * https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/   --> refer java version
 * logic, we traverse the tree in level order fashion and push each node as a QueueObj value.
 * Horizontal dist is the dist from root node. If dist is left of root its negative and if right of root then its positive.
 * We need to print the node in top view, if  it is the first node seen in that respective horizontal dist.
 * We maintain a map<horizontal dist, Node> mapping and we update the values in map if the value is not already present.
 * Remaining is same as levele order traversal
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

public class TopViewOfTree {

    
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
            if(!topViewMap.containsKey(temp.hd))
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
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.right = new Node(4);
        tree.left.right.right = new Node(5);
        tree.left.right.right.right = new Node(6);
 
       
        System.out.println( "\nTop view of binary tree is ");
        printTopView(tree);
 
        
    }
    
}
