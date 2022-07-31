/**
 * https://www.youtube.com/watch?v=6DraIPN_0no&t=302s
 * 
 * T.C - O(n)
 * 
 * Approach to find distance b/w 2  nodes  in tree.
 * the distance b/w 2-nodes will pass thru common ancestor (LCA).
 * So we find dist from LCA to node-1 be d1 and LCA to node-2 be d2.
 * Now dist between node-1 and node-2 is d1+d2-2 (we are subtracting 2 bcz the LCA node will add value of +1 to dist from node-LCA and this will be added twice once in d1 and 2nd time in d2. So +2 is added extra, We remove it.)
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

public class DistanceBetween2Nodes
{
    public static Node LCA(Node root, int a,int b)
    {
        if(root==null)
            return null;
        if(root.data == a || root.data ==  b)
            return root;
        Node left = LCA(root.left,a,b);
        Node right = LCA (root.right,a,b);

        if(left!=null && right!=null)
            return root;        // it means the node at which both left and right comes as not null from its left and right child, it is the node we need. So we return root.
        if(left!=null)
            return left;
        else return right;

    }

    public static int findDist(Node root, int a)
    {
        if(root==null)
            return 0;
        if(root.data==a)
            return 1;
        int leftDist = findDist(root.left,a);
        int rightDist = findDist(root.right,a);
        
        if(leftDist == 0 && rightDist == 0) 
            return 0;   // it means a node got dist from left and right child as 0, it means there is no 'a' in its left or right sub tree. So we also return 0 back to caller.
        
            return leftDist+rightDist+1;   //as we are calculating dist, when any node receives a dist from its childern, it will add +1 to that value and send back as this node (parent) will also be included in the dist.
    }

    static int distance(Node root, int a, int b) {
        Node lca= LCA(root,a,b);
        int a1= findDist(lca,a);
        int b1=findDist(lca,b);
        return a1+b1-2;     // as the last node returning the value to caller will add +1 2-times in LCA(), once for a1 and once for b1, we are removing it. 
        
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
    root.right.left.right = new Node(8);
    System.out.println("Dist(4, 5) = " + distance(root, 4, 5));
    System.out.println("Dist(4, 6) = " + distance(root, 4, 6));
    System.out.println("Dist(3, 4) = " + distance(root, 3, 4));
    System.out.println("Dist(2, 4) = " + distance(root, 2, 4));
    System.out.println("Dist(8, 5) = " + distance(root, 8, 5));
}

}