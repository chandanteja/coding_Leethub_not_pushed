/**
 * 
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * 
 */

public class MaxDepth_Height {

    public int maxDepth(TreeNode root) {
        
        if(root==null)
            return 0;
        int left_ht = maxDepth(root.left);
        int right_ht = maxDepth(root.right);
        
        return 1+Math.max(left_ht,right_ht);
        
    }
    
}
