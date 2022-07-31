package Heaps;

/**
 *  IDEA : For largest elements (K or Kth), create a max-heap using heapify() and build-heap ()  of heap creation methods. Now take the K-elements.
 *  For K-smallest or Kth smallest element, we can use min-heap.
 *  T.c = O(n+ klogn)
 *  For the above problem to be solved in linear time, we need to apply order statistics.
 */

public class KLargestElements {

    public static void heapify(int arr[],int n,int i)
    {
        int currentNode = i;
        int left = 2*i+1;
        int right  = 2*i+2;

        if(left < n && arr[left] > arr[currentNode])
                currentNode = left;
        if(right < n && arr[right] > arr[currentNode])
            currentNode = right;

        if(currentNode != i)    
        {
            int temp = arr[i];
            arr[i] = arr[currentNode];
            arr[currentNode] = temp;

            heapify(arr, n, currentNode);

        }
    }

    public static void buildHeap(int arr[],int n)
    {
        int startIndex = n/2 -1;
        for(int i = startIndex;i>=0;i--)
        {
            heapify(arr, n, i);
        }
    }

    public static int[] kLargestEle(int arr[],int k,int n)
    {
        int kLargestValues[] = new int[k];
       
        for(int i=0;i <k;i++)
        {
            int temp = arr[0];
            arr[0] = arr[n-1];

            kLargestValues[i] = temp;
            n--;
            heapify(arr, n, 0); // heapify from root node as it would have voilated heap ppty.

        }
        return kLargestValues;
    }

    static void printHeap(int arr[], int n)
     {
         System.out.println("Array representation of Heap is:");
   
         for (int i = 0; i < n; ++i)
             System.out.print(arr[i] + " ");
   
         System.out.println();
     }

    public  static void main(String[] args) {

        int arr[] = { 1, 3, 5, 4, 6, 13, 10,9, 8, 15, 17 };

        int n = arr.length;
        buildHeap(arr, n);
        printHeap(arr, n);
        int k = 5;

        int kLargestElem [] = kLargestEle(arr, k, n);

        printHeap(kLargestElem, k);
        printHeap(arr, n-k);
        
    }

}