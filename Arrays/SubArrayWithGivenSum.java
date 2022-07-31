/**
 * 
 * https://www.youtube.com/watch?v=Ofl4KgFhLsM
 * 
 * https://www.geeksforgeeks.org/find-subarray-with-given-sum/
 * 
 * Logic is we take two pointers i & start.
 * 
 * Using  'i' we will add all the elements till we get current sum value greater than or equal to given sum.
 * 
 * If current_sum crosses given sum then we will remove elements from the starting of array using 'start' pointer, and if we get sum==given sum,
 * then we will note the position of start pointer and pointer-i, and return, if we never get sum==given sum we will return -1.
 * 
 */

package Arrays;

import java.util.ArrayList;

public class SubArrayWithGivenSum {

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        int i=1,start=0;
        int sum = arr[0];
        
        while(i<n && sum!=s)
        {
            if(sum==s)  // check if sum == given sum
                break;
            else if(sum<s)  // if sum is lessthan given sum then add ith ele.
                sum = sum+arr[i++]; 
            else        // if sum is greaterthan given sum then remove ith ele.
                sum = sum-arr[start++];
            
        }
        while(sum>s)        // if sum is greaterthan given sum then remove ith ele.This case can happen when we reach the end of array and we break out of above loop and sum is > greater than given sum.
            sum=sum-arr[start++];
        if(sum==s)      // if sum==given sum, then note down start and end points,
        {
            res.add(start+1);
            res.add(i);
        }   
        else
            res.add(-1);
        
        return res;
    }
    
}
