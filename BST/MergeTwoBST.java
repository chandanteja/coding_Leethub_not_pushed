/**
 * https://www.geeksforgeeks.org/merge-two-balanced-binary-search-trees/
 * Logic is do inorder traversal of 2-bsts and store the result of traversal in 2 arrays.
 * using merge of mergesort merge these two arrays and create new Bst by creating the mid of new array as root. If we choose mid of the new array as root, this creates a balanced bst.
 * 
 * T.c = O(m+n)
 * S.C = O(m+n)
 *  m- size of bst1 and n- size of bst2
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

public class MergeTwoBST {

    // A Utility Method that stores inorder traversal of a tree
    public ArrayList<Integer> storeInorderUtil(Node node, ArrayList<Integer> list)
    {
        if(node == null)
            return list;
         
        //recur on the left child
        storeInorderUtil(node.left, list);
         
        // Adds data to the list
        list.add(node.data);
         
        //recur on the right child
        storeInorderUtil(node.right, list);
         
        return list;
    }

    
     // Method that merges two ArrayLists into one.
     ArrayList<Integer> merge(ArrayList<Integer>list1, ArrayList<Integer>list2, int m, int n)
     {
         // list3 will contain the merge of list1 and list2
         ArrayList<Integer> list3 = new ArrayList<>();
         int i=0;
         int j=0;
          
         //Traversing through both ArrayLists
         while( i<m && j<n)
         {
             // Smaller one goes into list3
             if(list1.get(i)<list2.get(j))
             {
                 list3.add(list1.get(i));
                 i++;
             }
             else
             {
                 list3.add(list2.get(j));
                 j++;
             }
         }
          
         // Adds the remaining elements of list1 into list3
         while(i<m)
         {
             list3.add(list1.get(i));
             i++;
         }
      
         // Adds the remaining elements of list2 into list3
         while(j<n)
         {
             list3.add(list2.get(j));
             j++;
         }
         return list3;
     }
      
     // Method that converts an ArrayList to a BST
     Node ALtoBST(ArrayList<Integer>list, int start, int end)
     {
         // Base case
         if(start > end)
             return null;
      
         // Get the middle element and make it root    
         int mid = (start+end)/2;
         Node node = new Node(list.get(mid));
  
         /* Recursively construct the left subtree and make it
         left child of root */
         node.left = ALtoBST(list, start, mid-1);
          
         /* Recursively construct the right subtree and make it
         right child of root */
         node.right = ALtoBST(list, mid+1, end);
      
     return node;
     }
     Node mergeTrees(Node node1, Node node2)
     {
         //Stores Inorder of tree1 to list1
         ArrayList<Integer> list1 =  new ArrayList<>();
         list1= storeInorderUtil(node1,list1);
          
         //Stores Inorder of tree2 to list2
         ArrayList<Integer> list2 =  new ArrayList<>();
         list2= storeInorderUtil(node1,list2);
          
         // Merges both list1 and list2 into list3
         ArrayList<Integer> list3 = merge(list1, list2, list1.size(), list2.size());
          
         //Eventually converts the merged list into resultant BST
         Node node = ALtoBST(list3, 0, list3.size()-1);
         return node;
     } 
    
}
