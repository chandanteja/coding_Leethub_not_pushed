/**
 * https://www.geeksforgeeks.org/print-left-view-binary-tree/ 
 * Logic is, print first node in every level.
 *  We can do level order traversal and print the first node encountered in each level.
 *  We can also do recursion, using whichfirst we will keep track of current level we are in and also the max level we have visited till now thru recursion.
 *  We keep track of maxlevel visited and the current level we are in. So if maxlevel visited is less than current level then we can print teh data and update the current level.
 * Bca this is the first time we visited this level. So, max level visited will be lessthan current  level.
 */

package Trees;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left=right=null;
    }
}

public class leftViewOfTree {
    static int maxLevelVisited=-1;

    public static void leftView(Node node, int currLevel)
    {
        if(node == null)
            return;

            // If this is the first node of its level
        if(maxLevelVisited<currLevel)
        {
            System.out.print(" "+ node.data);
            maxLevelVisited = currLevel;
        }
        leftView(node.left, currLevel+1);
        leftView(node.right, currLevel+1);

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
 
        leftView(tree,0);         
        
    }
}
