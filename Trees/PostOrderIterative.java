/**
 * Refer Srivasthava datastructures T.B
 *  Logic:
 *  1. We maintain 2 pointers, curr and visited. Visited ptr keeps track of wat all nodes have been visited and printed till now i.e it keeps track of last visited node only.
 *  2. We maintain visited ptr bcz in postorder, we print any node on visiting it 3rd time. So, if any node does not have left and right child, we can print it directly and pop an element and fall back.
 *  3. After printing the node, andbefore falling back, we assign visited ptr to the node. And move curr ptr to top element in stack.
 *  4. Visited helps in tracking that we are visiting a node 3rd time so, we can print the node now.
 */
package Trees;

import java.util.Stack;

class Node{

    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left=right = null;
    }
}

public class PostOrderIterative {

    public static void postOrder(Node root)
    {
        if(root == null)
            return;

            Node curr,visited;
            curr=root;
            visited=root;
            Stack<Node> stk = new Stack<>();
        while(true)
        {
            while(curr.left!=null)      // we keep on moving left by pushing node on to stack , till we encounter any node with left==null
            {
                stk.push(curr);
                curr=curr.left;
            }

            while(curr.right==null || (curr.right)==visited)    // if either right.child of curr node is null or curr.right is == to visited, means the right child is explored then
            {       // then we print curr node data and move the visited to current node (as curr node is visited.), and we pop top ele and proceed.
                System.out.print(curr.data+" ");
                visited=curr;
                if(stk.isEmpty())
                    return;
                curr=stk.pop();
            }
            stk.push(curr);
            curr = curr.right;      // we are moving right now as we are done moving left.
        }
    }
    public static void main(String[] args)
    {
        Node tree = new Node(1);
        
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.left.right = new Node(6);
        tree.left.right = new Node(5);
        tree.left.right.left = new Node(7);
 
       
        System.out.println( "\n Postorder traversal of binary tree is ");
        postOrder(tree);
 
        
    }
}


/*

https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/1026669/Simple-java-iterative-postorder-traversal-using-one-stack.   -> visit this for more crisp solution than the above one

 * 
 * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45556/Java-simple-and-clean --> uses linked list and does postorder traversal storage of values differently
 * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45621/Preorder-Inorder-and-Postorder-Traversal-Iterative-Java-Solution    --> does postorder traversal storage of values differently
 *
 *  public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(root == null) {
            return ans;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // We will have a pointer to the recently popped node
        TreeNode curr = root, prev = null;
        
        while(curr != null || !stack.isEmpty()) {
            // Keep on iterating towards the leftmost node
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // If there is no right child
            // or right child is the one that we recently visited
            // it means we have traversed all the nodes of stack.peek()
            
            if(stack.peek().right == null || stack.peek().right == prev) {
                // we will update the prev node
                prev = stack.pop();
                ans.add(prev.val);
            } else {
                // Otherwise we will visit the right child.
                curr = stack.peek().right;
            }
        }
        
        return ans;
    } 
 * 
 * 
 * 
 */