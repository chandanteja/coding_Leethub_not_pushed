/**
 * https://www.youtube.com/watch?v=UogHvfQ3e18 --> watch this video for both O(n^2) and O(n) time complexities solution. For clear understanding
 * 
 * https://www.geeksforgeeks.org/longest-alternating-subsequence/
 * 
 * Logic is we can have alternating subsequence as      min,max,min,max,min ... so on. or  max,min,max,min,max... so on. These are the 2 alternating subsequences possible.
 * So, we will have to store two sequences as said above.
 * 
 */

package DP;

public class LongestAlternatingSubsequence {

    // O(n^2) solution
    public static int longestAlternateSubseq2D(int[] nums)
    {
        int n = nums.length;

        if(n==1)
            return 1;   // single element is considered as alternating subseq.  

        int dp[][] = new int[n][2]; // dp-state: dp[i][0] = Length of the longest alternating subsequence  ending at index i and last element in subseq is greater than its previous element 
        // dp[i][1] = Length of the longest alternating subsequence ending at index i and last element in subseq is smaller than its previous element.

        for(int i=0;i<n;i++)
        {
            dp[i][0]=1;
            dp[i][1]=1;
        }

        int max=0;
        // This problem is same as LIS.
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                /*                     i
                                      /
                                     /
                        dp[i][0] = j    ( arr[j] < arr[i] )

                        dp[i][1] = j    ( arr[j] > arr[i] )
                                    \
                                     \
                                      i
                */
                // here always i- is current ele and j- is previous ele for considered current ele.
                if(nums[i]>nums[j] &&  dp[i][0] < dp[j][1]+1 )      // if current element i.e nums[i] is bigger than elements before/previous to -i
                    dp[i][0] = dp[j][1]+1;                          // then its case-1 in above figure so, we check if length of not considering current ele dp[i][0] is
                                                // is smaller than when the arr[j] (previous ele) is considered then we update current ele length as 1+previous element length which is dp[j][1] (as previous ele is smaller than curr ele)
                else if(nums[i]<nums[j] && dp[i][1] < dp[j][0]+1)   // same logic as above.
                    dp[i][1] = dp[j][0]+1;

            }
            max= Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }

    // if we keenly observe, we are using only last 1-element in both columns of dp[][] at any time for updating longest length.
    // So we can optimize the solution further on space and time
    // S.C : O(1) and T.C: O(n).

// In the above approach, at any moment we are keeping track of two values (Length of the longest alternating subsequence ending at index i, and last element is smaller than or greater than previous element), for every element on array. To optimise space, we only need to store two variables for element at any index i. 

// lastMax = Length of longest alternative subsequence so far with current value being greater than it’s previous value.
// lastMin = Length of longest alternative subsequence so far with current value being smaller than it’s previous value.

    public static int longestAlternateSubseqOptimized(int[] arr)
    {
        int lastMax=1;  // keeps track of last element length of LAS which is smaller than curr element  i.e same as dp[i][0] in above case.
        int lastMin=1;  // keeps track of last element length of LAS which is larger than curr element  i.e same as dp[i][1] in above case.
        // i is current element and j is prev ele in above 2d case

        for(int i=1;i<arr.length;i++)
        {
            if(arr[i-1]>arr[i])
                lastMin = lastMax+1;
            else if(arr[i-1]<arr[i])
                lastMax = lastMin +1;

        }
        return Math.max(lastMax,lastMin);
    }

    public static void main(String[] args)
    {
        int[] arr = { 10, 22, 9, 33, 49,
                               50, 31, 60 };
       // int n = arr.length;
       
        // Function Call
        System.out.println("optimized soln: "+longestAlternateSubseqOptimized(arr));

        System.out.println("2D soln: "+longestAlternateSubseq2D(arr));
    }
    
    
}
