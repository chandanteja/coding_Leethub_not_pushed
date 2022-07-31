/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * 
 * 
 * Intuition
------------------
We definitely need to keep track of all the unique numbers that appear in the array. However, we don't want to use any extra space for it. This solution that we will look at in just a moment springs from the fact that

All the elements are in the range [1, N]

Since we are given this information, we can make use of the input array itself to somehow mark visited numbers and then find our missing numbers. Now, we don't want to change the actual data in the array but who's stopping us from changing the magnitude of numbers in the array? That is the basic idea behind this algorithm.

We will be negating the numbers seen in the array and use the sign of each of the numbers for finding our missing numbers. We will be treating numbers in the array as indices and mark corresponding locations in the array as negative.

Algorithm
-------------
Iterate over the input array one element at a time.
For each element nums[i], mark the element at the corresponding location negative if it's not already marked so i.e. nums[ nums[i]- 1] * -1.
Now, loop over numbers from 1⋯N and for each number check if nums[j] is negative. If it is negative, that means we've seen this number somewhere in the array.
Add all the numbers to the resultant array which don't have their corresponding locations marked as negative in the original array.
 * 
 */

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingEleInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        // Iterate over each of the elements in the original array
        for (int i = 0; i < nums.length; i++) {
            
            // Treat the value nums[i] as the new index
            int newIndex = Math.abs(nums[i]) - 1;   // we apply abs() bcz after negating some elements in below step, some ele. can be -ve So we apply abs() and take +ve value.
            // also we subtract 1, i.e we do -1 bcz in qns its given numbers in array can be in range of [1,n] (inclusive) but array indices are from [0, n-1].  So this is why we do -1.
            
            // Check the magnitude of value at this new index
            // If the magnitude is positive, make it negative 
            // thus indicating that the number nums[i] has 
            // appeared or has been visited.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        
        // Response array that would contain the missing numbers
        List<Integer> result = new ArrayList<Integer>();
        
        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for (int i = 1; i <= nums.length; i++) {
            
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        
        return result;
    
}
}
