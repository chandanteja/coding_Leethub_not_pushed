/**
 * 
 * https://www.geeksforgeeks.org/count-bst-nodes-that-are-in-a-given-range/
 * 
 * 
 *  Logic is if root is null we return 0.
 *  l-low and h-high. Inclusive of l and h.
 *  If node lies b/w l and h, then it adds '1' to whatever is returened by its left child and right child i.e 1+lv+rv.
 * If a node doesnt lie b/w l and h, then the node returns to its caller what ever it got from its children, i.e lv+rv. It won't add '1' i.e itself as it doesnt lie in range.
 */

package BST;


class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left=right=null;
    }
}


public class CountNodesInGivenRangeBST {


    static int getCount(Node root,int l, int h)
    {
        if(root==null)
            return 0;
        int lv= getCount(root.left,l,h);
        int rv=getCount(root.right,l,h);
        
        if(root.data>= l && root.data <=h)
            return 1+lv+rv;
        else
            return lv+rv;
    }

    public static void main(String[] args) {
        
        Node root = new Node(10);
        root.left     = new Node(5);
        root.right     = new Node(50);
        root.left.left = new Node(1);
        root.right.left = new Node(40);
        root.right.right = new Node(100);
       
    int l=5;
    int h=45;
    System.out.println("Count of nodes between [" + l + ", " + h+ "] is " + getCount(root, l, h));
    }
}
