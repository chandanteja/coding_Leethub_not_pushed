/**
 * 
 * https://leetcode.com/problems/inorder-successor-in-bst/
 * 
 * Bruteforce   --> this works for binary tree also
 * ===========
 * This is not the most efficient approach out there considering it doesn't incorporate the search properties associated with the structure of a binary search tree.
 * 
 * Case-1
 * =======
 * 
 * When the node has a right child

The inorder successor in this case is the leftmost node in the tree rooted at the right child. Let's look at a couple of examples to depict this point.

Let's look at yet another example where there is a right child who doesn't have a left child. In this case, the right child itself will be the inorder successor of the designated node.

Case-2
=======
When the node doesn't have a right child

This is trickier to handle than the first case. In this case, one of the ancestors acts as the inorder successor. That ancestor can be the immediate parent, or, it can be one of the ancestors further up the tree.

In this case, we need to perform the inorder traversal on the tree and keep track of a previous node which is the predecessor to the current node we are processing. If at any point the predecessor previous is equal to the node given to us then the current node will be its inorder successor. Why? Because we are performing the inorder traversal on the tree to find the successor node via simulation.

Algorithm

We define two class variables for this algorithm: previous and inorderSuccessorNode. The previous variable will only be used when handling the second case as previously explained and the inorderSuccessorNode will ultimately contain the result to be returned.

Inside the function inorderSuccessor, we first check which of the two cases we need to handle. For that, we simply check for the presence of a right child.

The right child exists

In this case, we assign the right child to a node called leftmost and we iterate until we reach a node (leftmost) which doesn't have a left child. We iteratively assign leftmost = leftmost.left and that's how we will get the leftmost node in the subtree.

The right child does not exist

As mentioned before, this case is trickier to handle. For this, we define another function called inorderCase2 and we will pass it a node and the node p.
We perform simple inorder traversal and hence, we first recurse on the left child of the node.
Then, when the recursion returns, we check if the class variable previous is equal to the node p. If that is the case, then it means p is the inorder predecessor of node or in other words, the node is the inorder successor of the node p and we return from that point onwards. We assign inorderSuccessorNode to node and return from this function.
Finally, we return the inorderSuccessorNode as our result.

class Solution {
    
    private TreeNode previous;
    private TreeNode inorderSuccessorNode;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        // Case 1: We simply need to find the leftmost node in the subtree rooted at p.right.
        if (p.right != null) {
            
            TreeNode leftmost = p.right;
            
            while (leftmost.left != null) {
                leftmost = leftmost.left;
            }
            
            this.inorderSuccessorNode = leftmost;
        } else {
            
            // Case 2: We need to perform the standard inorder traversal and keep track of the previous node.
            this.inorderCase2(root, p);
        }
        
        return this.inorderSuccessorNode;
    }
    
    private void inorderCase2(TreeNode node, TreeNode p) {
        
        if (node == null) {
            return;
        }
        
        // Recurse on the left side
        this.inorderCase2(node.left, p);
        
        // Check if previous is the inorder predecessor of node
        if (this.previous == p && this.inorderSuccessorNode == null) {
            this.inorderSuccessorNode = node;
            return;
        }
        
        // Keeping previous up-to-date for further recursions
        this.previous = node;
        
        // Recurse on the right side
        this.inorderCase2(node.right, p);
    }
}

    T.C: O(n)
    S.C: O(n)



    Approach 2: Using BST properties
    ==================================
    Intuition

In the previous approach, we did not use any of the binary-search tree properties. However, the optimal solution for this problem comes from utilizing those properties and that's what we will explore in this solution. Specifically, we'll make use of the standard BST property where the left descendants have smaller values than the current node and right descendants have larger values than the current node. We don't need to handle any specific cases here and we can start with the root node directly and reach our inorder successor. Let's see the choices we have when comparing the value of the given node p to the current node in the tree.

 * 
 * 
 * By comparing the values of the node p and the current node in the tree during our traversal, we can discard half of the remaining nodes at each step, and thus, for a balanced binary search tree we can search for our inorder successor in logarithmic time rather than linear time. That's a huge improvement over the previous solution.

Algorithm
==========

We start our traversal with the root node and continue the traversal until our current node reaches a null value i.e. there are no more nodes left to process.

At each step we compare the value of node p with that of node.

If p.val >= node.val that implies we can safely discard the left subtree since all the nodes there including the current node have values less than p.

However, if p.val < node.val, that implies that the successor must lie in the left subtree and that the current node is a potential candidate for inorder successor. Thus, we update our local variable for keeping track of the successor, successor, to node.
 */

package Amazonlist;

public class InorderSuccessorInBST {

    // here we consider the search property of the tree.
    // if p.value is >= current node(root) value then it means the inorder successor of 'p' will lie on the right side of current node. We can safely discard the left subtree
    // if p.val < current node (root) value then it means inorder successor of 'p' will lie in left subtree, then current node can also be the potential candidate of 'p'.
    // so we store current node in 'successor' and proceed our search for inorder successor of 'p' in left sub tree.

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode successor = null;
        
        while(root!=null)
        {
            // if p.val is >= root.val it means the inorder successor will lie in right sub tree so we can discard left subtree.
            if(p.val >= root.val)   // p lies on right of root
            {
                root= root.right;
            }
            else    // else the inorder successor can lie in left subtree and current node can be a potential candidate. SO store it.
            {
                successor = root;
                root=root.left;
            }
            
        }
        return successor;
         
    }
    
}
