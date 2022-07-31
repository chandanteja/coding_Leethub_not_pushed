/**
 * 
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * 
 */

public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root==null)
        {
            TreeNode temp = new TreeNode(val);
            temp.left=null;
            temp.right=null;
            root=temp;
            return root;
        }
        else if(root.val>val)
            root.left= insertIntoBST(root.left,val);
        else
            root.right= insertIntoBST(root.right,val);
            
        return root;
    }
    
}
