/**
 * https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/
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



public class ConvertBSTToBBST {
    
    ArrayList<Integer> bst = new ArrayList<>();

    void inorder(Node root)
    {
        // Store nodes in Inorder (which is sorted order for BST)
        if(root==null)
            return ;
        inorder(root.left);
        bst.add(root.data);
        inorder(root.right);
    }

    Node convertBstToBBST(int start,int end)
    {
        if(start>end)
            return null;

        /* Get the middle element and make it root */
        int mid = start + (end-start)/2;
        Node root = new Node(bst.get(mid));

        /* Using index in Inorder traversal array, construct
           left and right subtress */
        root.left = convertBstToBBST(start,mid-1);
        root.right = convertBstToBBST(mid+1,end);
        return root;
        
    }
    Node buildBalancedTree(Node root) 
    {
        bst.clear();
       inorder(root);
      return  convertBstToBBST(0,bst.size()-1);
      
    }

    
}
