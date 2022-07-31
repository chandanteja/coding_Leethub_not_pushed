/**
 * 
 * https://leetcode.com/problems/find-the-duplicate-number/     --> qns
 * 
 * https://www.youtube.com/watch?v=32Ll35mhWg0
 * 
 * Logic is use fast and slow pointers method.
 * 
 *  Given array n+1 numbers which has elements b/w [1,n] (inclusive).
 * 
 * Here only one number will be repeated among n-numbers. We need to find that number.
 * 
 * Only one number will be repeated.
 */

package Arrays;

// Note we can also apply, 'FindDuplicateNumbers2' solution also., which is a hashing based soln.

public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        fast = nums[0];
        while(slow!=fast)
        {
            slow=nums[slow];
            fast=nums[fast];

        }
        return slow;

    }
    
}
