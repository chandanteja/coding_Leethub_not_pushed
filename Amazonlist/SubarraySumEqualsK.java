/**
 * 
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * 
 * Naive
 * ======
 * 
 * Algorithm

Instead of considering all the start and end points and then finding the sum for each subarray corresponding to those points, we can directly find the sum on the go while considering different end points. i.e.
 We can choose a particular start point and while iterating over the end points, we can add the element corresponding to the end point to the sum formed till now. Whenever the sum equals the required k value, we can update the countcount value. 
We do so while iterating over all the end indices possible for every start index. Whenever, we update the start index, we need to reset the sum value to 0.
 * 
 * 
 * 
 *  public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    T.C : O(n^2)
    S.C : O(1).

 * 
 */

package Amazonlist;

import java.util.HashMap;

/*

Using Hashmap
Algorithm
==============

The idea behind this approach is as follows: If the cumulative sum(represented by sum[i] for sum up to ith index) up to two indices is the same, the sum of the elements lying in between those indices is zero. Extending the same thought further, if the cumulative sum up to two indices, say i and j is at a difference of k i.e. if sum[i] - sum[j] = k, the sum of elements lying between indices i and j is k.

Based on these thoughts, we make use of a hashmap mapmap which is used to store the cumulative sum up to all the indices possible along with the number of times the same sum occurs. We store the data in the form:  (sum_i, no. of occurrences of sum_i). 
We traverse over the array nums and keep on finding the cumulative sum. Every time we encounter a new sum, we make a new entry in the hashmap corresponding to that sum. If the same sum occurs again, we increment the count corresponding to that sum in the hashmap. Further, for every sum encountered, we also determine the number of times the sum sum-k has occurred already, since it will determine the number of times a subarray with sum k has occurred up to the current index. We increment the count by the same amount.

After the complete array has been traversed, the countcount gives the required result.

*/

public class SubarraySumEqualsK {

    // logic is same as find subarray with sum=0. If we get sum[i] == sum[j] then the elements b/w indices i and j would have summed up to 0.
    // We use same logic here. We store (sum,no. of occurrences of sum) in map. if 'sum= p' is occured once and again same 'sum=p' is seen, it means the given value 'k' is seen in between.
    // so we take the number of occurrences of sum and add to result.
    public int subarraySum(int[] nums, int k) {
        
        int count=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int sum=0;
        hm.put(0,1);    // initial value. DON'T FORGET THIS
        
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            
            if(hm.containsKey(sum-k))
                count+=hm.get(sum-k);
            
            if(hm.containsKey(sum))
                hm.put(sum, hm.get(sum)+1);
            else
                hm.put(sum,1);
            
        }
        
        return count;
        
    }
    
}
