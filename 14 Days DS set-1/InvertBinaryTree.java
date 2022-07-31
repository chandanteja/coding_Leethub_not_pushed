/**
 * 
 * https://leetcode.com/problems/invert-binary-tree/
 * 
 */

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        
        if(root==null)
            return root;
        else if(root.left==null && root.right==null)
                return root;
        else
        {
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right=temp;
            return root;
        }
        
    }
    
}
