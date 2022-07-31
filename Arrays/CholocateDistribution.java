/**
 * 
 * https://www.geeksforgeeks.org/chocolate-distribution-problem/
 * 
 * Logic is sort the array and consider two values after sorting i.e arr[i](ith value) and arr[i+m-1](mth value from 'i') . And take diff of those. Store min diff.
 */

package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class CholocateDistribution {

    // arr[0..n-1] represents sizes of
    // packets. m is number of students.
    // Returns minimum difference between
    // maximum and minimum values of
    // distribution.
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        // if there are no chocolates or
        // number of students is 0
         if(m==0 || n==0)
            return 0;

        // Number of students cannot be
        // more than number of packets
        if (n < m)
           return -1;
            
        Collections.sort(a);
       // int size=a.size();
        long min_diff=Integer.MAX_VALUE;


        // Find the subarray of size m
        // such that difference between
        // last (maximum in case of
        // sorted) and first (minimum in
        // case of sorted) elements of
        // subarray is minimum.
        for (long i = 0; (i + m - 1) < n; i++)
        {
            long diff = a.get((int)(i+m-1)) - a.get((int)i);
            min_diff = Math.min(min_diff,diff);
        }
        return min_diff;
    }
    
}
