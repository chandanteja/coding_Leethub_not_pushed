/**
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * 
 * Also refer "Guide-to-Competitive-Programming-Learning-and-improving-Algorithms-through-Contests" T.B, DP section.
 * Logic is to find min number of coins that equal to sum = n, we need to find min number of coins need for the sub problems.
 * here dp state is, we maintain an array for all possible sums from 0 to given value.
 * let mincoins[] represnt all possible sums from 0 to given value.
 * mincoins[i] = min number of coins needed to achieve sum=i.
 * here for sub-problems consider, coins = {1,2,3}, sum =5, so sub-problems are mincoins(5) = 1+Min(mincoins(5-1),mincoins(5-2),mincoins(5-3)).
 * so, to find min number of coins needed for sum=5, we need to find min number of coins needed for 1+Min(5-1),1+min(5-2),1+min(5-3), bcz from sum=4 or sum=3 or sum=2, we can reach sum=5 by directly adding value of 1-coin.
 * 
 * Time complexity of the above solution is O(mn).
    S.C: O(n), 'n' is sum.
 * 
 */

package DP;

import java.util.Arrays;

public class MinCoinsNeededForGivenValue {


    public static int minCoins(int S[], int m, int n) 
	{ 
	    int minCoins[] = new int[n+1];  // dp-state. stores the min number of coins needed for all the sums from 0 to n.
        Arrays.fill(minCoins,Integer.MAX_VALUE-1);  // initially, we initialize min coins needed as INFINITY-1. As we add +1 in the below code. So, to avoid overflow, we take it as INFINITY-1
        minCoins[0] = 0;    // min number of coins needed for achieving sum=0 is 0.
        
        for(int i=1;i<=n;i++)   // for all possible sums from 1 to n (sum=0 is taken care above).
        {
            for(int j=0;j<m;j++)    // for all possible coin values, 
            {
                if(S[j]<=i) // if coin value is <= the sum-i then only we update its value in array.
                {
                       minCoins[i] = Math.min(minCoins[i],minCoins[i-S[j]]+1);
                       // for sum=i, min coins needed will be, if coin-j is not selected then min coins needed will be mincoins[i] itself,
                       // if coin-j is selected then min coins needed for remaining sum, we need to check i.e, mincoins[i-s[j]]+1, we add +1 bcz, from the min coins needed for i-s[j],
                       // we get min coins needed for i-s[j], now to go to sum=i, we need to add '1' more coin.
                }
            }
        }
        
        if(minCoins[n]==Integer.MAX_VALUE-1)    // if min coins needed for given sum=n is not changed return -1.
            return -1;
        
        return minCoins[n];
	} 
    
    public static void main (String[] args)
    {
        int coins[] = {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
        System.out.println ( "Minimum coins required is " + minCoins(coins, m, V));
    }

}
