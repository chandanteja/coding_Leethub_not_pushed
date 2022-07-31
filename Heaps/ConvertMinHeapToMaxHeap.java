package Heaps;

/**
 * T.C : O(n), it might look like O(nlogn), but its O(n).
 *  https://www.geeksforgeeks.org/convert-min-heap-to-max-heap/
 *  Approach : create a maxHeapify() which will take any array and create a max-heap.
 *  Call maxheapify from buildHeap().
 */
public class ConvertMinHeapToMaxHeap {

    public static void maxHeapify(int arr[],int n, int i)
    {
        int currentNode = i;        // we designate a node as current node under consideration in each heapify and we will proceed exploring its left and right child
        int left = 2*i+1;
        int right =2*i+2;

        if(left<n && arr[left]>=arr[currentNode]) // if left node is largerthan root node, then the node to heapify from will be left node
            currentNode = left;
        
        if(right<n && arr[right] >= arr[currentNode])
                currentNode = right;

        if(currentNode!=i)
        {
            int temp = arr[i];
            arr[i]=arr[currentNode];
            arr[currentNode] = temp;
            maxHeapify(arr, n, currentNode);
        }

    }

    public static void builMaxHeap(int arr[],int n)
    {
        int startIndex = n/2-1;
        for(int i=startIndex;i>=0;i--)
                maxHeapify(arr, n, i);
    }

    static void printArray(int arr[], int size)
    {
        for (int i = 0; i < size; ++i)
            System.out.print(arr[i]+" ");
    }
     
    // driver program
    public static void main (String[] args)
    {
        // array representing Min Heap
        int arr[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        int n = arr.length;
  
        System.out.print("Min Heap array : ");
        printArray(arr, n);
  
        builMaxHeap(arr, n);
  
        System.out.print("\nMax Heap array : ");
        printArray(arr, n);
    }

    
}
