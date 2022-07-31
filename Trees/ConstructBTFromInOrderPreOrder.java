
/**
 * https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 * https://www.youtube.com/watch?v=IH9jN6VdMOc --> using hashmap -->O(n)
 * https://practice.geeksforgeeks.org/tracks/P100-Tree/?batchId=238 --> Naive implementation in which we loop inorder[] for every element in preorder[]
 * 
 * Naive impl --> O(n^2)
 * Using hashmap,  we store, <element,index> pair of inorder[] elements in hash map.
 */

package Trees;

import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left = right= null;
    }
}

public class ConstructBTFromInOrderPreOrder {

    static int preidx=0;
    static Map<Integer,Integer> inorderMap = new HashMap<>();

    public static Node treeConstruction(int inorder[],int preorder[],int lb,int ub)
    {
        // lb --> lower bound, ub--> upper bound
        if(lb>ub)
            return null;    // means lower bound has crossed ub when scanning array inorder.
        
        Node temp = new Node(preorder[preidx++]);
        if(lb==ub) // leaf node in a subtree
            return temp;
        int mid = inorderMap.get(temp.data);
        temp.left = treeConstruction(inorder,preorder,lb,mid-1);    // if we get the position of root(which we got from preorder[]) in inorder[], we shuld recur in left and right subtrees
        // left and right subtrees lies in (lb,mid-1) and (mid+1,ub).
        temp.right = treeConstruction(inorder, preorder, mid+1, ub);
        return temp;
    }

    public static Node preOrderTreeConstruction(int inorder[],int preorder[])
    {
        preidx = 0;
        inorderMap.clear();
        System.out.println("hiii");
        for(int i=0;i<inorder.length;i++)
            System.out.print(inorder[i] + " ");
        for(int i=0;i<inorder.length;i++)
            inorderMap.put(inorder[i],i);
        Node root = treeConstruction(inorder, preorder, 0,preorder.length-1);
        return root;
    }

    public static void inorderIter(Node root)
    {
        if(root == null)
            return;
        Stack<Node> stk = new Stack<>();
        Node curr=root;
        while(curr!=null || !stk.isEmpty())
        {
            while(curr!=null)
            {
                stk.push(curr);
                curr=curr.left;
            }
            curr= stk.pop();
            System.out.print(" "+ curr.data);
            curr=curr.right;
        }

    }

    public static void main (String[] args)
  {
    int[] in = {'4', '2', '5', '1', '6', '3'};
    int[] pre = {'1', '2', '4', '5', '3', '6'};
    
 
    Node root=preOrderTreeConstruction(in, pre);
 
    System.out.println("Inorder traversal of the constructed tree is");
    inorderIter(root);
  }
    
}
