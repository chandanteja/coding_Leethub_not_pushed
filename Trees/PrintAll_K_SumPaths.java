/**
 * https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
 * https://www.youtube.com/watch?v=_Ng486jJu80
 * 
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
        left=right=null;
    }
}

public class PrintAll_K_SumPaths {

   static Vector<Integer> paths = new Vector<>();

    //utility function to print contents of a vector from index i to it's end 
    public static void printPath(Vector<Integer> path,int i)
    {
        for (int j = i; j < path.size(); j++) 
            System.out.print( path.get(j) + " "); 
        System.out.println(); 
    }

    public static void printKSumPathUtil(Node root, int k)
    {
        // empty node 
        if(root== null)
            return;
        paths.add(root.data);

        // check if there's any k sum path in the left sub-tree. 
        printKSumPathUtil(root.left, k);
        // check if there's any k sum path in the right sub-tree.
        printKSumPathUtil(root.right, k);

        int sum=0;

         // check if there's any k sum path that terminates at this current node (root), Traverse the entire path as there can be negative elements too 
        for(int i=paths.size()-1;i>=0;i--)
        {
            sum+=paths.get(i);

            // If path sum is k, print the path
            if(sum==k)
                printPath(paths, i);

        }
        // Removing the current element with which all possible paths (path with or w/o sum = k) have been explored.
        paths.remove(paths.size() - 1); 
    }
    
    static void printKPath(Node root, int k) 
    { 
        paths = new Vector<Integer>();  // as paths is static variable, we need to create new array every time.
        printKSumPathUtil(root, k); 
    } 

    public static void main(String args[])
    { 
        Node root = new Node(1); 
        root.left = new Node(3); 
        root.left.left = new Node(2); 
        root.left.right = new Node(1); 
        root.left.right.left = new Node(1); 
        root.right = new Node(-1); 
        root.right.left = new Node(4); 
        root.right.left.left = new Node(1); 
        root.right.left.right = new Node(2); 
        root.right.right = new Node(5); 
        root.right.right.right = new Node(2); 
        
        int k = 5; 
        printKPath(root, k); 
    }

}
