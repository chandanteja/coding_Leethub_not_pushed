/**
 * https://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/
 * 
 * T.C : O(n)
 * 
 * Logic is first, we recurr to find the node containing key, after getting node containing key, find predecessor and successor as below.
 * To find predecessor, we move left once from current node and we keep on moving right from there till end, as predecessor means largest ele in left  subtree of the node.
 * To find successor, we move right once from current node and we keep on moving left from there till end, as successor means largest ele in right  subtree of the node.
 * 
 */
package BST;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

public class InorderPredecessor_Successor {

    static Node pred,succ;

    public static void findPredSucc(Node root, int key)
    {
        if(root==null)
            return;
        if(root.data == key)    // if key node is found.
        {
            // We go left once and move right till end is reached, i.e till predecessor is found.
            // The maximum value in left
        // subtree is predecessor
            if(root.left != null)   
            {
                Node temp = root.left;
                while(temp.right!=null)
                    temp=temp.right;
                pred=temp;
            }

            // We go right once and move left till end is reached, i.e  till successor is found.
            // The minimum value in
        // right subtree is successor
            if(root.right!=null)
            {
                Node temp = root.right;
                while(temp.left!=null)
                    temp=temp.left;
                succ=temp;

            }
        }
        if(key<root.data)   // if key is lessthan root-> data , we need to search in left subtree, but if key is found in left subtree, then successor can be the root element in inorder sequence
        {
            succ=root;  // successor can be root element for left subtree
            findPredSucc(root.left,key);
        }
        else{
            // if key is >= root-> data , we need to search in right subtree, but if key is found in right subtree, then predecessor can be the root element in inorder sequence
            pred=root;      // predecessor can be root element for right subtree
            findPredSucc(root.right,key);
        }
    }
    
    public static void main(String[] args)
{
     
    // Key to be searched in BST
    int key = 65;
 
    Node root = new Node(50);
    root.left = new Node(30);
    root.left.left = new Node( 20);
    root.left.right = new Node( 40);
    root.right = new Node( 70);
    root.right.left = new Node( 60);
    root.right.right = new Node( 80);
 
    findPredSucc(root, key);
    if (pred != null)
        System.out.println("Predecessor is " + pred.data);
    else
        System.out.println("No Predecessor");
 
    if (succ != null)
        System.out.println("Successor is " + succ.data);
    else
        System.out.println("No Successor");
}
}
