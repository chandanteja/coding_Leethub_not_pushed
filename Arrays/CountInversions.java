/**
 * 
 * https://www.geeksforgeeks.org/counting-inversions/
 * 
 * https://www.youtube.com/watch?v=3JV8rvIoRog
 * 
 *  We apply normal mergesort itself to count inversions but while merging we check for inversion.
 *  
 * If there exists an inversion then as array will be sorted, all the elements after the first element which caused inversion will also be part of inversion
 * 
 * T.C : O(nlogn)
 * S.C : O(n)
 * 
 */

package Arrays;

public class CountInversions {
    
    static long inversionCount(long arr[], long N)
    {
        if(N==0 || N==1)
            return 0;
        long temp[] = new long[(int)N];
        long nInversions = mergeSort(arr,0,N-1,temp);
        return nInversions;
    }
    
    static long mergeSort(long arr[],long low,long high,long temp[])
    {
        long inv_cnt=0;
        
        if(low<high)
        {
            long mid = low + (high-low)/2;
            inv_cnt+=mergeSort(arr,low,mid,temp);
            inv_cnt+=mergeSort(arr,mid+1,high,temp);
            inv_cnt+= merge(arr,low,mid,high,temp);
        }
        return inv_cnt;
    }
    
    static long merge(long arr[],long l,long m,long h,long temp[])
    {
    
    long mid=l+(h-l)/2;
    long inv_cnt=0;
    int i=(int)l,j=(int)mid+1,k=(int)l;
    
    while(i<=mid && j<=h)
    {
        if(arr[i]<=arr[j])
        {
            temp[k]=arr[i];
            i++;
            k++;
        }
        else{
            temp[k]=arr[j];
            k++;
            j++;
            inv_cnt=inv_cnt+(mid-i +1); // if arr[i] <=arr[j] then no problem, else if arr[i] > arr[j] then inversion exists bcz i<j, as the array will be sorted, all the elements b/w 'arr[i]' and 'mid' will also be part of inversion.
        }
    }
    
    while(i<=mid)
    {
        temp[k]=arr[i];
        k++;
        i++;
    }
    while(j<=h)
    {
        temp[k]=arr[j];
        k++;
        j++;
        
    }
    for(int p=(int)l;p<=h;p++)
    {
        arr[p]=temp[p];
    }
    return inv_cnt;
    
    }

}
