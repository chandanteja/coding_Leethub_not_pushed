/**
 * https://www.geeksforgeeks.org/print-left-view-binary-tree/       --> this is for leftview but for right view also logic is same. Just a small change in calling sequence.
 * Logic is, print first node in every level.
 *  We can do level order traversal and print the first node encountered in each level.
 *  We can also do recursion, using whichfirst we will keep track of current level we are in and also the max level we have visited till now thru recursion.
 *  We keep track of maxlevel visited and the current level we are in. So if maxlevel visited is less than current level then we can print teh data and update the current level.
 * Bcz this is the first time we visited this level. So, max level visited will be lessthan current  level.
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

public class RightView {


    static int maxLevelVisited=-1;

    public static void rightView(Node node, int currLevel)
    {
        if(node == null)
            return;

            // If this is the first node of its level
        if(maxLevelVisited<currLevel)
        {
            System.out.print(" "+ node.data);
            maxLevelVisited = currLevel;
        }
        // for left view, we call the left node of a node first and in right view we call the right chiild of a node first.
        // We do this bcz, as per our logic, we print the first node encountered in a level. If we call left child first, then first node encountered will be left most value first.
        // if we call right child first, then the node encountered first will be right most value first. So ,by keeping track of levels, we print only first most encountered node in a levvel.
        // SO we need to call right child first for right view and left child first for left view.
        rightView(node.right, currLevel+1);
        rightView(node.left, currLevel+1);
       

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
 
        rightView(tree,0);         
        
    }
}
