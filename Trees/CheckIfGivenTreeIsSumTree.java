/**
 * https://www.youtube.com/watch?v=zqA8FwxXSdU --> watch this for explaination
 * 
 */

package Trees;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left=right=null;

    }
}

public class CheckIfGivenTreeIsSumTree {

    static int res=1;  // assuming that given tree is sum tree
    static int sumTreeCheck(Node root)
    {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return root.data;
        if(res==0)
            return 0;
        int a = sumTreeCheck(root.left);
        int b = sumTreeCheck(root.right);
    if(a+b != root.data)
        res= 0;
        return a+b+root.data;
            
    }
	static  boolean isSumTree(Node root)
	{
	        res=1;
	        sumTreeCheck(root);
	        if(res==1)
	            return true;
	       return false;
	}

    public static void main (String[] args)
    {
        
        Node root=new Node(26);
        root.left=new Node(10);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(6);
        root.right.right=new Node(3);
        if(isSumTree(root))
        {
            System.out.println("The given tree is a SumTree");
        }
        else
        {
            System.out.println("The given tree is not a SumTree");
        }
    }
    
}
