/**
 * https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
 * https://www.youtube.com/watch?v=9sw8RRsBw6s
 */

package BST;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left=right=null;
    }
}

public class CreateBSTFromPreOrder {
   
    static int index=0;

    // A recursive function to construct BST from preorder[].
    // indx is used to keep track of index in preorder[].
    static Node constructBST(int preorder[],int size,int key,int indx, int min,int max)
    {
        if(indx>=size) // if index crosses size, then we reached end of array.
            return null;
        Node root=null;

        // If current element of pre[] is in range, then
        // only it is part of current subtree
        if(key>min && key<max)
        {
            if(indx<size)
            {
                // Allocate memory for root of this
            // subtree and increment index
                root=new Node(key);
                index=index+1;

                if(index<size)
                {
                    // Construct the subtree under root
                // All nodes which are in range {min .. key}
                // will go in left subtree, and first such
                // node will be root of left subtree.
                    root.left  = constructBST(preorder, size, preorder[index], index, min, key);
                }

                if(index<size)
                {
                    // All nodes which are in range {key..max}
                // will go in right subtree, and first such
                // node will be root of right subtree.
                    root.right  = constructBST(preorder, size, preorder[index], index, key, max);
                }
            }

        }
        return root;
    }
    public static Node bstFromPreorder(int[] preorder) {
        
        index=0;
        return constructBST(preorder,preorder.length,preorder[0],index,Integer.MIN_VALUE,Integer.MAX_VALUE);
        
    }

    

}
