/**
 * 
 * https://leetcode.com/problems/symmetric-tree/
 * 
 * https://leetcode.com/problems/symmetric-tree/solution/
 * 
 * 
 */

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        
        if(root==null)
            return true;
        
        return isSymmetricCheck(root.left,root.right);
        
    }
    
    public boolean isSymmetricCheck(TreeNode root1, TreeNode root2)
    {
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return isSymmetricCheck(root1.left,root2.right)&&isSymmetricCheck(root1.right,root2.left);
    }
    
}
