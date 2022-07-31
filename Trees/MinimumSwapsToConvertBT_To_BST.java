/**
 * https://www.geeksforgeeks.org/minimum-swap-required-convert-binary-tree-binary-search-tree/#:~:text=Given%20the%20array%20representation%20of,it%20into%20Binary%20Search%20Tree.&text=Swap%201%3A%20Swap%20node%208,node%209%20with%20node%2010.
 * 
 * Logic is: as inorder traversal of BST will be sorted order, we do inorder traversal of Binary tree and store in a vector.
 * No we create a vector/arraylist with (element,index) pair where element is taken from inorder array. 
 * We sort the above vector of pairs on the basis of 1st element and we apply swapping to restore back elements to same as previous position before sorting.
 * 
 */

package Trees;


import java.util.*;

class SortPair
{
    int data;
    int index;
    SortPair(int data,int index)
    {
        this.data = data;
        this.index=index;
    }
}

class SortPairComparator implements Comparator<SortPair> {

    @Override
    public int compare(SortPair o1, SortPair o2) {
        
        if(o1.data<o2.data)
            return -1;
        if(o1.data>o2.data)
            return 1;
        return 0;
    }


}

public class MinimumSwapsToConvertBT_To_BST {

    static Vector<Integer> inorderVec = new Vector<>();

    public static void inorder(int arr[],int n,int arrayIndex)
    {
        // if index is greater or equal to arr[] size
        if(arrayIndex >= n)
            return;

        // left root right
        inorder(arr,n,2*arrayIndex+1);  // left child
        inorderVec.add(arr[arrayIndex]);    // root i.e perform any operation
        inorder(arr,n,2*arrayIndex+2);  // right child

    }

   static Vector<SortPair> v = new Vector<>();
    
    // Function to find minimum swaps to sort an array
    public static int minSwaps()
    {
        
        for(int i=0;i<inorderVec.size();i++)
            v.add(new SortPair(inorderVec.get(i), i));
        int minswaps=0;

        Collections.sort(v, new SortPairComparator());

        for(int i=0;i<v.size();i++)
        {
            if(i==v.get(i).index)
                continue;
            else{
                // swapping current ele with element in the index value of current ele.
                Collections.swap(v, i, v.get(i).index);
            }
            if(i!=v.get(i).index)
                i--;
            minswaps++;
        }

        return minswaps;
    }

    public static void main(String args[])
    {
        int a[] = { 5, 6, 7, 8, 9, 10, 11 };
        int n = a.length;
        
        inorder(a, n, 0);
        System.out.println("min Swaps is: "+ minSwaps());
    }
}
