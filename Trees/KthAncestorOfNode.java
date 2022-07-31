/**
 * https://www.geeksforgeeks.org/kth-ancestor-node-binary-tree/ ---> see level order style of traversal to find kth ancestor.
 * https://www.geeksforgeeks.org/kth-ancestor-node-binary-tree-set-2/ --> recursion based solution.
 * 
 * Above both methods take 
 * T.C: O(n)
 * S.C: O(n)
 *  traverse till u reach that node head recursion.cso when u reach that node move up and decrement k with each move.when k becomes 0 print it.
 */

package Trees;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left = right =null;
    }
}

public class KthAncestorOfNode {

    static  int tempk;
    static  int res=-1 ;
    static Node temp;
    
public static Node kthAnc(Node root,int node)
{
        if(root==null)   // when no root i.e. at the children of leaf nodes. return NULL.
            return null;
   
    if(root.data ==node || (temp=kthAnc(root.left,node))!=null||(temp=kthAnc(root.right,node))!=null)
    {
        // if root.data==node then we have reached that node. go inside and k wont be 0 so decrement it and return root
    // and go 1 level up. then in the above level it will be in either 2nd or-case or 3rd or-case, and it will be in temp.
    // now its always true so go inside if k>0 decrement k and return root and go another level up or else if k is 0 then print the value. 
        if (tempk > 0)     
            tempk--;          
        else if (tempk == 0)
        {            
            res=root.data;
            return null;
        }
        return root;
    }
    return null;
}
    
    public static int kthAncestor(Node root, int k, int node)
    {
        tempk=k;
        kthAnc(root,node);
        return res;
    }

    public static void main(String[] args)
{
    // Let us create binary tree shown in above diagram
    Node root = new Node(1);
    root.left =new Node(2);
    root.right = new Node(3);
    root.left.left =new Node(4);
    root.left.right =new Node(5);
 
    int k = 2;
    int node = 5;
 
    // print kth ancestor of given node
    System.out.println(kthAncestor(root,k,node));
}

}
