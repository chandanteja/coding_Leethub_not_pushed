/**
 * https://www.geeksforgeeks.org/print-paths-root-specified-sum-binary-tree/
 */
package BST;

import java.util.ArrayList;

class Node{

    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left=right=null;
    }
}

public class PrintRootToLeafSumPath {
    
    static void pathSumUtil(Node root,int sum,int sumSoFar,ArrayList<Integer> path)
    {
        if(root==null)  
            return;
        
        // Add the current node's value
        sumSoFar+= root.data;
        
        // Add the value to path
        path.add(root.data);

        // Print the required path if sum is found.
    if (sumSoFar == sum) 
    {
        System.out.print("Path found: ");
        for(int i = 0; i < path.size(); i++)
            System.out.print(path.get(i) + " ");
              
        System.out.println();
    }

    // recurr in left and right sub trees if they exist.
    if(root.left!=null)
        pathSumUtil(root.left, sum, sumSoFar, path);
    if(root.right!=null)
        pathSumUtil(root.right, sum, sumSoFar, path);
    
    // Remove last element from path
    // and move back to parent
    path.remove(path.size() - 1);

    }
    static void printPaths(Node root, int sum)
    {
        ArrayList<Integer> path = new ArrayList<>();
        pathSumUtil(root, sum, 0, path);
    }
      
    // Driver code
    public static void main(String[] args)
    {
          
        /*    10 
           /     \ 
         28       13 
               /     \ 
             14       15 
            /   \     /  \ 
           21   22   23   24*/
        Node root = new Node(10);
        root.left = new Node(28);
        root.right = new Node(13);
      
        root.right.left = new Node(14);
        root.right.right = new Node(15);
      
        root.right.left.left = new Node(21);
        root.right.left.right = new Node(22);
        root.right.right.left = new Node(23);
        root.right.right.right = new Node(24);
      
        int sum = 38;
      
        printPaths(root, sum);
    }
}
