
/**
 * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/ --> see inorder style of verification.
 * 
 * https://leetcode.com/problems/validate-binary-search-tree/discuss/1228054/super-easy-to-understand-solution(0ms-100faster)   --> this is using MIN and MAX
 * https://www.youtube.com/watch?v=MILxfAbIhrE&t=214s --> youtube video for min and max method.
 * 
 * T.C = O(n)
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

public class CheckGivenTreeIsBST {
    static Node prev = null; 
    // This is used in inorderstyle()  verification of BST. Inorder traversal of BST gives, sorted order, so, we need to,
    // do inorder traversal and store the elements in an array and then check if all elements are in sorted order or not. 
    // If not in sorted order then not BST. But this way consumes Space complexity of O(n) , if we look carefully, we need to check current element,
    // with only previous element and check previous element shuld be lessthan current element.

    public static boolean isBSTInorderStyle(Node root)
    {
        if(root!=null)
        {
            if(isBSTInorderStyle(root.left)==false) // if the left subtree returns false, the current call also needs to return false as somehwere in left subtree, BST ppty is failed.
                return false;

            if(prev!=null && prev.data >= root.data)
                return false;   // prev ptr points to previous data, in sorted order  of elements. So if prev data is > current data, BST ppty is invalid.

            prev=root;
            return isBSTInorderStyle(root.right);
        }
        return true;    // if root==null the tree is always BST, base case;
    }

    // Below is another way (2nd method) of verifying given tree is BST or not. In bst all elements lies between minimum and maximum elements of the tree.
    // we take min and max as -INFINITY and +INFINITY and we modify min and max elements accordingly,after visiting every node.
    
    public static boolean isValidBST(Node root) {
        return isValid(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }

    private static boolean isValid(Node root , long min ,long max){
        if(root==null)return true;      // if root==null the tree is always BST, base case;

        if(root.data<=min || root.data>=max)return false;   // node's data shuld lie b/w min and max. But if data is <= min or >=max then bst ppty is failed
        
        boolean left = isValid(root.left , min , root.data); // for node on left of current node, current node data will be max value,
        if(left==false)return false;
        boolean right = isValid(root.right , root.data , max);  // for node on right of current node, current node data will be min value,
        if(right==false)return false;
        
        return true;
    }
}
