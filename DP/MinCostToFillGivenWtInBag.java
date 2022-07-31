/**
 * https://www.youtube.com/watch?v=skf0qDzSJsQ  --> solvedd using 2d array.
 * 
 * This problem is same as 0/1 Knap-sack. But in knapsack we need to maximize cost in this we need to minimize the cost.
 * Same as knapsack and subset sum problem.
 * 
 */

package DP;

public class MinCostToFillGivenWtInBag {

    public int minimumCost(int cost[], int n,int w)
	{
    	int dp [] = new int [w+1];  // dp-state: dp[i] = min cost possible for weight = i-kg.
	
    	for(int i =1 ;i<=w;i++) // i-loops on all possible weights from 1 ..w
        {    // we iterate for all possible weigghts from 1 to w.
    	    int min  = Integer.MAX_VALUE;       // initialization.
    	    for(int j=1 ; j<=n;j++)         // loops on all possible elements in cost-array.
    	    {
    	        if(cost[j-1]!=-1 && j<=i)   // cost of considered wt == -1 means that wt is not available for choosing. So we ignore them.
    	            min = Math.min(min , (dp[i-j] == Integer.MAX_VALUE)? Integer.MAX_VALUE :cost[j-1] + dp[i-j] );	
                    // cost[j-1]+dp[i-j] means we have removed a weight of j from i and we take subproblem cost and also as weight=j is considered we are adding cost of wt=j.        
    	    }
    	    dp[i] = min ;   // updating dp[i] value.
    	}
    	return dp[w]==Integer.MAX_VALUE?-1:dp[w];   // return dp[w] for min wt.
     
	}
    
}
