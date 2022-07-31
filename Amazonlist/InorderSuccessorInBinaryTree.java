/**
 * 
 * https://leetcode.com/problems/inorder-successor-in-bst/solution/         --> this also contains soln for inorder successor in binary tree
 * 
 * 
 * Intuition

As mentioned in the overview section of this article, we will first discuss the approach that applies to any binary tree and is not specifically for a binary search tree. This is not the most efficient approach out there considering it doesn't incorporate the search properties associated with the structure of a binary search tree. However, for the sake of completeness, we are including this approach in the official solution since the interviewer may ask you to find the inorder successor for a binary tree :)

We hinted briefly at the different cases for the inorder successor and we will look at these cases more concretely in this solution. The algorithm is based on handling these cases one by one. There are just two cases that we need to account for in this approach.

When the node has a right child --> case-1
==================================

The inorder successor in this case is the leftmost node in the tree rooted at the right child. Let's look at a couple of examples to depict this point.
Let's look at yet another example where there is a right child who doesn't have a left child. In this case, the right child itself will be the inorder successor of the designated node.


When the node doesn't have a right child --> case-2
=========================================
This is trickier to handle than the first case. In this case, one of the ancestors acts as the inorder successor. That ancestor can be the immediate parent, or, it can be one of the ancestors further up the tree.


In this case, we need to perform the inorder traversal on the tree and keep track of a previous node which is the predecessor to the current node we are processing. If at any point the predecessor previous is equal to the node given to us then the current node will be its inorder successor. Why? Because we are performing the inorder traversal on the tree to find the successor node via simulation.

Algorithm
===========

We define two class variables for this algorithm: previous and inorderSuccessorNode. The previous variable will only be used when handling the second case as previously explained and the inorderSuccessorNode will ultimately contain the result to be returned.

Inside the function inorderSuccessor, we first check which of the two cases we need to handle. For that, we simply check for the presence of a right child.

The right child exists

In this case, we assign the right child to a node called leftmost and we iterate until we reach a node (leftmost) which doesn't have a left child. We iteratively assign leftmost = leftmost.left and that's how we will get the leftmost node in the subtree.

The right child does not exist

As mentioned before, this case is trickier to handle. For this, we define another function called inorderCase2 and we will pass it a node and the node p.
We perform simple inorder traversal and hence, we first recurse on the left child of the node.
Then, when the recursion returns, we check if the class variable previous is equal to the node p. If that is the case, then it means p is the inorder predecessor of node or in other words, the node is the inorder successor of the node p and we return from that point onwards. We assign inorderSuccessorNode to node and return from this function.
Finally, we return the inorderSuccessorNode as our result.

 * 
 */

package Amazonlist;

public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

public  class InorderSuccessorInBinaryTree {

     TreeNode previous;
     TreeNode inorderSuccessorNode;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        // Case 1: We simply need to find the leftmost node in the subtree rooted at p.right.
        if (p.right != null) {
            
            TreeNode leftmost = p.right;
            
            while (leftmost.left != null) {
                leftmost = leftmost.left;
            }
            
            inorderSuccessorNode = leftmost;
        } else {
            
            // Case 2: We need to perform the standard inorder traversal and keep track of the previous node.
            inorderCase2(root, p);
        }
        
        return inorderSuccessorNode;
    }
    
    public void inorderCase2(TreeNode node, TreeNode p) {
        
        if (node == null) {
            return;
        }
        
        // Recurse on the left side
        inorderCase2(node.left, p);
        
        // Check if previous is the inorder predecessor of node
        if (previous == p && inorderSuccessorNode == null) {
                inorderSuccessorNode = node;        // if previous ==p then current nnode will be inordersuccessor of p.
            return;
        }
        
        // Keeping previous up-to-date for further recursions
        previous = node;
        
        // Recurse on the right side
        inorderCase2(node.right, p);
    }
    
}
