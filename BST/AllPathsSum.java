/**
 * https://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
 * 
 * Objective is to sum all paths data and  and return. While going down the path, we need to multiply each element by 10.
 * time complexity is O(n).
 */

package BST;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left= right = null;
    }
}



public class AllPathsSum {

    // Returns sum of all root to leaf paths. The first parameter is 
    // root of current subtree, the second parameter is value of the  
    // number formed by nodes from root to this node
    public static int calcSum(Node root,int val)
    {
        if(root==null)
            return 0;

        // Update val by adding current node value before adding, we need to multiply previous val with 10.
        val = val*10 + root.data;

        // if current node is leaf, return the current value of val
        if(root.left==null && root.right==null)
            return val;

        // recur sum of values in left and right subtree i.e calculate sum in left and right subtrees. 
        return calcSum(root.left,val)+calcSum(root.right,val);
    }

    public static int allPathsSum(Node root)
    {
        return calcSum(root,0);
    }

    public static void main(String args[]) 
    {
       
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(5);
        root.right.right = new Node(4);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.left.right.right = new Node(4);
        root.left.right.left = new Node(7);
           
        System.out.print("Sum of all paths is " + allPathsSum(root));   
    }    
    
}
