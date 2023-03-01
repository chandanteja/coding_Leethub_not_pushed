import java.util.HashMap;

/**
 * 
 * Qns: https://leetcode.com/problems/min-cost-climbing-stairs/description/
 * 
 */

public class MinCostClimbingStairs {

    /**
     * 
     * Logic is , to reach ith step on the stair, we can either reach (i-1)th step and reach ith step or reach (i-2)th step and reach ith step.
     * So, to reach ith step our recurrence depends on these 2 values.
     * 
     * DP State: dp[i] is the minimum cost of reaching ith step ( we don'tinclude the cost of ith step in dp[i], as it is only the cost for reaching but not leaving ith step.)
     * ========
     * 
     * base cases:
     * ===========
     * dp[0]=dp[1] = 0, because minimum cost of reaching 0th or 1st step is 0 ( only reaching 0th or 1st step. It don't include the cost of 0th or 1st step cost.)
     * 
     * Recurrence:
     * ============
     * dp[i] = min{ dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]}  
     * Note: we are adding the cost[i-1] or cost[i-2], to dp-state bcz dp[i] is min. cost of reaching ith step but it don't include the cost of ith step.
     * So, we reach ith step, we can either come from i-1 or i-2 step. 
     * So dp[i-1] is cost of reaching (i-1)th step and it don't include the cost of (i-1)th step itself. So we add it. 
     * Same for (i-2) as well.
     * 
     * @param cost
     * @return
     */
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        dp[0]=dp[1]=0;
        for(int i=2;i<=n;i++) {
            int oneStep = dp[i-1] + cost[i-1];
            int twoStep = dp[i-2] + cost[i-2];
            dp[i] = Math.min(oneStep,twoStep);
        }
        return dp[n];
    }

    /**
     * 
     * Space optimized approach of the above code is as below.
     * 
     */

     public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int oneStep = 0;
        int twoStep = 0;
        for (int i = 2; i <=n ; i++) {
            int temp = oneStep;
            oneStep = Math.min(oneStep + cost[i - 1], twoStep + cost[i - 2]);
            twoStep = temp;
        }
        return oneStep;
    }

    /**
     * Recursive version.
     * 
     * Recurrence Relation: f(i) = min{ f(i-1)+cost[i-1], f(i-2)+cost[i-2] }
     * 
     * Define a hash map memo, where memo[i] represents the minimum cost of reaching the ith step.
       Define a function minimumCost, where minimumCost(i) will determine the minimum cost to reach the ith step.
       In our function minimumCost, first check the base cases: return 0 when i == 0 or i == 1. 
       Next, check if the argument i has already been calculated and stored in our hash map memo. 
       If so, return memo[i]. Otherwise, use the recurrence relation to calculate memo[i], and then return memo[i]
     */

     private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

     public int minCostClimbingStairs2(int[] cost) {
         return minimumCost(cost.length, cost);
     }
 
     private int minimumCost(int i, int[] cost) {
         // Base case, we are allowed to start at either step 0 or step 1
         if (i <= 1) {
             return 0;
         }
 
         // Check if we have already calculated minimumCost(i)
         if (memo.containsKey(i)) {
             return memo.get(i);
         }
 
         // If not, cache the result in our hash map and return it
         int downOne = cost[i - 1] + minimumCost(i - 1, cost);
         int downTwo = cost[i - 2] + minimumCost(i - 2, cost);
         memo.put(i, Math.min(downOne, downTwo));
         return memo.get(i);
     }
}
