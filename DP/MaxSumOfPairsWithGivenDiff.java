/**
 * 
 * https://www.geeksforgeeks.org/maximum-sum-pairs-specific-difference/     --> refer this.
 * 
 */

package DP;

import java.util.Arrays;


/*
            first sort all the values, then we will have max at right most side. we want max value so we move from right to left.

            and we will check if difference b/w i and i-1th element is less than K. 
            if less than K then add to our total.
            else we will move backward by 1 position and check the diff again. 

        */

public class MaxSumOfPairsWithGivenDiff {

    public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) 
    {
        int maxTotal =0;
        
        // Sort elements to ensure every i and i-1 is
        // closest possible pair
        Arrays.sort(arr);
        
        // To get maximum possible sum,
        // iterate from largest
        // to smallest, giving larger
        // numbers priority over
        // smaller numbers.
        for(int i=N-1;i>0;i--)
        {

            // Case I: Diff of arr[i] and arr[i-1] is less
            // then K, add to maxSum
            // Case II: Diff between arr[i] and arr[i-1] is
            // not less then K, move to next i
            // since with sorting we know, arr[i]-arr[i-1] <
            // arr[i]-arr[i-2] and so on.
            if(arr[i]-arr[i-1]<K)
            {
                maxTotal = maxTotal+arr[i];
                maxTotal = maxTotal+ arr[i-1];
                i--;        // we r dng this because we want disjoint sets -- so we are considering i and i-1 elements so we shudnt consider
                // i-1th elt also. so again i--.
            }
        }
        return maxTotal;
    }
    
}
