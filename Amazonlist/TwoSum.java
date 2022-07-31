/**
 * 
 * https://leetcode.com/problems/two-sum/
 * 
 * Logic is here we use HashMap<> to store (element,index) pair. Here 'index' is index of element in array.
 * 
 * We take arr[i] and check (target-arr[i]) if the difference is present in hashmap<> or not. If present, we found the pair.
 * Else we insert arr[i] in hashmap<>.
 * 
 * 
 */

package Amazonlist;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        int res[] = new int[2];
        
        for(int i=0;i<nums.length;i++)
        {
            int temp = target-nums[i];  // taking targer-nums[i]

            if(hm.containsKey(temp)==false) // checking if target-nums[i] is present in hashmap<> or not.
            {
                hm.put(nums[i],i);      // if not present we insert it into map as (arr[i],i) pair.
            }
            else        // if present then we pickup the indices of those 2- elements and return.
            {
                res[0] = i;
                res[1] = hm.get(temp);
            }
            
        }
        return res;
    }
    
}
