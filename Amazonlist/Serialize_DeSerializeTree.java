/**
 * 
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/1308929/Java-DFS-compact-solution
 * 
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 
 * Also refer GFG self paced DSA course --> trees
 * 
 * 
 */

package Amazonlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Serialize_DeSerializeTree {

    // every node after converting to string is delimited with ",".
    public String serialize(TreeNode root) {
        
        // do preorder traversal and store as string de-limited with ','.
        if(root==null)
        {
           return "n,"; // if node is null we store as "n,"
        }
        
        // store in string form.
        // pre order traversal
        return root.val + "," + serialize(root.left) + serialize(root.right);
        
    }

    // Decodes your encoded data to tree.
    
    public TreeNode deserialize(String data) {
		return deserialization(new LinkedList<>(Arrays.asList(data.split(","))));   // here we split the given i/p string based on ','.
        // when we split a string , then we get array of strings i.e String[], 
        // using Arrays.asList(array[]), we convert string array to LinkedList<String> type collection
	}
	
	private TreeNode deserialization(Queue<String> strs) {

		String curStr = strs.poll();    // pop the front element
        // if popped ele is "n" ==> it is null value , so we return null.

		if ("n".equals(curStr)) return null;

        // if popped value is not "n" --> we create a node with the popped value and recur on this nodes left and right.
		TreeNode node = new TreeNode(Integer.valueOf(curStr));
        // recur on the above created nodes left and right.
		node.left = deserialization(strs);
		node.right = deserialization(strs);
		return node;
	}
    
}
