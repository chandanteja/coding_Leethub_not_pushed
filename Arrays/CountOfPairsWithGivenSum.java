/**
 * 
 * https://www.geeksforgeeks.org/count-pairs-with-given-sum/
 * 
 */

package Arrays;

import java.util.HashMap;

public class CountOfPairsWithGivenSum {

    // Returns number of pairs in arr[0..n-1] with sum equal
    // to 'sum'
    static int getPairsCount(int arr[],int n, int sum)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
 
        // Initially Store counts of all elements in map hm
        for (int i = 0; i < n; i++) {
 
            // initializing value to 0, if key not found
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 0);
 
                // update count by '1' if element is present.
            hm.put(arr[i], hm.get(arr[i]) + 1);
        }
        int count_pairs = 0;
 
        // iterate through each element of array and increment the
        // count (Notice that every pair is counted twice)
        for (int i = 0; i < n; i++) {
            if (hm.get(sum - arr[i]) != null)       // if sum-arr[i] is not null it means it is present in map, so we will add the count of that element (sum-arr[i]).
                count_pairs += hm.get(sum - arr[i]);    
 
            // if (arr[i], arr[i]) pair satisfies the
            // condition, then we need to ensure that the
            // count is decreased by one such that the
            // (arr[i], arr[i]) pair is not considered i.e if sum=4 then (2,2) satisfies the condition. Here the same element arr[i] =2 is considered as pair, so we remove theat.
            if (sum - arr[i] == arr[i])
                count_pairs--;
        }
 
        // return the half of count_pairs as we count each pair twice i.e (1,2)  and (2,1) both are counted but they are same.
        return count_pairs / 2;
    }
    
}
