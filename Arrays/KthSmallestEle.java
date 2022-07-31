/**
 * 
 *  https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/   --> refer this.
 * 
 * 
 */

package Arrays;

public class KthSmallestEle {

    public static void heapify(int arr[],int n,int i)
    {
        int currentNode = i;
        int left = 2*i+1;
        int right  = 2*i+2;

        if(left < n && arr[left] < arr[currentNode])
                currentNode = left;
        if(right < n && arr[right] < arr[currentNode])
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
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        int n = arr.length;
        buildHeap(arr,n);
        int res=0,temp=0;
        
        for(int i=0;i<k;i++)
        {
            temp = arr[0];  
            arr[0] = arr[n-1];      // deleting min ele.
            res=temp;
            n--;
            heapify(arr,n,0);
        }
        return res;
        
        
    } 

    /**
     * 
     * Build min-heap with given array of ele.
     * Repeat for k-times:
     *  1. delete-min ele. and store at the end of array.   (same as heap sort)
     *  2.  repeat this delete-min for k-times
     * 3.   while doing thus, use a result variable and keep track of the result we will have after looping for k-times.
     * 
     */
    
}
