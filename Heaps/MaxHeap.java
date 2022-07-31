package Heaps;


/**
 *  Refer GFG link for the below code:
 *  https://www.geeksforgeeks.org/building-heap-from-array/
 */

public class MaxHeap {

    public static  void heapify(int arr[],int n,int i)
    {
        int currentNode = i;
        int left = 2*i + 1;
        int right = 2*i +2;
 
        if(left < n && arr[left] > arr[currentNode])
             currentNode = left;
 
         if(right < n && arr[right] > arr[currentNode])
             currentNode = right;
         
         if(currentNode!=i)
         {
             // Swap currentnode with node-i
             arr[i] = arr[i] ^ arr[currentNode];
             arr[currentNode] = arr[i] ^ arr[currentNode];
             arr[i] = arr[i] ^ arr[currentNode];
 
             heapify(arr,n,currentNode); // heapify down the current node
         }
 
    }
 
    public static  void buildHeap(int arr[],int n)
    {
         int firstNonLeafIndex = (n/2)-1;
         
         for(int i = firstNonLeafIndex; i>=0;i--)
             heapify(arr, n, i);
    }
 
    static void printHeap(int arr[], int n)
     {
         System.out.println("Array representation of Heap is:");
   
         for (int i = 0; i < n; ++i)
             System.out.print(arr[i] + " ");
   
         System.out.println();
     }
   
     // Driver Code
     public static void main(String args[])
     {
         int arr[] = { 1, 3, 5, 4, 6, 13, 10,
                       9, 8, 15, 17 };
   
         int n = arr.length;
   
         buildHeap(arr, n);
   
         printHeap(arr, n);
     }

}