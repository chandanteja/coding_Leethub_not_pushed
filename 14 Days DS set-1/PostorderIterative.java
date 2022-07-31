import java.util.*;

/**
 * 
 * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/1026669/Simple-java-iterative-postorder-traversal-using-one-stack.  --> visit this for soln
 * 
 * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45556/Java-simple-and-clean --> uses linked list and does postorder traversal storage of values differently
 * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45621/Preorder-Inorder-and-Postorder-Traversal-Iterative-Java-Solution    --> does postorder traversal storage of values differently
 * 
 * 
 */


 // here visited acts as prev node
public class PostorderIterative {

    public List<Integer> postorderTraversal(TreeNode root) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        if(root == null)
            return res;
        
        Stack<TreeNode> s = new Stack<>();
        // We will have a pointer to the recently popped node
        TreeNode curr=root, visited=null;       // visited acts as prev node
        
        while(curr !=null || !s.isEmpty() )
        {
            // Keep on iterating towards the leftmost node
            while(curr!=null)
            {
                s.push(curr);
                curr=curr.left;
                
            }

            // If there is no right child
            // or right child is the one that we recently visited
            // it means we have traversed all the nodes of stack.peek()
            if(s.peek().right == null || s.peek().right==visited)
            {
                // we will update the visited node
                visited = s.pop();
                res.add(visited.val);
                
            }
            else
            // Otherwise we will visit the right child.
                curr = s.peek().right;
        }
        return res;
        
    }
    
}
