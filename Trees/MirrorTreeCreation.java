/**
 * https://www.youtube.com/watch?v=lLdyqkdFNi0 --> watch this.
 * Here, instead of creating new mirror tree, we convert the given tree to mirror tree.
 * Logic is, We traverse given tree to the end, both in left and right childs.
 * We swap  the pointers of left and right childs.
 * We swap the left and right pointers in bottom up manner, so first we go to the end of each sub tree and swap pointer of right and left child.
 */

package Trees;
import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left= right=null;
    }
}

public class MirrorTreeCreation {

    public static void mirrorTree(Node node)
    {
        if(node == null)
            return;
        // we recurse in left and right subtrees by going to the end of each subtree, swap the left and right pointers from bottom up manner.
        mirrorTree(node.left);
        mirrorTree(node.right);
        Node temp;
        temp = node.left;
        node.left=node.right;
        node.right=temp;
        
    }

    public static void preOrderIterative(Node node)
    {
        if(node == null)
            return;
        Stack<Node> stk = new Stack<>();
        stk.add(node);
        while(!stk.isEmpty())
        {
            Node temp = stk.pop();
            System.out.print(temp.data + " ");
            if(temp.right!=null)
                stk.add(temp.right);
            if(temp.left!=null)
                stk.add(temp.left);
        }
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
 
       
        System.out.println("before mirror");
        preOrderIterative(tree);

        mirrorTree(tree);

        System.out.println("\nAfter mirror");
        preOrderIterative(tree);
           
 
        
    }
    
}
