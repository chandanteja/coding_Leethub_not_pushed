/**
 *  
 * https://www.geeksforgeeks.org/count-balanced-binary-trees-height-h/
 * 
 * 
 *      it will be balanced binary tree when |left-right|<=1
                h-1, h-2
                h-2, h-1
                h-1, h-1

            count(h) = count(h-1)*count(h-2) + count(h-2)*count(h-1) + count(h-1)*count(h-1)

            we are multiplying count(h-1) and count(h-2) because we want all possible combinations.

            count(h) = 2*count(h-1)*count(h-2) + count(h-1)*count(h-1)
                     = count(h-1) * [2*count(h-2) + count(h-1)]
 * 
 */

package DP;

public class CountNumberOfBalanceBTs {

    static long countBT(int h){
        long dp[] = new long[h+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2;i<=h;i++)
        {
            dp[i]= ( dp[i-1]%1000000007 * ( (2*dp[i-2])%1000000007 + dp[i-1]%1000000007)%1000000007 )%1000000007;
        }
        return dp[h];
    }
    
}
