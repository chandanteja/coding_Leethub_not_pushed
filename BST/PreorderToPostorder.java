/**
 * 
 * 
 * https://www.geeksforgeeks.org/find-postorder-traversal-of-bst-from-preorder-traversal/
 * 
 * Check approach-2 in the above link. It is simpler and easier too. Also this version has S.C= O(1).
 * 
 * Time Complexity: O(N), where N is the number of nodes. 
    Auxiliary Space: O(N) (Function call stack size)
 */

package BST;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left= right = null;
    }
}
// Approach-2 given in above link is much easier and better and S.C= O(1)

public class PreorderToPostorder {
    
    static int index=0;
    // Function to find postorder traversal from
    // preorder traversal.  
    static void findPostOrder(int pre[],int size,int key,int indx,int min,int max)
    {

        // If entire preorder array is traversed then
        // return as no more element is left to be
        // added to post order array.
        if(indx>=size)
            return;

            // If array element does not lie in range specified,
        // then it is not part of current subtree.
        if(key<=min || key>=max)
        {
            return;
        }

        
        // Increment preIndex to find left and right subtrees,
        // and pass this updated value to recursive calls.
        index++;
        if(index<size)
        {
             // All elements with value between minval and val
        // lie in left subtree.
            findPostOrder(pre,size,pre[index],index,min,key);
        }
        if(index<size)
        {
            // All elements with value between val and maxval
        // lie in right subtree.
            findPostOrder(pre,size,pre[index],index,key,max);
        }
        System.out.print(key+ " ");

    }

    static void findPostOrder(int pre[], int n)
    {
 
       // To store index of element to be
        // traversed next in preorder array.
        // This is passed by reference to
        // utility function.
        index=0;
 
        findPostOrder(pre, n, pre[0],index,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }



    // 2nd approach---> solution. See the above link for logic.

    // public void getPostOrderBST(int pre[])
    // {
    //     int pivotPoint = 0;
       
    //     // run loop from 1 to length of pre
    //     for (int i = 1; i < pre.length; i++)
    //     {
    //         if (pre[0] <= pre[i])
    //         {
    //             pivotPoint = i;
    //             break;
    //         }
    //     }
       
    //     // print from pivot length -1 to zero
    //     for (int i = pivotPoint - 1; i > 0; i--)
    //     {
    //         System.out.print(pre[i] + " ");
    //     }
       
    //     // print from end to pivot length
    //     for (int i = pre.length - 1; i >= pivotPoint; i--)
    //     {
    //         System.out.print(pre[i] + " ");
    //     }
    //     System.out.print(pre[0]);
    // }


    public static void main(String args[])
    {
        int pre[] = { 40, 30, 35, 80, 100 };
 
        int n = pre.length;
 
        // Calling function
        findPostOrder(pre, n);
    }

    
}
