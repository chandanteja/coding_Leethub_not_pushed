/**
 * 
 *  https://www.geeksforgeeks.org/count-number-ways-reach-given-score-game/
 * 
        if n=13.

        0	1	2	3	4	5	6	7	8	9	10	11	12	13
        1	0	0	1	0	1	1	0	1	1	1+1=2 	1	1	1+1=2 

        table[i] = numbers of ways to form the count i.

        first check for all 3 multiples, then 5 multiples, then 10 multiples.

        for n=10:   10-3 NO. 
                    10-5 = 5 dp[5]=1 dp[10]+=dp[5] = 1
                    10-10 = 0 dp[0]=1 dp[10]+=dp[0] = 2
    
 */


package DP;

import java.util.Arrays;

public class WaysToReachGivenScore {

    public long count(int n) {
        long[] dp = new long[(int)n+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;      // Base case (If given value is 0)
        

        // One by one consider given 3
        // moves and update the table[]
        // values after the index greater
        // than or equal to the value of
        // the picked move
       for(int i=3;i<=n;i++)
            dp[i] = dp[i]+dp[i-3];
        for(int i=5;i<=n;i++)
            dp[i] = dp[i]+dp[i-5];
        for(int i=10;i<=n;i++)
             dp[i] = dp[i]+dp[i-10];
    
        
        return dp[n];
    }
    
}
