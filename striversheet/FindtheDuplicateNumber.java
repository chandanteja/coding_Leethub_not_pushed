/**
 * 
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * Solution:    (Multiple methods are there)
 * ==========
 * https://leetcode.com/problems/find-the-duplicate-number/solution/
 * 
 * Floyd Cycle detection algo correctness: ( this is same as the one used in linkedlist.)
 * ======================================
 * https://medium.com/@aggarwaldeepak/remove-cycle-from-linked-list-code-with-mathematical-proof-6202ba895dd7
 * https://cs.stackexchange.com/questions/10360/floyds-cycle-detection-algorithm-determining-the-starting-point-of-cycle
 * 
 */

public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        
        // we use floyd's cycle detection algo which we use for linked-list. 
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        
        // after the end of above loop, slow and fast point to same node.
        // now point slow to starting  and move both slow and fast by one step.
        
        slow = nums[0];
        
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
        
        
    }
}
