
/**
 * Watch GFG complete interview prep course video on this topic.
 * We do in-place conversion of Binary tree to DLL. 
 * The order to be followed while doing conversion is Inorder traversal order.
 */
package Trees;

import java.util.*;

class Node{
    int data;
    Node left,right;

    Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

public class ConvertBinartTreeToDLL {
    // here at any point of time, root points to current node we are working with.
    // prevNode points to node which is previously converted to DLL i.e last node which is converted to DLL.  

    static Node prevNode = null;
    public static Node convertToDLL(Node root)
    {
        if(root == null)
            return null;
        Node head = convertToDLL(root.left);
        if(prevNode == null)  
        { head=root;}   // as this is the first time, we are setting head as root bcz this is the first node in inorder traversal after reaaching leftmost end.,so it will be head of DLL.
        else{
            // if prevNode is not null it means there are some nodes which are already converted to DLL. So, we set the next and previous ptrs of current node.
            // here 'right' ptr of a tree node acts as next ptr of DLL node. 'left' acts as the previous ptr of DLL node.
            root.left=prevNode; 
            prevNode.right=root;
        }
        prevNode = root;
        convertToDLL(root.right);
        return head;    // returning the head of DLL created.
    }

public static void inorderIter(Node root)
{
    if(root == null)
        return;
    Stack<Node> stk = new Stack<>();
    Node curr = root;

    while(curr!=null || !stk.isEmpty())
    {
        while(curr!=null)
        {
            stk.push(curr);
            curr=curr.left;
        }
        curr = stk.pop();
        System.out.print(" "+ curr.data);
        curr=curr.right;
    }
}

static void printlist(Node root)
    {
        while (root != null)
        {
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

public static void main(String[] args)
    {
        // Let us create the tree shown in above diagram
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
 
        System.out.println("Inorder Tree Traversal");
        inorderIter(root);
 
        Node head = convertToDLL(root);
 
        System.out.println("\nDLL Traversal");
        printlist(head);
    }
    


}
