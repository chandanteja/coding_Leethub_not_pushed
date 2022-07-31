/**
 * https://leetcode.com/problems/sort-colors/
 * 
 * https://www.cs.cornell.edu/courses/JavaAndDS/files/sort9DutchFlag.pdf
 * 
 * Refer this pdf and also the comments below
 */

class SortColors {
    public void sortColors(int[] nums) {
        
        // here we maintain 3 partitions in the array at any point of time. red points right of the last red element seen i.e it will be pointing to the first white element in the array.
        //blue will be pointing to first blue just before the first element.
        // curr will be iterating between start to blue ptr.
        int red=0,curr=0,blue=nums.length-1;
        
        while(curr<=blue) 
        {
            // at any point of time in the array if curr points to an ele. '0' it needs to be placed at the start of the array so we need to excahnge with the ele. pointed by red pointer. As red ptr will be pointing to the first white element in arr. (our assumption), we exchange curr ele. with it. And move both red and curr ptr ahead.
            if(nums[curr] == 0) //red=0
            {
                int temp = nums[curr];
                nums[curr] = nums[red];
                nums[red] = temp;
                curr++;
                red++;
            }
            
            // if curr. ele. is white then we do nothing as it is in correct region of the arr.
           else if(nums[curr] == 1) //white=1
            {
                curr++;
            }
            //if curr element points to blue ele, then it needs to be at the end of arr, and our assumption is blue ptr will be pointing just before thr first blue ele. in the arr.
            //so we swap the curr ele. with the ele pointed by blue ptr.
            //here we move blue ptr in left direction i.e blue-- and we won't move the curr ptr bcz as already one element got replaced with blue ele, we need to place it in its correct position and we need not move curr ptr. ahead.
            else if(nums[curr] == 2) //blue=2
            {
                int temp = nums[curr];
                nums[curr] = nums[blue];
                nums[blue] = temp;
                blue--;
                
            }
        }
        
        
    }
}