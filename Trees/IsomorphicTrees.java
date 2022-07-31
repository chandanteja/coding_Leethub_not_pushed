/**
 * So time complexity is O(min(m,n)*2) or O(min(m,n)) where m and n are number of nodes in given trees.
 * 
 * https://www.youtube.com/watch?v=shSsw5EAp7g  --> watch this video for clear explaination.
 * We need to verify that bijective property is preserved b/w 2 trees.
 * 
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

public class IsomorphicTrees {

    public static boolean isIsomorphic(Node root1, Node root2)  
    { 
         if(root1==null && root2==null)
            return true;
        if((root1==null && root2!=null) || (root1!=null && root2==null))
            return false;
        if(root1.data!=root2.data)
            return false;
            // go in same direction on both trees
        boolean a = isIsomorphic(root1.left,root2.left) && isIsomorphic(root1.right,root2.right); // we need to check by doing same operation on both trees
        // go in different directions on both trees.
        boolean b = isIsomorphic(root1.left,root2.right) && isIsomorphic(root1.right,root2.left);   // we need to check by doing opposite operations on both trees.
        return a||b;    // both a and b can't be true. only one can be true at any time.
    }

    public static void main(String args[]) 
    {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.left.right.left = new Node(7);
        root1.left.right.right = new Node(8);
   
        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);
        root2.right.left = new Node(4);
        root2.right.right = new Node(5);
        root2.left.right = new Node(6);
        root2.right.right.left = new Node(8);
        root2.right.right.right = new Node(7);
   
        if (isIsomorphic(root1,root2) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    
}
