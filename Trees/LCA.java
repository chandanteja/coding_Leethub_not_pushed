/**
 * https://www.youtube.com/watch?v=3MmWkR04n_8 --> watch this.
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * 
 * T.C = O(n)
 * 
 * Logic: We will be given 2 nodes, n1,n2 and we need to find LCA. 
 * So, we will first traverse entire tree to find n1,n2. If for one node only n1 is there and there is other node for which child is n2 then,
 * logic here is ancestor node shuld have n1 on one side and n2 on other side. so the ancestor node shuld not get null from both side. 
 * They shuld only get n1 and n2 values form both side. so intermediate nodes also return n1 or n2 respectively,
 */

package Trees;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

public class LCA {

    public static Node lca(Node root, int n1, int n2)
    {
        if(root == null)
            return null;
        if(root.data == n1 || root.data == n2)
            return root;
        
        Node left = lca(root.left,n1,n2);
        Node right = lca(root.right,n1,n2);
        
        if(left!=null && right != null) // it means the node at which both left and right comes as not null from its left and right child, it is the node we need. So we return root.
            return root;
        return left!=null ? left : right;
    }

    public static void main(String[] args)
    {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        System.out.println("LCA(4, 5): " + lca(root,4,5).data);
        System.out.println("LCA(4, 6): " + lca(root,4,6).data);
        System.out.println("LCA(3, 4): " + lca(root,3,4).data);
        System.out.println("LCA(2, 4): " + lca(root,2,4).data);
     
    }
    
}
