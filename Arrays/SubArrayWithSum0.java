/**
 * https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
 * 
 * The idea is to iterate through the array and for every element arr[i], calculate the sum of elements from 0 to i (this can simply be done as sum += arr[i]). 
 * If the current sum has been seen before, then there is a zero-sum array. 
 * i.e let arr[] = {1, 4, -2, -2, 5, -4, 3}
    If we consider all prefix sums, we can notice that there is a subarray with 0
    sum when :
    1) Either a prefix sum repeats or
    2) Or prefix sum becomes 0.

    Prefix sums for above array are:
    1, 5, 3, 1, 6, 2, 5
 
    Since prefix sum 1 repeats, we have a subarray with 0 sum.
 * 
 */

package Arrays;

import java.util.HashSet;

public class SubArrayWithSum0 {

    static boolean findsum(int arr[],int n)
    {
        
        HashSet< Integer > set = new HashSet<>();
        int sum = 0;
        for (int a : arr) 
        {
            sum += a;       // Add current element to sum
            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash map
            if (set.contains(sum) || a == 0 || sum == 0) return true;
               set.add(sum);
        }
    return false;
        
    }
    
}
