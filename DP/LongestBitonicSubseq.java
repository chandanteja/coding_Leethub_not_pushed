/**
 * https://www.youtube.com/watch?v=CZ8eM2f3_gY
 * https://www.youtube.com/watch?v=TWHytKnOPaQ
 * https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/
 * 
 * This problem is a variation of LIS.
 * Do LIS from left to right in given array and do LDS from right to left.
 * length of longest bitonic subseq = length of LIS + length of LDS -1 (we are doing -1 bcz we are adding an element twice.)
 * 
 *  Time Complexity: O(n^2) 
    Auxiliary Space: O(n)
 */

package DP;

import java.util.Arrays;

public class LongestBitonicSubseq {

    public static int LongestBitonicSequence(int[] nums)
    {
        int n = nums.length;
        int lis[] = new int[n]; // lis[i] stores the length of the Longest Increasing subsequence ending with arr[i]
        int lds[] = new int[n]; // lds[i] stores the length of the longest Decreasing subsequence starting from arr[i]
        //return the max value of lis[i] + lds[i] – 1 where i is from 0 to n-1.
        
        Arrays.fill(lis,1);
        Arrays.fill(lds,1);
        
        // doing lis
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j] < nums[i] && lis[i] < lis[j]+1)
                    lis[i] = lis[j]+1;
            }
        }
        
        // doing lds
        for(int i=n-2;i>=0;i--)
        {
            for(int j=n-1;j>i;j--)
            {
                if(nums[j] < nums[i] && lds[i]<lds[j]+1)
                    lds[i] =lds[j]+1;
            }
        }

        int max=0;
        // doing length of lis+length of lds -1 and also keeping track of max length possible.
        for(int i=0;i<n;i++)
        {
            lis[i] = lis[i]+lds[i]-1;
            if(max<lis[i])
                max=lis[i];
        }
        return max;
    }

    public static void main (String[] args)
    {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        
        System.out.println("Length of LBS is "+ LongestBitonicSequence( arr ));
    }
    
}
