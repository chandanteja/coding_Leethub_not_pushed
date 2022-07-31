/**
 * https://leetcode.com/problems/next-permutation/
 * 
 * https://leetcode.com/problems/next-permutation/solution/
 *  
 * https://www.youtube.com/watch?v=LuLCLgMElus   --> Watch this for intuition
 *
 */

public class NextPermutation {
   
    public void nextPermutation(int[] nums) {
        
        int breakPoint = -1;
        
        // here we are finding the point where arr[i] ele is smaller than arr[i+1] while traversing from right to left.
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i] < nums[i+1])
            {
                breakPoint = i;
                break;
            }
        }
        if(breakPoint == -1)
            reverse(nums,0,nums.length-1);
        else
        {
            // find the element from right which is just greater than arr[breakpoint] so that we can replace arr[breakpoint] and this just largest ele from right.
            
            for(int i=nums.length-1;i>=0;i--)
            {
                if(nums[i] > nums[breakPoint])
                {
                    swap(nums, i, breakPoint);
                    break;
                }
            }
            // reverse the part of array from breakpoint+1 to end of arr i.e the ele where we found arr[i]<arr[i+1], then we reverse from i+1 to end of array.
            reverse(nums,breakPoint+1,nums.length-1);   
        }
        
    }
    
    private void reverse(int nums[], int start, int end)
    {
        
        while(start<=end)
        {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
