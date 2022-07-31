/**
 * 
 *  https://leetcode.com/problems/first-missing-positive/
 * 
 * https://www.youtube.com/watch?v=TJNVBGUt5hY      --> refer this for basic intuition
 * 
 * https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
 * 
 * Segregate all negatives to one side and all positives to oneside.
 * 
 * Change the sign (i.e positives numbers to negative numbers) of all positive numbers by considering them as indices in the array.
 */

package MorganStanleyList;

public class FirstMissingPositiveNum {

    public int firstMissingPositive(int[] nums) {
        
        int pIndex = 0; // keeps track of last positive number in consecutive set of positive nums at the front of array
        
        int temp;
        
        // move all positive elements to left end of array.
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                temp = nums[i];
                nums[i] = nums[pIndex];
                nums[pIndex] = temp;
                pIndex++;
            }
        }
        
       
        // we use positive numbers as indices (hashing) and negate the positive elements present at that index. Here indices are numbers of arr
        // i.e if arr[i] ==3 then we do arr[arr[i]] and negate the positive element at index '3'
        for(int i=0;i<pIndex;i++)
        {
            int ele = Math.abs(nums[i]);
            // doing ele-1 as 'ele-1' will be used for indexing and array indices start from 0.
            if(ele-1 < pIndex && nums[ele-1]>=0)    // here we are doing ele-1 as indices start from '0', so for any ele, we do ele-1 so that it can be indexed.
            {
                nums[ele-1] = -nums[ele-1];
            }
            
        }
        
        int i;
        // 'pIndex' points to first negative number and pIndex-1 is the last positive number.
        // loop from '0' to 'pIndex' and checck if there is any positive number. If present then the index of that number+1 will be our ans.
        // as we are doing arr[arr[i]] = -arr[arr[i]]   --> means using arr[i] as index we are negating the element at arr[arr[i]]. So if any +ve element is not negated then it means there is no element to reach that index.
        for( i=0;i<pIndex;i++)
        {
            if(nums[i]>0)
                return i+1;
        }
        // this happens when all positive numbers at the front of arr[]  got changed to negative numbers and hence next largest ele is pIndex.  
        // i.e if all positive nums at front of arr is negated then next positive number will be the index value of last positive number +1.
        // {1,4,2,3,-2,-4,0,-5} --> {-1,-4,-2,-3,-2,-4,0,-5} --> now pIndex would have been pointing to 2nd '-2' in modified arr.
        // so that is the reason why we will return i+1
        if(pIndex>0)
            return i+1;

        return 1;   // if all elemsgiven are negative number in array i.e given array doesnt have positive ele. 
    }
    
}
