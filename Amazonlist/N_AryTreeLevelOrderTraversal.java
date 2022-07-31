/**
 * 
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 * 
 * Logic is same as Level order traversal of binary tree.
 * 
 * Algorithm:
 * -----------
 * 
 * 1. push root to queue.
 * 2. Loop if queue is not empty
 *   2.1 take the current size of queue
 *   2.2 loop till the size becomes '0'.
 *      2.2.1 pop the front element from queue.
 *      2.2.2 add the  popped element to the current-level list of nodes
 *      2.2.3 check if the children list of popped node is not empty then add all of the children to queue.
 *  2.3 add the current-level to resultant list.
 * 3. return the list
 * 
 * 
 * 
 * 
 */

package Amazonlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class N_AryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        
            
        List<List<Integer>> res = new ArrayList<>();
        
        if(root==null)
                return res;
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            // take current size of queue and loop till size becomes '0'. We do this bcz all elements  of one-level will be in queue at one-point of time.
            // So we take the size of current level.
            int currSize = q.size();
            
            // this is for keeping track of current level nodes.
            List<Integer> currLevel = new ArrayList<>();
            
            // loop till current level size becomes '0'
            while(currSize-- > 0)
            {
                Node curr = q.poll();   // pop the node at front of queue
                currLevel.add(curr.val);    // add the popped node to curr level.

                // check if the popped node have children then push to queue.
                if(curr.children !=null )
                {
                    // pushing the children of popped node to queue
                    for(Node child : curr.children)
                    {
                        q.add(child);
                    }
                }
            }
            // adding one-level nodes which are added to list above to result list.
            res.add(currLevel);
        }
        
        return res;
        
    }
    
}
