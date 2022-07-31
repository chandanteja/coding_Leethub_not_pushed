/**
 * https://www.youtube.com/watch?v=VwjKZQCaTC8  --> watch this video for below process.
 * 
 * Time Complexity: O(n^2). 

    Auxiliary Space: O(n^2). 
 * 
 */

package DP;

import java.util.Arrays;

public class OptimalStrategyInGame {

    static long optimalStrategy(int i,int j,int arr[],long dp[][])
    {
        if(i>j) // if i crosses j it means we have processes entire array to mid of it as i and j at same pace.
            return 0;
        if(dp[i][j]!=-1)    // if (i,j) max value  is memoized use it.
            return dp[i][j];
            
            // logic is we can take either arr[i] or arr[j] (i points at first and j points at last).
            // sat arr[] is {8,15,3,7}, we can choose 8 or 7 and if we choose 8 then array is {15,3,7} then opponent gets 15 and we are left with-7.
            // So we assume opponent picks maximum value always in his turn (to maximize his profit), so then we are left with min value as opponent picks maximum.
            // so if we take arr[i] then opponent can take either arr[i+1] or arr[j]. so that is the reason why we check both cases as (i+2,j) here opponent chose arr[i+1]
            // and (i+1,j-1) ==> here opponent chose arr[j] so we decreased j by 1.

        long choseLeft = arr[i] + Math.min(optimalStrategy(i+2,j,arr,dp),optimalStrategy(i+1,j-1,arr,dp));

        // if we took arr[j] the opponent can choose arr[j-1] the we need to check in (i,j-2) or opponent can choose i then we can checck in (i+1,j-1)
        long choseRight = arr[j] +  Math.min(optimalStrategy(i,j-2,arr,dp),optimalStrategy(i+1,j-1,arr,dp));
        dp[i][j] = Math.max(choseLeft,choseRight);  // as we want to maximize out profit, we need to choose max.
        return dp[i][j];
    }
    
    static long optimalStrategyOfGame(int arr[], int n)
    {
        //dp(i, j) represents the maximum value the user can collect from i'th coin to j'th coin i.e  using (i..j) coins.   
        long dp[][] = new long[n][n];
        for(long arr1[]: dp)
            Arrays.fill(arr1,-1);
        return optimalStrategy(0,n-1,arr,dp);
    }
    
    public static void main(String[] args)
    {
        int arr1[] = { 8, 15, 3, 7 };
        int n = arr1.length;
        System.out.println( "arr1: " + optimalStrategyOfGame(arr1, n));
 
        int arr3[] = { 20, 30, 2, 2, 2, 10 };
        n = arr3.length;
        System.out.println( "arr3: " + optimalStrategyOfGame(arr3, n));
    }
}
