/**
 * 
 *  TIP:   Whenever you're trying to solve an array problem in-place, always consider the possibility of iterating backwards instead of forwards through the array. 
 * It can completely change the problem, and make it a lot easier.
 * 
 * 
 * https://leetcode.com/problems/merge-sorted-array/solution/       --> See Approach-3 in solutions for this problem
 * 
 * Approach 2 already demonstrates the best possible time complexity, O(n+m), but still uses additional space. This is because the elements of array nums1 have to be stored somwhere so that they aren't overwritten.

So, what if instead we start to overwrite nums1 from the end, where there is no information yet?

The algorithm is similar to before, except this time we set p1 to point at index m - 1 of nums1, p2 to point at index n - 1 of nums2, and p to point at index m + n - 1 of nums1. This way, it is guaranteed that once we start overwriting the first m values in nums1, we will have already written each into its new position. 
In this way, we can eliminate the additional space.
 * 
 */

 // iterate from backwards.
public class MergeTwoSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // pointer1 points to last element of 1st array.
        // pointer2 points to last element of 2nd array.
        int p1 = m-1;
        int p2 = n-1;
        
        // take another pointer and iterate from the back to front of array 1
        for(int p=m+n-1;p>=0;p--)
        {
            if(p2<0)    // if 2nd array all elements are checked then return 1st array directly.
                    break;
            if(p1>=0 && nums1[p1] > nums2[p2])  // when element in 1st array is bigger than element in 2nd array
                nums1[p] = nums1[p1--]; // put that element in pth position and move 1st pointer forward.
            else        // when element in 2nd array is bigger than element in 1st array
                nums1[p] = nums2[p2--]; // put that element in pth position and move 2nd pointer forward                        
        }
        
    }
    
}

/*



we are iterating from back to front of both the arrays. when 1 array element is bigger than other, then put this bigger element at the end of
1st array. when element comes from 1st array then move 1st arrays pointer forward. if its coming from 2nd array then move 2nd arrays pointer forward
in both the cases, move end pointer forward.


    
*/


