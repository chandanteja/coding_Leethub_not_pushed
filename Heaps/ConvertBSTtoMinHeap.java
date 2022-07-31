package Heaps;

import java.util.ArrayList;

/**
 *  https://www.geeksforgeeks.org/convert-bst-min-heap/
 *  https://www.youtube.com/results?search_query=convert+bst+to+minheap
 *  https://www.youtube.com/watch?v=X0ILJLTqvBA&t=479s
 *  https://www.geeksforgeeks.org/convert-bst-to-max-heap/
 *  
 *  Approach: To convert BST to minheap, follow below approach
 *      1. first traverse the tree in Inorder fashion and we will get the elements in sorted order as it is BST.Store them in array.
 *      2. Now traverse the tree in preorder (for Minheap)  fashion and using the array we got in step-1, replace all the elements in tree,
 *         with all elements in array in same sequence. use index variable to keep track of indices of elements to be replaced.
 *      3. For Max-heap instead of pre-order, we do post-order traversal and replace all elements.
 */

class NodeBST{
 
    int data;
    NodeBST left,right;
     
    // Constructor
    NodeBST(){
        this.data = 0;
        this.left = this.right = null;
    }
    NodeBST(int data)
    {
        this.data = data;
        this.left = this.right = null;

    }
}


public class ConvertBSTtoMinHeap {

    public static void inOrderTraversal(NodeBST root,ArrayList<Integer> arr)
    {   
        if(root==null)
            return;
        
        inOrderTraversal(root.left, arr);
        arr.add(root.data);     // store data while doing inorder traversal, as this will be used to create min heap while doing pre-order traversal
        // max-heap can be created while doing post-order traversal.
        inOrderTraversal(root.right, arr);
    }
    
    static  int index=0;        // this index is used to traverse array to acess element which is used to replace node element during pre-order/postorder traversal

    public static void preOrderTraversalToConvertToHeap(NodeBST root, ArrayList<Integer> arr)
    {   
        // we do pre-order traversal of tree and using the array we got thru inorder traversal, we replace the elements in nodes.
        if(root==null)
            return ;
        
        root.data = arr.get(index);
        index++;
        preOrderTraversalToConvertToHeap(root.left, arr);
        preOrderTraversalToConvertToHeap(root.right, arr);
    
    }

    public static NodeBST bstToHeap(NodeBST root)
    {
        if(root ==null)
            return root;
       
        ArrayList<Integer> arr = new ArrayList<>();
        inOrderTraversal(root, arr);        // here we convert bst to array
        // Now do pre-order traversal for min-heap or post-order traversal for max-heap
        preOrderTraversalToConvertToHeap(root, arr);     // here we convert array to heap
    
        return root;
    }

    private static void printPreOrder(NodeBST root)
    {
        if(root==null)
            return ;
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args)
    {
        
        // BST formation
        NodeBST root = new NodeBST(4);
        root.left = new NodeBST(2);
        root.right = new NodeBST(6);
        root.left.left = new NodeBST(1);
        root.left.right = new NodeBST(3);
        root.right.left = new NodeBST(5);
        root.right.right = new NodeBST(7);
         
        System.out.print("Preorder Traversal Before Conversion :" +"\n");
        printPreOrder(root);
        NodeBST temp = bstToHeap(root);
         
        System.out.print("\nPreorder Traversal After Conversion :" +"\n");
        printPreOrder(temp);
      
        }

    
}
