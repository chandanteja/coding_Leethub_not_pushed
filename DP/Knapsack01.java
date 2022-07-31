/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * The state DP[i][j] will denote maximum value possible for 'j' amount of weight considering all values from ‘1 to i’ ele in given arrays.
 * This is same as Subset sum problems. Refer subset sum problems also.
 * 
 *  Time Complexity: O(N*W). 
 *  Auxiliary Space: O(N*W). 
 */

package DP;

import java.util.Arrays;

public class Knapsack01 {

    static int maxProfit(int W,int wt[],int val[],int n, int dp[][])
    {
        if(n==0 || W==0)
            return 0;
        if(dp[n][W]!=-1)
            return dp[n][W];
        if(wt[n-1]<= W) // if wt[i] <=W then check if adding ith wt and its value gives max profit or not adding ith wt and its value gives max profit
            dp[n][W] = Math.max(val[n-1]+maxProfit(W-wt[n-1],wt,val,n-1,dp) , maxProfit(W,wt,val,n-1,dp));  // here (n-1) is there bcz we remove that item from our consideration for next iterations
            
            
       else // if wt[i] > W means we cant consider ith object and its value in our profit, so we check wat is the profit possible possible by not taking ith wt and its value.
              dp[n][W] = maxProfit(W,wt,val,n-1,dp);
            
        return dp[n][W];
        
    }
    
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int dp[][] = new int[n+1][W+1];    //The state dP[i][j] will denote maximum profit value possible for wt=j considering all values from ‘0..i-1’ ele in given arrays.
         for(int arr[] : dp)
            Arrays.fill(arr,-1);
        
        return maxProfit(W,wt,val,n,dp);
    } 

    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println("Max profit is: "+ knapSack(W, wt, val, n));
    }
    
}
