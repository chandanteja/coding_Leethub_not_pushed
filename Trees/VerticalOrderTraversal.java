/**
 * 
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * 
 * 
 * column-wise order
-------------------------
If we look at a binary tree horizontally, each node can be aligned to a specific column, based on its relative offset to the root node of the tree.

Let us assume that the root node has a column index of 0, then its left child node would have a column index of -1 and its right child node would have a column index of +1, and so on.

row-wise order
-----------------
Now if we put the nodes into a vertical dimension, each node would be assigned to a specific row, based on its level (i.e. the vertical distance to the root node).

Let us assume that the root node has a row index of 0, then both its child nodes would have the row index of 1.


the nodes should be ordered by column first, and further the nodes on the same column should be ordered vertically based on their row indices.



Approach 1: Breadth-First Search (BFS)
=========================================
Intuition

With the formulation of the problem in the overview section, one of the most intuitive solutions to tackle the problem would be applying the BFS traversal, where the nodes would be visited level by level.

With the BFS traversal, we naturally can guarantee the vertical order of the visits, i.e. the nodes at higher levels (large row values) would get visited later than the ones at lower levels.

However, we are still missing the horizontal order ( the column order). To ensure this order, we need to do some additional processing during the BFS traversal.

The idea is that we keep a hash table (let's denote it as columnTable<key, value>), where we keep the node values grouped by the column index.

The key in the hash table would be the column index, and the corresponding value would be a list which contains the values of all the nodes that share the same column index.

In addition, the values in the corresponding list should be ordered by their row indices, which would be guaranteed by the BFS traversal as we mentioned before.

Algorithm

We elaborate on the steps to implement the above idea.

First, we create a hash table named columnTable to keep track of the results.

As to the BFS traversal, a common code pattern would be to use a queue data structure to keep track of the order we need to visit nodes. We initialize the queue by putting the root node along with its column index value (0).

We then run the BFS traversal with a loop consuming the elements from the queue.

At each iteration within the BFS, we pop out an element from the queue. The element consists of a node and its corresponding column index. If the node is not empty, we then populate the columnTable with the value of the node. Subsequently, we then put its child nodes along with their respective column indices (i.e. column-1 and column+1) into the queue.

At the end of the BFS traversal, we obtain a hash table that contains the desired node values grouped by their column indices. For each group of values, they are further ordered by their row indices.

We then sort the hash table by its keys, i.e. column index in ascending order. And finally we return the results column by column.


Time Complexity: O(NlogN) 
Space Complexity: O(N)


Approach 2: BFS without Sorting
================================
Intuition

In the previous approach, it is a pity that the sorting of results overshadows the main part of the algorithm which is the BFS traversal. One might wonder if we have a way to eliminate the need for sorting. And the answer is yes.

The key insight is that we only need to know the range of the column index (i.e. [min_column, max_column]). Then we can simply iterate through this range to generate the outputs without the need for sorting.

The above insight would work under the condition that there won't be any missing column index in the given range. And the condition always holds, since there won't be any broken branch in a binary tree.

Algorithm

To implement this optimization, it suffices to make some small modifications to our previous BFS approach.

During the BFS traversal, we could obtain the range of the column indices, i.e. with the variable of min_column and max_column.

At the end of the BFS traversal, we would then walk through the column range [min_column, max_column] and retrieve the results accordingly.

Time Complexity: O(N)
Space Complexity: O(N)
 * 
 */

package Trees;

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

class Pair
{
    TreeNode node;
    int column;
    
    Pair(TreeNode node, int column)
    {
        this.node = node;
        this.column = column;
    }
}

/*
    Logic is when we traverse any tree as level ordr, we visit all nodes as per levels, so least level will be visited first and highest level at last.

    We need to print lowest level nodes first then highest next. If 2 or more nodes are in same level, then we need to print them from left to right.

    To print from left to right, we assume indexing for nodes from left to right. root index will be '0' and all nodes on left of root will have index -1,-2 ... and all on right will have 1,2,...
    This node level indexing is recursively applied for root and all its children with same analogy as above.

    We take a hashmap of (integer, arraylist) and we group all elements having same vertical index in one array list with key as the vertical index of hashmap.

    for getting elements level by level, we use BFS style traversal (using queue)
    for getting elements from left to right, we use Vertical indexing.

    Along with  these, we use two variables minCol and maxCOl, to keep track of minimum vertical index and maximum vertical index.
    So that we ccan traverse b/w these vertical indices and and print the ele.
    If we dont use these 2-variables, we need to use Sorting for sorting the keys(vertical indices) for printing from left to right


*/
public class VerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root==null)
                return res;
        
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root,0));
        
        int minCol=0,maxCol=0;
        
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            
            TreeNode node = p.node;
            int col = p.column;
            
            if(node!=null)
            {
                if(!hm.containsKey(col))
                {
                    hm.put(col,new ArrayList<Integer>());
                }
                hm.get(col).add(node.val);
                
                minCol = Math.min(col,minCol);
                maxCol = Math.max(col,maxCol);
                
                q.add(new Pair(node.left,col-1));
                q.add(new Pair(node.right,col+1));
            }
        }
        
        for(int i=minCol;i<=maxCol;i++)
        {
            res.add(hm.get(i));
        }
        
        return res;
    }
    
}
