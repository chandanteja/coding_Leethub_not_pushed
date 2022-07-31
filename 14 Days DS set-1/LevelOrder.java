import java.util.*;

/**
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 */

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root==null)
            return res;
        
        Queue<TreeNode>  q = new LinkedList<>();
        
        q.add(root);
        TreeNode curr = null;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            
            while(size>0)
            {
                size--;
                curr=q.poll();
                temp.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
                
                    
            }
            res.add(temp);    
            
        }
        return res;
        
    }
    
}
