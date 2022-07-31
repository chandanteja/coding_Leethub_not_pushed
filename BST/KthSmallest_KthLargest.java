/**
 * https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/
 */

package BST;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data=data;
        left=right=null;
    }
}

public class KthSmallest_KthLargest {
    
    static int kthLargestEle=-1;
    static int k;
    static  int kthSmallestEle =-1;

  public static void kthLargestUtil(Node root)
  {
      // for finding largest ele, we do reverse inorder traversal i.e right-root-left as the 1st largest element will be right most element and we shuld count 'k' from there onwards.
      if(root==null || k<0)
        {
            return ;
        }
        kthLargestUtil(root.right); // 1st largest element will be right most element so, we will go right first. and keep counting k, from there.
        k--;
        if(k==0)
        {
            kthLargestEle= root.data;
            return ;
        }
        kthLargestUtil(root.left);
    
  }

public static void kthSmallestUtil(Node root)
{
    // for finding smallest ele, we do inorder traversal i.e left-root-right as the 1st smallest element will be left most element and we shuld count 'k' from there onwards.
    if(root==null || k<0)
            return;
            kthSmallestUtil(root.left); // 1st smallest element will be left most element so, we will go left first. and keep counting k, from there.
       --k;
        if(k==0)
        {
            kthSmallestEle= root.data;
            return;
        }
        kthSmallestUtil(root.right);     
}

public static void kthLargestSmallest(Node root,int K)
{
    k=K;
    kthSmallestUtil(root);
    k=K;
    kthLargestUtil(root);
}
public static void main(String[] args)
    {
       Node root = new Node(50);
       root.left = new Node(30);
       root.left.left = new Node(20);
       root.left.right = new Node(40);
       root.right = new Node(70);
       root.right.left = new Node(60);
       root.right.right = new Node(80);
     
    int k=5;

    kthLargestSmallest(root, k);
    System.out.println("Kth-largest is: "+kthLargestEle);
    System.out.println("Kth-smallest is: "+kthSmallestEle);

    }
  
}
