/**
 * https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 * 
 * We use mergesort to count inversions, while merging we count the inversions.
 * 
 * T.C : O(nlogn)
 * S.C : O(n)
 */

public class InversionCount {

    static long inversionCount(long arr[], long N)
    {
        long temp[] = new long[(int)N];
        long l=0;
        long r=N-1;
        return mergeSort(arr,l,r,temp);
    }
    
    private static long mergeSort(long arr[], long l, long r, long temp[])
    {
        long invCnt=0;
        
        if(l < r)
        {
            long mid = l+(r-l)/2;
            
            invCnt += mergeSort(arr, l, mid, temp);
            invCnt += mergeSort(arr, mid+1, r, temp);
            invCnt += mergeAndCount(arr, l, mid, r, temp);
        }
        
        return invCnt;
    }
    
    private static long mergeAndCount(long arr[], long l, long mid, long r, long temp[])
    {
        long i = l;
        long k = l;
        long j = mid+1;
        long invCnt = 0;
        
        while( i<=mid && j<=r)
        {
            if(arr[(int)i] <= arr[(int)j])      // if arr[i] <= arr[j] and from while condition i<=j ==> no inversion so dont add anything to count.
            {
                temp[(int)k++] = arr[(int)i++];
            }
            else                            // here arr[i] > arr[j] so there is inversion add to count.
            {
                temp[(int)k++] = arr[(int)j++];
                invCnt += (mid-i+1);            // invcnt = invcnt+(mid-i+1) we add  this part bcz, as we know while merging in mergesort, the left array will be sorted and also the right array will be sorted,
                                                // if arr[i]>arr[j] means as left array will be sorted, all the elements from index-i to end of left array i.e index-mid all the elements to right of index-i will also be greater than arr[j].
                                                // so we are adding all those elements in one go.
            }
        }
        while(i <= mid)     // the below all steps are same like in merge sort.
        {
            temp[(int)k++] = arr[(int)i++];         // here we are casting long to int bcz in java, array accept only int as indices.
        }
        while(j <= r)
        {
            temp[(int)k++] = arr[(int)j++];
        }
        
        for(i=(int)l;i<=(int)r;i++)
        {
            arr[(int)i] = temp[(int)i];
        }
        
        return invCnt;
    }
    
}
