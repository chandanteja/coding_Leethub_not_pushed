/**
 * 
 * https://leetcode.com/problems/maximum-subarray/
 * 
 */

public class MaximumSumSubarray {

    public int maxSubArray(int[] nums) {
        
        // start with first element of array.
        int localSum=nums[0];
        int globalSum=nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            localSum = Math.max(nums[i],localSum+nums[i]);  // new local sum can start or old local sum can be extended at every element of array.
            globalSum = Math.max(localSum,globalSum);   
        }
        
        return globalSum;
        
    }
    
}

/**
 * 
 * This is Kadanes algorithm.       --> O(N)

Implementation is like below
===========

We need to start with 1st element of the given array.
We need to keep track of local sum and global sum.
Local sum is updated at every element of the array, so local sum can change.
Global sum is updated when we find a new sum which is greater than previous sum.

AT every element of array, either new localsum can be started or old local sum can be extended. SO we check with max.
 * 
 */
