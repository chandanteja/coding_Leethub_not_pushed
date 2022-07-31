/**
 * Same as Largest SUm contiguous subarray, but here we need to find samllest sum.
 * 
 * https://www.geeksforgeeks.org/smallest-sum-contiguous-subarray/  
 * 
 * The below are the two approaches.
 * 
 */

package DP;

public class SmallestSumContiguousSubArray {

    public static int smallestSumSubarray(int arr[], int n)
    {
        int localmin = arr[0];
        int globalmin = arr[0];

        for(int i=1;i<n;i++)
        {
            localmin = Math.min(arr[i], localmin+arr[i]);
            globalmin = Math.min(localmin,globalmin);
        }
        return globalmin;
    }

    // Another approach is  we multiply all elements of array with -1 and then apply kadanes for largest sum subarray and then multiply result with -1.
    static int smallestSumSubarray2ndApproach(int arr[], int n)
{
    // First invert the  sign of the elements
    for (int i = 0; i < n; i++)
        arr[i] = -arr[i];
 
    // Apply the normal Kadane algorithm But on the elements Of the array having inverted sign
    int sum_here = arr[0],
        max_sum = arr[0];
 
    for (int i = 1; i < n; i++)
    {
        sum_here = Math.max(sum_here + arr[i], arr[i]);
        max_sum = Math.max(max_sum, sum_here);
    }
 
    // Invert the answer
    // to get minimum val
    return (-1) * max_sum;
}
 
    
}
