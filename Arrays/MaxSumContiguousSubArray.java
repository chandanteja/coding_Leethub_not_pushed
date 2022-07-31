/**
 * 
 * 
 * Logic is Kadanes algo to find max sum contiguous subarray.
 * 
 * Brute force will take O(n^3) time. This is bcz there will be (n(n+1))/2 sub-arrays in an array of size=n.
 * 
 * To calculate sum of every subarray, we need to pick subarray and traverse thru it. So, time complextity will go upto O(n^3) in worst case for Bruteforce.
 * 
 * T.C: O(n)
 * 
 */

 /*

 Brute force -- O(N^2). This is optimized brute force.

public int maxSubArray(int[] nums) {
        int maxSubarray = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSubarray = 0;
            for (int j = i; j < nums.length; j++) {
                currentSubarray += nums[j];
                maxSubarray = Math.max(maxSubarray, currentSubarray);
            }
        }
        
        return maxSubarray;
    }

 */

package Arrays;

public class MaxSumContiguousSubArray {

    int maxSubarraySum(int arr[], int n){
        
        int localsum=arr[0];
        int globalsum = arr[0];
        
        for(int i=1;i<n;i++)
        {
            localsum = Math.max(localsum+arr[i],arr[i]);
            globalsum = Math.max(localsum,globalsum);
        }
        return globalsum;
     }
    
}
