/**
 * 
 * This is also same as calculating Pivot index or Eqquilibrium point.
 * 
 * Refer GFG Self paced DSA course --> Arrays --> prefix sum technique.
 * 
 * https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 * https://leetcode.com/problems/find-pivot-index/submissions/
 * 
 * The idea is to get the total sum of the array first. 
 * Then Iterate through the array and keep updating the left sum which is initialized as zero. 
 * In the loop, we can get the right sum by subtracting the elements one by one. 
 * 
 */

package Amazonlist;

public class FindEquilibriumPoint {

    public int pivotIndex(int[] nums) {
        
        int leftsum=0;
        int sum=0;
        
        // first calculate the entire sum of array.
        for(int i=0;i<nums.length;i++)
                sum=sum+nums[i];
        
                // now check if leftsum==right sum for every index-i.
                // left sum we will track in variable 'leftsum'
                // we can get right sum by removing the left most ele from total sum every time.
        for(int i=0;i<nums.length;i++)
        {
            sum = sum-nums[i];  // removing the left element gives right sum at index-i

            // if leftsum==rightsum( which will be in 'sum' as we remove leftside elements) then we found equilibrium point at indx=i.
            if(leftsum==sum)
                    return i;
            leftsum=leftsum+nums[i];    // adding ith element to left sum.
        }
        return -1;
        
    }
    
}
