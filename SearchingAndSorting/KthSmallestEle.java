/**
 * 
 * https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
 * 
 * T.C: Worst case O(n^2)
 *      Average case O(n).
 * 
 * Here the order of elements in original array will be changed so if we shuld not change order of ele in array then copy ele to duplicate array.
 * 
 * Refer Self paced DSA course --> SOrting for both lomuto partition and kth smallest ele.
 * 
 * Order statistics is complex process.
 */

package SearchingAndSorting;

public class KthSmallestEle {
    
    // quick select method using partition
    // Standard partition process of QuickSort.
    // It considers the last element as pivot
    // and moves all smaller element to left of
    // it and greater elements to right
    int lomutoPartition(int arr[],int l,int h)
    {
        int pivot = arr[h];  //always last ele is selected as pivot

        int i=l-1;  // keeps track of smaller elements than pivot.

        for(int j=l;j<h;j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                // swap arr[i] and arr[j] ele.
                int temp = arr[i] ;
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[h]

        int temp = arr[i+1];
        arr[i+1] = arr[h];
        arr[h] = temp;
        return (i+1);
    }


    // This function returns k'th smallest element
    // in arr[l..r] using QuickSort based method.
    // ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
    int kthsmallestEle(int arr[],int n,int k)
    {
        int l=0,r=n-1;
        
        while(l<=r)
        {
            // Partition the array around last
            // element(pivot) and get position of pivot
            // element in sorted array
            int p = lomutoPartition(arr, l, r);

            // If position is same as k
            if(p==k-1)
                return p;

            // If position is more, recur for
            // left subarray
            else if(p>k-1)
                r=p-1;
            else        // Else recur for right subarray
                l=p+1;
        }
        return -1;
    }

}
