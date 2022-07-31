/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 * 
 * Naive
 * ==========
 * 
 * Algorithm
==============
Here is the algorithm:

Construct inorder traversal of the tree. It should be an almost sorted list where only two elements are swapped.

Identify two swapped elements x and y in an almost sorted array in linear time.

Traverse the tree again. Change value x to y and value y to x.
 * 
 * 
 *  public void inorder(TreeNode root, List<Integer> nums) {
    if (root == null) return;
    inorder(root.left, nums);
    nums.add(root.val);
    inorder(root.right, nums);
  }

  // To identify two swapped elements in a sorted array is a classical problem that could be solved in linear time. Here is a solution code
  public int[] findTwoSwapped(List<Integer> nums) {
    int n = nums.size();
    int x = -1, y = -1;
    for(int i = 0; i < n - 1; ++i) {
      if (nums.get(i + 1) < nums.get(i)) {
        y = nums.get(i + 1);
        // first swap occurence
        if (x == -1) x = nums.get(i);
        // second swap occurence
        else break;
      }
    }
    return new int[]{x, y};
  }

  public void recover(TreeNode r, int count, int x, int y) {
    if (r != null) {
      if (r.val == x || r.val == y) {
        r.val = r.val == x ? y : x;
        if (--count == 0) return;
      }
      recover(r.left, count, x, y);
      recover(r.right, count, x, y);
    }
  }

  public void recoverTree(TreeNode root) {
    List<Integer> nums = new ArrayList();
    inorder(root, nums);
    int[] swapped = findTwoSwapped(nums);
    recover(root, 2, swapped[0], swapped[1]);
  }
 * 
 * ==================================================
 * 
 * Recursive Inorder Traversal
 * ==============================
Iterative approach 2 could be converted into recursive one.

Recursive inorder traversal is extremely simple: follow Left->Node->Right direction, i.e. do the recursive call for the left child, then do all the business with the node (= if the node is the swapped one or not), and then do the recursive call for the right child.

On the following figure the nodes are numerated in the order you visit them, please follow 1-2-3-4-5 to compare different DFS strategies.


Complexity Analysis

Time complexity: O(N) in the worst case when one of the swapped nodes is a rightmost leaf.

Space complexity : up to O(N) to keep the stack in the worst case when the tree is completely lean.
 * 
 */


 /*

  There is one more method using 3-pointers in GFG/BST section of coding problems. Refer BST section in coding problems --> recover BST.


 */

package Amazonlist;

public class RecoverBST {

    TreeNode first=null,last=null,prev=null;
    // first points to first swapped node
    // last points to last swapped node at the end of complete traversal of tree.
    // swap the values of first and last
    
    
    public void recoverTree(TreeNode root) {
        
        findSwappedNodes(root);
        swap(first,last);
       
    }
    
    void findSwappedNodes(TreeNode root)
    {
        if(root==null)
                return;
        
        
        findSwappedNodes(root.left);
        if(prev!=null && root.val<prev.val)
        {
            last = root;
            
            if(first==null)
                    first=prev;
            
        }
        
        prev=root;
        
        findSwappedNodes(root.right);
        
    }
    
    void swap(TreeNode x,TreeNode y)
    {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
    
}
