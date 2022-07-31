import java.util.HashMap;

/**
 * 
 * 
 * https://leetcode.com/problems/two-sum/
 * 
 * Logic is
 * 1. We take a hashmap with (key,value) as (nums[i],i (index))
 * 2. we take each element from array and check if (targetsum-nums[i]) difference is present in array i.e element-1+element-2 = targetsum ==> element-2 = sum-element-1 
 * 3. we apply above logic
 * 4. If we find both ele then we store indices in array and return.
 * 
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        
        int res[] = new int[2];
        
        HashMap<Integer,Integer> hm = new HashMap<>();  // (element,index of element) in hashmap
        
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(target-nums[i]))
            {
                res[0] = i;
                res[1] = hm.get(target-nums[i]);
            }
            hm.put(nums[i],i);
        }
        
        return res;
    }
    
}
