/**
 * https://www.geeksforgeeks.org/replace-every-element-with-the-least-greater-element-on-its-right/
 * 
 * Logic is we are given an array, we need to replacce every element with least greatest element on its right, which is same as replacing with inorder successor.
 * So, we need to organize array as BST. During every insertion of element, we need to keep track of successor of current element inserted.
 * 
 * The worst-case time complexity of the below solution is also O(n^2) as it uses BST. 
 * The worst-case will happen when array is sorted in ascending or descending order. 
 * The complexity can easily be reduced to O(nlogn) by using balanced trees like red-black trees.
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

public class ReplaceEveryElementWIthLeastGreatestOnRight {

    static Node succ=null;
    static Node root=null;

    // A utility function to insert a new node with
// given data in BST and find its successor
    public static Node insertNode(Node node,int ele)
    {
        // If the tree is empty, return a new node
        if(node==null)
            node = new Node(ele);
        
    // If key is smaller than root's key,
    // go to left subtree and set successor
    // as current node
            if(ele<node.data)
            {
                succ=node;
               node.left= insertNode(node.left, ele);

            }
            // Go to right subtree. We cant track successor in this case, we can only track predecessor here. This is not need predecessor track.
            else if(ele>node.data)
              node.right=  insertNode(node.right, ele);
        return node;
        
    }

    // Function to replace every element with the
// least greater element on its right
    public static void replaceWithLeastEle(int arr[])
    {
        // start from right to left
        for(int i=arr.length-1;i>=0;i--)
        {
            succ=null;      // reset to null as we have a check below if succ is null.

            // Insert current element into BST and
        // find its inorder successor
            root = insertNode(root,arr[i]);

            // Replace element by its inorder
            // successor in BST
            if(succ!=null)
                arr[i]=succ.data;
            else{
                  // No inorder successor
                arr[i] = -1;
            }
        }
    }

    public static void main(String[] args)
{
    int arr[] = new int[] { 8, 58, 71, 18, 31,
                            32, 63, 92, 43, 3,
                            91, 93, 25, 80, 28 };
    int n = arr.length;
 
    replaceWithLeastEle(arr);
 
    for(int i = 0; i < n; i++)
        System.out.print(arr[i] + " ");
}
    
}
