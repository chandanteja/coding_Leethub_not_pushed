import java.util.*;


 class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

public class PreOrderIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stk = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        if(root == null)
            return res;
        stk.push(root);
        
        while(!stk.isEmpty())
        {
            TreeNode curr = stk.pop();
            res.add(curr.val);
            
            if(curr.right != null)  stk.push(curr.right);
            if(curr.left != null)  stk.push(curr.left);
                
        }
        return res;
    }
    
}
