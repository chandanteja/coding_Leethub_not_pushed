/**
 * https://www.youtube.com/watch?v=S1nStf-TM6c
 * In unbounded knapsack we can pick same weight multiple times.
 * 
 *      let W=100, val = {1,30} ,wt = {1,50}, find max profit.
 *      n=2
 *                fun(100,2, wt,val)
 *             /                      \
 *            /                        \
 *  fun(100-50,2,wt,val)              fun(100,1,wt,val)    (here '50' is not considered, so wt==100 only but as '50' is not considered, size of wt[] got decreased by '1')
 *  (here '50' is considered
 *   but 'n=2' is not decremented
 *   as we can tkae '50' again)
 *          /             \                          /              \
 *         /               \                        /                \
 *   fun(50-50,2,wt,val)  fun(50,1,wt,val)       fun(100-1,1,wt,val)     fun(100,0,wt,val)
 * 
 * Here, logic is if a wt is considered as part of knapsack, then we need not remove it from wt[] i.e it can be picked up again.
 *  If we ignore the wt at anytime, then we shuld remove it from wt[] as we wont pick it up in future too.
 *     
 */

package DP;

import java.util.Arrays;

public class UnboundedKnapsack {

    static int knapSack(int n, int W, int val[], int wt[])
    { int dp[][] = new int[n+1][W+1];
        
        for(int arr[] : dp)
         Arrays.fill(arr,-1);
        
        return maxProfit(W,wt,val,n,dp);
    }
    
     static int maxProfit(int W,int wt[],int val[],int n, int dp[][])
    {
        if(n==0 || W==0)
            return 0;
        if(dp[n][W]!=-1)
            return dp[n][W];
        if(wt[n-1]<= W)
            dp[n][W] = Math.max(val[n-1]+maxProfit(W-wt[n-1],wt,val,n,dp) , maxProfit(W,wt,val,n-1,dp));    // this is the only line which differs from classical knapsack problem.
                    // here if we picked up wt[n-1], we wont remove it from wt[] and hence we send same value of 'n' and if we dont pick it at anytime, then it is removed from wt[] then we call with 'n-1'
            
       else
              dp[n][W] = maxProfit(W,wt,val,n-1,dp);    // this is same as classical knapsack i.e if we dont pick an item (as W < wt[n]), we remove it from wt[] as we wont consider it in future.
            
        return dp[n][W];
        
    }
    
}
