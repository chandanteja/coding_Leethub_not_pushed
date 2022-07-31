/**
 * Refer GFG course video for this solution.
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/ --> refer DP approach.
 * 
 * Logic is we maintain local-maximum and global-maximum and we update these two variables when every element of array is considered.
 * 
 */

package DP;

public class LargestSumContiguousSubArray {

    int maxSubarraySum(int arr[], int n){
        
        // initialization
        int localmax = arr[0];  // localmax keeps track of maximum subarray sum which can change when new element is considered in subarray. This can change with every iteration
        int globalmax = arr[0]; // Global max keeps track of maximum of all subarrays that have been processed till now.
        
        for(int i=1;i<n;i++)    // Logic is every new element of array can either start new largest subarray sum  or extend the previous subarray sum
        {                       // previous subarray sum is maintained in local max. So, we add arr[i] to previous subarray sum and check if which is greater among those 2.                    

            localmax = Math.max(arr[i],localmax+arr[i]);    // checking if previous subarray when added with arr[i] gives max or only arr[i] gives max.
            globalmax= Math.max(localmax,globalmax);        // localmax can become smaller at some point in time when compared to its previous values
        }                                                   // So we maintain global max too which tells max sum subarray sum in whole array.
        return globalmax;
        
    }
    
}
