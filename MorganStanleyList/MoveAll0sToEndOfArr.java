/**
 * 
 * https://leetcode.com/problems/move-zeroes/
 * 
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * 
 * // logic is here we copy all non zero elements to start of array in the same order in which they appear in the array (maintaining order)
 * After moving all non zero to fron we simply put 0's at the end
 * 
 * 
 * 
 */

package MorganStanleyList;

public class MoveAll0sToEndOfArr {

    public void moveZeroes(int[] nums) {
        
        int lastNonZeroFoundAt = 0; // keeps track of last non zero element found at which index.
        
        // If the current element is not 0, then we need to
    // append it just in front of last non 0 element we found. 
        for(int i=0;i<nums.length;i++)  // here we compy all non zero ele to front of array by maintaining order.
        {
            if(nums[i]!=0)
                nums[lastNonZeroFoundAt++]=nums[i];
        }
        
        // After we have finished processing new elements,
 	// all the non-zero elements are already at beginning of array.
 	// We just need to fill remaining array with 0's.
        for(int i=lastNonZeroFoundAt;i<nums.length;i++) // put 0's at the end of array
            nums[i] = 0;
        
    }
    
}
