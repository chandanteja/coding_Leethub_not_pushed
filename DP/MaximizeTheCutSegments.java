/**
 * https://www.youtube.com/watch?v=O0N4xn38Ncg  --> watch this.
 * https://www.geeksforgeeks.org/maximize-the-number-of-segments-of-length-p-q-and-r/
 * 
 * Refer gfg course video too.
 * 
 * We do recursively this.
 * Logic is given segment length = n, and 3-values say x,y,z which tells us sizes of the cuts that are allowed.
 * We recursively subtract x,y and z from 'n' and maximize the total number of cuts. We store already solved subproblems using memoization.
 * 
 * Time Complexity: O(N). 
 * Auxiliary Space: O(N)
 * 
 */

package DP;

import java.util.Arrays;

public class MaximizeTheCutSegments {
    
    public static int maxCuts(int n ,int x,int y,int z,int dp[])
    {
        if(dp[n]!=-1)       // if the value of dp[n] !=-1 it means it has be updated with correct value. So return it.
            return dp[n];
        // Initialize 3-variables which needs to be used for storing the return values of 3-subproblems when x,y,z are subtracted from 'n'.
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        
        if(x<=n)
          a = maxCuts(n-x,x,y,z,dp);   // if x<=n i.e 'n' can accommodate 'x' sized cut (value) then we remove it, if 'n' cant then we won't go into this step.
        if(y<=n)
            b = maxCuts(n-y,x,y,z,dp);  // if y<=n i.e 'n' can accommodate 'y' sized cut (value) then we remove it, if 'n' cant then we won't go into this step.
        if(z<=n)
            c = maxCuts(n-z,x,y,z,dp);  // same as above two.
        dp[n] = 1+ Math.max(a,Math.max(b,c));      // we update the dp[n] value with 1+ max of above 3-values obtained, we add '1' bcz we are counting number of cuts and hence, 
                                    // when we go from n to n-x, 1-cut gets added, same with n to n-y, same for 'z' so we take max of 3 and add 1.
        return dp[n];

    }
    
    public static int maximizeCuts(int n, int x, int y, int z)
    {
      int dp[] = new int[n+1]; //dp[i] (dp state) tells the "maximum number segments (by cutting)" that are possible for segment of length=i.
      Arrays.fill(dp,-1);   // initialize all possible cuts count as -1 initially.
      dp[0] =0;
      int a= maxCuts(n,x,y,z,dp);
        if(a<0)
            return 0;
        else
          return a;
    }

    public static void main(String[] args)
    {
        int l = 11, p = 2, q = 3, r = 5;
 
        // Calling Function
        int ans = maximizeCuts(l, p, q, r);
        System.out.println("Max segments: " + ans);
    }

}
