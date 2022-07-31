/**
 * 
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Logic is if tree is bst then all values in left of root shuld be < root value and all values on right of root shuld be greater than right of root.
 * 
 * when we start our search from root, we will we  start with assumption that root will lie in b/w (-INFINITY, +INFINITY),
 * When we move to left of root, our search space narrows down to (-INF, root.value) and when move to right, our search narrows to (root.val,+INF).
 * NOTE: above all are open-intervals not closed. So the node values shuld not be even equal to like INFINITY, root.val .
 * 
 */

package Amazonlist;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        
        if(root==null || (root.left==null && root.right==null) )
                return true;
        
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
        
    }
    
    boolean isValid(TreeNode root, long min,long max)
    {
        if(root==null)
                return true;
        if( !(root.val > min && root.val< max))
            return false;
        
        return (isValid(root.left,min,root.val)&& isValid(root.right,root.val,max));
        
            
    }
    
}

/*
Another method:


Compute inorder traversal list inorder.

Check if each element in inorder is smaller than the next one. If not then tree is not BST  
Do we need to keep the whole inorder traversal list?

Actually, no. The last added inorder element is enough to ensure at each step that the tree is BST (or not). 
Logic is if tree is BST then inorder traversal gives sorted list. We exploit this fact and check if previous ele is smaller than curr ele or not. If not smaller then tree is not bst


class Solution {
    // We use Integer instead of int as it supports a null value.
    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }
}


*/
