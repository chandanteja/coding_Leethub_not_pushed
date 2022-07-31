/**
 * 
 * https://www.youtube.com/watch?v=C9-n_H7dsvU      --> reference
 * 
 * Refer the above video.
 * 
 * A below approach is to use Hashing.
 * 
 *  1. Maintain sum of elements encountered so far in a variable (say sum).
    2. If current sum is 0, we found a subarray starting from index 0 and ending at index current index
    3. Check if current sum exists in the hash table or not.
    4. If current sum already exists in the hash table then it indicates that this sum was the sum of some sub-array elements arr[0]…arr[i] and now the same sum is obtained for the current sub-array arr[0]…arr[j] which means that the sum of the sub-array arr[i+1]…arr[j] must be 0.
    5. Insert current sum into the hash table
 */


package SearchingAndSorting;

import java.util.HashMap;

public class ZeroSumSUbArrayCount {

    public static long findSubarray(long[] arr ,int n) 
    {
        long count=0;
        long curr_sum=0;
        int i=-1;   // we start 'i' just before array index.
        
        HashMap<Long,Long> hm = new HashMap<>();
        
        // initialization
        hm.put(0L,1L);    // this is used to update the sum when ever we get sum as 0.
        
        while(i<n-1)
        {
            i++;
            curr_sum = curr_sum+arr[i];
            
            if(hm.containsKey(curr_sum))
            {
                count=count+hm.get(curr_sum);   
                hm.put(curr_sum,hm.get(curr_sum)+1);
            }
            else
            {
                hm.put(curr_sum,1L);
            }
        }
        return count;
    }
    
}
