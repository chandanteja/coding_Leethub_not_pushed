/**
 * 
 * https://www.geeksforgeeks.org/count-derangements-permutation-such-that-no-element-appears-in-its-original-position/
 * 
 * Derangements(n) = (n-1)*[Derangements(n-1) + Derangements(n-2)] --> formula.
 * This qns is same as fibonacci 
 * 
 */
package DP;

public class CountDerangements {

    public static int countDerangements(int n)
    {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for(int i=3;i<=n;i++)
        {
            dp[i] = (i-1)*(dp[i-1]+dp[i-2]);
        }
        return dp[n];
    }

    public static void main (String[] args)
    {
        int n = 4;
        System.out.println( "Count of Derangements is " + countDerangements(n));
 
    }
    
}
