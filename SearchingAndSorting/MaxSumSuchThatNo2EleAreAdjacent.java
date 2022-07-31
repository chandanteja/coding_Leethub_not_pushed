/**
 * 
 * https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1#     ---> qns
 * 
 * 
 * https://www.youtube.com/watch?v=49RVi7m94LE      --> soln.
 * 
 * Logic is every element has 2-possibilities i.e either pick the element or dont pick the element.
 * 
 * So if we pick ith ele then we cant pick (i+1)th ele, so we can pick only (i+2)th ele. 
 * If we dont pick ith ele then we can pick (i+1)th ele.
 * 
 * So, we code the above 2-cases.
 * 
 */


package SearchingAndSorting;

import java.util.Arrays;

public class MaxSumSuchThatNo2EleAreAdjacent {

    public int FindMaxSum(int arr[], int n)
    {
        int dp[] = new int[n];      // dp[i] --> tells what is the max sum possible by following the given rule by considering till ith element only in given array.
        Arrays.fill(dp,-1); 
        
        solve(arr,n-1,dp);
        
        return dp[n-1];
    }
    
    public int solve(int arr[],int i,int dp[])
    {
        if(i<0)
            return 0;
        if(dp[i]!=-1)           // if dp[i]!=-1 then dp[i] is allready calculated so return it. ---> memoization
            return dp[i];
        
        int a = arr[i]+solve(arr,i-2,dp);     // as we picked ith ele, now we cant pick (i+1)th ele, so we pick (i+2)th ele. Here we are traversing array from the end, that is y we do (i-1) and (i-2)
        int b = solve(arr,i-1,dp);  // ith ele is not picked.
        
        return dp[i] = Math.max(a,b);
        
    }
    
}
