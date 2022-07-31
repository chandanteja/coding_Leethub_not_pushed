
/**
 * https://www.youtube.com/watch?v=ZdIrKO7gqok&t=571s
 * We need to use dp (memoization).
 */
package Trees;

import java.util.HashMap;
import java.util.Map;

class Node {

    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class MaxSumOfNon_AdjacentNodes {
    static Map<Node,Integer> dp = new HashMap<>();

    static int getMaxSum(Node root)
    {
        if(root==null)
            return 0;
        if(dp.containsKey(root))
           return dp.get(root);
        int include = root.data;
        if(root.left!=null)
        {
            include+=getMaxSum(root.left.left);
            include+=getMaxSum(root.left.right);
        }
         if(root.right!=null)
        {
            include+=getMaxSum(root.right.left);
            include+=getMaxSum(root.right.right);
        }
        int exclude = getMaxSum(root.left)+getMaxSum(root.right);
        
        dp.put(root,Math.max(include,exclude));
        
        return dp.get(root);
    }

    public static void main(String args[])
    {
        Node root= new Node(10);
        root.left= new Node(1);
        root.left.left= new Node(2);
        root.left.left.left= new Node(1);
        root.left.right= new Node(3);
        root.left.right.left= new Node(4);
        root.left.right.right= new Node(5);   
        System.out.print("max sum:"+getMaxSum(root));
    }
}
