/**
 * https://www.cse.iitd.ac.in/~rjaiswal/2012/csl356/Notes/Week-07/lec-1.pdf --> O(n^2) T.C, O(n) S.C
 * 
 * Refer GFG course videos --> O(nlogn)
 * 
 * https://www.youtube.com/watch?v=TocJOW6vx_I  --> O(nlogn) approach
 * 
 * O(n^2) Logic:
 * -------------
 * Length of LIS of single element is always 1.
 * We use an array LIS[] to keep track of length of LIS.
 * LIS[i] = length of longest increasing subsequence till 'i'th index in given array will be stored in LIS[i].
 * So, we fill this array and also use a 'max' variable to keep track of length of LIS that we got at any point of time.
 * for all i, we loop fro, j=0 to j=i-1;
 * if(a[i]> arr[j]) 
 *  it means we found an element which is smaller than arr[i]. So we can increase LIS by 1.
 * 
 * 
 */

package DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    // This is O(n^2) method i.e D.P based soln.
    static int longestSubsequence(int size, int a[])
    {
        int lis[] = new int[size];  // lis[i] stores the length of LIS till index-i starting from 0.

        Arrays.fill(lis,0); 
        lis[0]=1;   // lis of single element is always 1.
        int max=lis[0]; // stores max LIS, this is useful when returning length of lIS as we need not traverse entire array again to find max LIS

        for(int i=1;i<size;i++) // for all i, 'j' loops from 0 to i-1.
        {
            // initializing the ith element value as 1, bcz lis of single element will always be 1.
            lis[i] =1;      // lis of single element is always 1. As lis[i] will be one element which will be of length=1 always.
            for(int j=0;j<i;j++)    // for all i, 'j' loops from 0 to i-1.
            {
                if(a[j]<a[i])   // if current element at index-j is less than the value pointed by index-i, then this will be part of LIS. So, we update its length of element at index-i in lis[].
                // bcz jth element will be part of lis sequence ending at element-i.
                {
                    // if adding element at index- 'j' increases lis[i] then we add 'j'th ele to lis of ith ele.
                    if(lis[i]<lis[j]+1)     // if lis[i] (length of lis of ele at index-i) < when the element a[j] is included as part of LIS i.e (1+lis[j]), then we extend the length of lis.
                        lis[i] = lis[j]+1;
                    
                    if(max<lis[i])      // updating the max variable.
                        max=lis[i];
                }
            }
        }
        return max;
    }

    // This is O(nlogn) method based on binary search.
    // In this method, we maintain an array instead of storing length of LIS, we store LIS itself. 
    // lis[] stores the elements itself rather than length. lis[i] stores minimum possible end/tail value for LIS of length i+1.

    public static int findCeilBS(int arr[],int l,int r, int key)
    {
        // we find index of the key given (if given element is present), else we find index of smallest element larger than given key.
        while(r>l)
        {
            int m = l + (r-l)/2;
            if(arr[m]>=key) // if 'mid' ele is greater than 'key' then this could be our ans. Hence we move 'r' to 'mid' but not 'mid-1'
                r=m;
            else    // this is normal case of binary search
                l=m+1;
        }
        return r;
    }

    public static int findLengthOfLIS(int arr[])
    {
        int n = arr.length;
        int lis[] = new int[n];
        lis[0] = arr[0];
        int len =1; // keeps track of length of LIS and also how many numbers are included in lis[] (same as length of lis).
        for(int i=1;i<n;i++)
        {
            if(arr[i] > lis[len-1])     // if last element in lis[] is smaller than current element of 'arr' i.e  arr[i], then we append that element to lis.
            {
                lis[len] = arr[i];
                len++;
            }
            else{
                // if current element at index-i is smaller than last element of lis[], then we do binary search to find where this element goes into lis..
                // i.e if given element is already present in lis[] then it will return the index of that ele or if given element is not present, then we will find the smallest element bigger than given element.
                // We replace the above returned index with current element which is smaller than last ele of lis[].
                int index = findCeilBS(lis,0,len-1,arr[i]);
                lis[index] = arr[i];
            }
        }
        return len;
    
    }

    public static void main(String args[])
    {
        int arr[] = { 1,2,5,4,3 };
        int n = arr.length;
        System.out.println("Length of lis is " + longestSubsequence(n,arr) + "\n");
        System.out.println("Length of lis is " + findLengthOfLIS(arr) + "\n");
    }
    
}
