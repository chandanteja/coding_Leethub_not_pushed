package Heaps;

/**
 *  Approach is first take an array of size as big as sum pf sizes of two arrays given. Now add all elements from given 2 arrays to bigger array.
 *  if max heap is needed apply heapify for maxheap and build-heap.
 *  https://www.geeksforgeeks.org/merge-two-binary-max-heaps/
 */


public class MergeTwoBinaryMaxHeaps {

    public static void heapify(int arr[],int n,int i)
    {
        int currNode = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && arr[left]> arr[currNode])
                currNode = left;
        if(right<n && arr[right]> arr[currNode])
               currNode = right;
        
        if(currNode!= i)
        {
            int temp =arr[i];
            arr[i] = arr[currNode];
            arr[currNode] = temp;
            heapify(arr, n, currNode);
        }
        
    }

    public static void buildHeap(int arr[],int n)
    {
            int startIndex = n/2-1;
            for(int i =startIndex ;i>=0;i--)
                heapify(arr,n,i);
    }
    
    public static int[] mergeTwoBinaryMaxHeaps(int arr1[],int arr2[],int n1,int n2)
    {
        int res[] = new int[n1+n2];
        int i;
        for(i=0;i<n1;i++)
            res[i] = arr1[i];
        for(int j=0;j<n2;j++,i++)
            res[i] =arr2[j];

        buildHeap(res, n1+n2);
    
        return res;
    }
    static void printHeap(int arr[], int n)
    {
        System.out.println("Array representation of Heap is:");
  
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
  
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = { 10, 5, 6, 2 };

        int n1 = arr.length;

        int arr2[]  = {12, 7, 9};
        int n2= arr2.length;
        int res[]=mergeTwoBinaryMaxHeaps(arr, arr2, n1, n2);
        printHeap(res, n1+n2);


    }
}
