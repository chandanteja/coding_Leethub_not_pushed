package Heaps;

/**
 * For build heap and heapify refer below link
 *  https://www.geeksforgeeks.org/building-heap-from-array/
 */

public class HeapSort {

   public static  void heapify(int arr[],int n,int i)
   {
       int currentNode = i;     // this is the ROOT node which needs to be checked for voilation of heap ppty with children nodes.
       int left = 2*i + 1;
       int right = 2*i +2;

       if(left < n && arr[left] > arr[currentNode])
            currentNode = left;

        if(right < n && arr[right] > arr[currentNode])
            currentNode = right;
        
        if(currentNode!=i)
        {
            // Swap currentnode with node-i
            int temp = arr[i];
            arr[i] = arr[currentNode];
            arr[currentNode] = temp;

            heapify(arr,n,currentNode); // heapify current node to last level. This is Top-Down heapify
        }

   }

   public static  void buildHeap(int arr[],int n)
   {
        int firstNonLeafIndex = (n/2)-1;        // as root index is at 0, then the non leaf nodes will be from (n/2)-1

        for(int i = firstNonLeafIndex; i>=0;i--)        // we will iterate from level n-1 to level-0 , where level-n contains all leaf nodes.
            heapify(arr, n, i);                     // heapify works in topd-down fashion
   }

   static void printHeap(int arr[], int n)
    {
        System.out.println("Array representation of Heap is:");
  
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
  
        System.out.println();
    }

    static void heapSort(int arr[],int n)
    {
        int element;
            while(n!=0)
            {
                element = arr[0];   // taking first element to temp variable.
               
                // exchange first and last elements. This puts the top element in its correct place.
                int temp = arr[0];
                arr[0] = arr[n-1];
                arr[n-1] = temp;
                n--;        // exclude the last element where the sorted element is stored.

                heapify(arr,n,0);       // as the top element voilates heap ppty, heapify from top to bottom.
            }
    }
  
    // Driver Code
    public static void main(String args[])
    {
        int arr[] = { 1, 3, 5, 4, 6, 13, 10,
                      9, 8, 15, 17 };
  
        int n = arr.length;
  
        buildHeap(arr, n);
  
        printHeap(arr, n);

        heapSort(arr, n);

        printHeap(arr, n);

    }

    
}
