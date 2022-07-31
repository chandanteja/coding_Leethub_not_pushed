/**
 * This is same as Spiral traversal of tree.
 * 
 * 
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/      --> qns
 * 
 * Watch GFG course video for clear understanding.
 * 
 * 
 * We take 2-stacks, we push alternate levels into different stacks.
 * Let 2 stacks be s1,s2.
 * 
 * 1. Push root on to s1.
 * 2. While any of the 2 stacks is not empty loop
 *      1. while s1 is not empty
 *          a)Take out the node and print it.
 *          b)push children of popped node into stack s2 i.e push left child first then right child.
 *      2. while s2 is not emppty,
 *          a)take out node and print it.
 *          b)push children of taken out node into s1 in reverse order i.e right child first then left child
 * 
 */


package Amazonlist;

import java.util.*;

class TreeNode 
  {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right)
       {
          this.val = val;
          this.left = left;
          this.right = right;
       }
  }
 

public class ZigZagTreeTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root==null)
                return res;
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);  // first push root element so  tht we can get started.
        
        while(!s1.isEmpty() || !s2.isEmpty())   // loop till both stacks are empty.
        {
    //Note we maintain two array lists one for each level, i.e all even numbered levels elements will be added to one array list and all odd levels elements will be added to another array list.
           List<Integer> ar = new ArrayList<>();
            
            while(!s1.isEmpty())    // loop till first stack is empty
            {
                TreeNode temp = s1.pop();

                // for an element popped in s1, we push popped ele's children to s2 as left,right order
                if(temp.left!=null)
                    s2.push(temp.left);
                if(temp.right!=null)
                    s2.push(temp.right);
                
                    //add the popped ele value to current level array list
                ar.add(temp.val);
                
            }
            
            if(!ar.isEmpty())   // if arraylist is empty we need not add it to res.
                 res.add(ar);
            
    //Note we maintain two array lists one for each level, i.e all even numbered levels elements will be added to one array list and all odd levels elements will be added to another array list.
            List<Integer> ar1 = new ArrayList<>();
            
            while(!s2.isEmpty())        // loop till 2nd stack is empty.
            {
                TreeNode temp = s2.pop();
                
                // for an element popped in s2, we push popped ele's children to s1 as right,left order
                if(temp.right!=null)
                    s1.push(temp.right);
                if(temp.left!=null)
                    s1.push(temp.left);
                
                    //add the popped ele value to current level array list
                ar1.add(temp.val);
                
            }
            
            if(!ar1.isEmpty())   // if arraylist is empty we need not add it to res.
                res.add(ar1);
        }
        return res;
        
    }
    
}
