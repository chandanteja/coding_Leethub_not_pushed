package BST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left=right=null;
    }
}

public class ConvertBT_To_BST {
    
    static ArrayList<Integer> inorderArray = new ArrayList<>();
   
    static void inorderBT(Node root)
   {
       if(root==null)
        return;
        inorderBT(root.left);
        inorderArray.add(root.data);
        inorderBT(root.right);
        
   }
   
   static int index=0;
   static void convertToBST(Node root)
   {
       if(root==null)
        return;
        convertToBST(root.left);
            
            root.data = inorderArray.get(index);
            index++;
        
        convertToBST(root.right);
   }
   
   static Node binaryTreeToBST(Node root)
    {
        if(root==null)
            return root;
        if(root.left==null && root.right==null)
            return root;
        
       inorderBT(root);
       Collections.sort(inorderArray);
       convertToBST(root);
       return root;
       
    }

    static void inorder(Node root)
    {
        if(root==null)
            return ;
        Stack<Node> stk = new Stack<>();
       
        Node curr= root;
        while(curr!=null || !stk.isEmpty())
        {
             while(curr!=null)
             {
                 stk.push(curr);
                 curr=curr.left;
             }
             curr=stk.pop();
             System.out.print(" "+ curr.data);
             curr=curr.right;
        }
        
    }

    public static void main(String args[])
    {
        Node root = null;
 
        
        root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);
 
        inorder(root);
        binaryTreeToBST(root);
 
        System.out.println("\n Following is Inorder Traversal of the converted BST: ");
        inorder(root);
 
    }
}
