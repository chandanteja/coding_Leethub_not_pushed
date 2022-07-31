import java.util.*;

public class InorderIteravtive {

    public List<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        if(root==null)
                return res;
        
        Stack<TreeNode> s = new Stack<>();
        
        TreeNode curr = root;
        
        while(curr != null || !s.isEmpty())
        {
            while(curr!=null)
            {
                s.push(curr);
                curr = curr.left;
            }
            
            curr = s.pop();
            res.add(curr.val);
            curr=curr.right;
        }
        
        return res;
        
    }
    
}
